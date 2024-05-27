package modeloPdv.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modeloPdv.models.RelatorioAnalitico;

public class RelatorioAnaliticoDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/superMercado";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "7423";

    public static ArrayList<RelatorioAnalitico> listarPorVenda(int idVenda) {
        Connection conexao = null;
        ResultSet rs = null;
        ArrayList<RelatorioAnalitico> listaRetorno = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String sql = "SELECT ItemVenda.idProduto, Produtos.nomeProduto, ItemVenda.vlrUnitario, ItemVenda.qtdProduto "
                    + "FROM ItemVenda INNER JOIN Produtos ON ItemVenda.idProduto = Produtos.idProduto "
                    + "WHERE ItemVenda.idVenda = ?";

            PreparedStatement comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, idVenda);

            rs = comandoSQL.executeQuery();

            while (rs.next()) {
                String nomeProduto = rs.getString("nomeProduto");
                Float vlrUnitario = rs.getFloat("vlrUnitario");
                int qtdProduto = rs.getInt("qtdProduto");

                RelatorioAnalitico item = new RelatorioAnalitico(nomeProduto, qtdProduto, vlrUnitario);
                listaRetorno.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
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
}
