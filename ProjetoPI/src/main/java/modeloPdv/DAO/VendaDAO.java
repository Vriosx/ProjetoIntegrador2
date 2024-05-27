package modeloPdv.DAO;

import ModeloPdv.models.ItemVenda;
import ModeloPdv.models.Vendas;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendaDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/superMercado";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "7423";

    public static boolean salvar(Vendas obj) {
        Connection conexao = null;
        boolean retorno = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            conexao.setAutoCommit(false); 

            String sql = "INSERT INTO vendas(dataVenda, valorVenda, idCliente) VALUES (?, ?, ?)";
            try (PreparedStatement comandoSQL = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

                comandoSQL.setDate(1, new java.sql.Date(obj.getDataVenda().getTime()));
                comandoSQL.setDouble(2, obj.getValorVenda());
                comandoSQL.setInt(3, obj.getIdCliente());

                int linhasAfetadas = comandoSQL.executeUpdate();

                if (linhasAfetadas > 0) {
                    try (ResultSet rs = comandoSQL.getGeneratedKeys()) {
                        if (rs.next()) {
                            int idVenda = rs.getInt(1);
                            obj.setIdVenda(idVenda);

                            for (ItemVenda item : obj.getListaItens()) {
                                String sql2 = "INSERT INTO ItemVenda(idVenda, idProduto, qtdProduto, vlrUnitario) VALUES (?, ?, ?, ?)";
                                try (PreparedStatement comandoSQL2 = conexao.prepareStatement(sql2)) {
                                    comandoSQL2.setInt(1, idVenda);
                                    comandoSQL2.setInt(2, item.getIdProduto());
                                    comandoSQL2.setInt(3, item.getQtdProduto());
                                    comandoSQL2.setDouble(4, item.getVlrUnitario());

                                    comandoSQL2.executeUpdate();
                                }
                            }
                            conexao.commit(); 
                            retorno = true;
                        } else {
                            throw new SQLException("Falha ao obter o ID da venda.");
                        }
                    }
                }
            } catch (SQLException e) {
                if (conexao != null) {
                    try {
                        conexao.rollback(); 
                    } catch (SQLException ex) {
                        Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                throw e; 
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexao != null) {
                try {
                    conexao.setAutoCommit(true); 
                    conexao.close(); 
                } catch (SQLException ex) {
                    Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return retorno;
    }
    
    public static boolean excluir(int idVenda) {
    boolean isDeleted = false;

    String sql = "DELETE FROM vendas WHERE idVenda = ?";

    try (Connection conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);
         PreparedStatement comandoSQL = conexao.prepareStatement(sql)) {

        comandoSQL.setInt(1, idVenda);
        int linhasAfetadas = comandoSQL.executeUpdate();
        isDeleted = linhasAfetadas > 0;

    } catch (SQLException ex) {
        Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, "Error deleting sale", ex);
    }

    return isDeleted;
}

    
}
