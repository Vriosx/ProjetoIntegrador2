package modeloPdv.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import modeloPdv.models.RelatorioSintetico;

/**
 *
 * @author Felip
 */
public class RelatorioSinteticoDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/superMercado";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "7423";

    public static ArrayList<RelatorioSintetico> listarPorPeriodo(Date dtInicio, Date dtTermino) {

        Connection conexao = null;
        ResultSet rs = null;
        ArrayList<RelatorioSintetico> listaRetorno = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String sql = "SELECT Vendas.idVenda, Vendas.idCliente, Cliente.nomeCliente, Vendas.dataVenda, "
                    + "Vendas.valorVenda FROM Vendas INNER JOIN Cliente ON Vendas.idCliente = Cliente.idCliente "
                    + "WHERE Vendas.dataVenda BETWEEN ? AND ?";

            PreparedStatement comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setDate(1, new java.sql.Date(dtInicio.getTime()));
            comandoSQL.setDate(2, new java.sql.Date(dtTermino.getTime()));

            rs = comandoSQL.executeQuery();

            while (rs.next()) {
                int idVenda = rs.getInt("idVenda");
                int idCliente = rs.getInt("idCliente");
                String nomeCliente = rs.getString("nomeCliente");
                Date dataVenda = rs.getDate("dataVenda");
                Float valorVenda = rs.getFloat("valorVenda");

                RelatorioSintetico item = new RelatorioSintetico(idVenda, dataVenda, idCliente, nomeCliente, valorVenda);
                listaRetorno.add(item);
            }

        } catch (Exception e) {
            e.printStackTrace(); 
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
                e.printStackTrace(); 
            }
        }

        return listaRetorno;
    }

    /**
     *
     * @param dataInicio
     * @param dataTermino
     * @return
     */
}
