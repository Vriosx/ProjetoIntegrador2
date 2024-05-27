package modeloPdv.DAO;

import ModeloPdv.models.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Date;

public class ClienteDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/superMercado";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "7423";

   public static boolean salvar(Cliente cliente) {
    boolean isSaved = false;

    String sql = "INSERT INTO cliente(nomeCliente, endereco, CPF, telefone, email, sexo, estadoCivil, dataNascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);
         PreparedStatement comandoSQL = conexao.prepareStatement(sql)) {

        comandoSQL.setString(1, cliente.getNomeCliente());
        comandoSQL.setString(2, cliente.getEndereco());
        comandoSQL.setString(3, cliente.getCPF());
        comandoSQL.setString(4, cliente.getTelefone());
        comandoSQL.setString(5, cliente.getEmail());
        comandoSQL.setString(6, cliente.getSexo());
        comandoSQL.setString(7, cliente.getEstadoCivil());
        comandoSQL.setString(8, cliente.getDataNascimento());

        int linhasAfetadas = comandoSQL.executeUpdate();
        isSaved = linhasAfetadas > 0;

    } catch (SQLException ex) {
        Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, "Error saving client", ex);
    }

    return isSaved;
}

   public static Cliente buscarPorCpf(String cpf) {
        Cliente cliente = null;
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String sql = "SELECT * FROM cliente WHERE CPF = ?";
            PreparedStatement comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setString(1, cpf);

            ResultSet rs = comandoSQL.executeQuery();
            if (rs.next()) {
                cliente = new Cliente(
                    rs.getInt("idCliente"),
                    rs.getString("nomeCliente"),
                    rs.getString("endereco"),
                    rs.getString("CPF"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("sexo"),
                    rs.getString("estadoCivil"),
                    rs.getDate("dataNascimento").toString()
                );
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return cliente;
    }

    
    private String formatarDataParaMySQL(String data) {
    try {
        SimpleDateFormat formatadorExibicao = new SimpleDateFormat("dd/MM/yyyy");
        Date dataConvertida = formatadorExibicao.parse(data);

        SimpleDateFormat formatadorBanco = new SimpleDateFormat("yyyy-MM-dd");
        return formatadorBanco.format(dataConvertida);
    } catch (ParseException e) {
        e.printStackTrace();
        return data; 
    }
}

    public static boolean alterar(Cliente cliente) {
    boolean isUpdated = false;

    String sql = "UPDATE cliente SET nomeCliente = ?, endereco = ?, CPF = ?, telefone = ?, email = ?, sexo = ?, estadoCivil = ?, dataNascimento = ? WHERE idCliente = ?";

    try (Connection conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);
         PreparedStatement comandoSQL = conexao.prepareStatement(sql)) {

        comandoSQL.setString(1, cliente.getNomeCliente());
        comandoSQL.setString(2, cliente.getEndereco());
        comandoSQL.setString(3, cliente.getCPF());
        comandoSQL.setString(4, cliente.getTelefone());
        comandoSQL.setString(5, cliente.getEmail());
        comandoSQL.setString(6, cliente.getSexo());
        comandoSQL.setString(7, cliente.getEstadoCivil());
        comandoSQL.setString(8, cliente.getDataNascimento());
        comandoSQL.setInt(9, cliente.getIdCliente());

        int linhasAfetadas = comandoSQL.executeUpdate();
        isUpdated = linhasAfetadas > 0;

    } catch (SQLException ex) {
        Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, "Error updating client", ex);
    }

    return isUpdated;
}

    public static boolean excluir(int idExcluir) {
        boolean isDeleted = false;

        String sql = "DELETE FROM cliente WHERE idCliente = ?";

        try (Connection conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement comandoSQL = conexao.prepareStatement(sql)) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            comandoSQL.setInt(1, idExcluir);
            int linhasAfetadas = comandoSQL.executeUpdate();
            isDeleted = linhasAfetadas > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, "Error deleting client", ex);
        }

        return isDeleted;
    }

    public static ArrayList<Cliente> listar() {
        ArrayList<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM cliente";

        try (Connection conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement comandoSQL = conexao.prepareStatement(sql);
             ResultSet rs = comandoSQL.executeQuery()) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("idCliente"),
                        rs.getString("nomeCliente"),
                        rs.getString("endereco"),
                        rs.getString("CPF"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("sexo"),
                        rs.getString("estadoCivil"),
                        rs.getString("dataNascimento")
                );
                clientes.add(cliente);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, "Error listing clients", ex);
        }

        return clientes;
    } //Fim do Listar
    
    public static Cliente buscarPorCPF(String cpfBuscar){
        Cliente retorno = null;
        Connection conexao = null;
        ResultSet rs = null;
        
        try{                                               //DUVIDA NESSA CONEXAAO
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, URL, PASSWORD);
            PreparedStatement instrucaoSQL = conexao.prepareStatement("SELECT * FROM Cliente WHERE CPF = ?");
            
        instrucaoSQL.setString(1, cpfBuscar);
        
        rs = instrucaoSQL.executeQuery();
        
       if(rs !=null){
           while(rs.next()){
               int id = rs.getInt("idCliente");
               String nome = rs.getString("nomeCliente");
               String cpf = rs.getString("CPF");
               String email = rs.getString("emailCliente");
               
               retorno = new Cliente(id, nome, email, cpf);
               
           }
           
       }
            
    }catch(Exception e){
        retorno = null;
    }finally{
            if(conexao!= null){
                try {
                    conexao.close();
                    }catch (SQLException ex){
                        Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        }
        
        return retorno;
       
    }
    

    public static ArrayList<Cliente> buscarPorNomeCliente(String nomeCliente) {
        ArrayList<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM cliente WHERE nomeCliente = ?";

        try (Connection conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement comandoSQL = conexao.prepareStatement(sql)) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            comandoSQL.setString(1, nomeCliente);
            try (ResultSet rs = comandoSQL.executeQuery()) {
                while (rs.next()) {
                    Cliente cliente = new Cliente(
                            rs.getInt("idCliente"),
                            rs.getString("nomeCliente"),
                            rs.getString("endereco"),
                            rs.getString("CPF"),
                            rs.getString("telefone"),
                            rs.getString("email"),
                            rs.getString("sexo"),
                            rs.getString("estadoCivil"),
                            rs.getString("dataNascimento")
                    );
                    clientes.add(cliente);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, "Error searching client by name", ex);
        }

        return clientes;
    }
}
