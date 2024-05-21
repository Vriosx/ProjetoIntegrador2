package modeloPdv.DAO;

import ModeloPdv.models.Produtos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class ProdutosDAO {

    public static String URL = "jdbc:mysql://localhost:3306/superMercado";
    public static String login = "root";
    public static String senha = "";

    public static boolean salvar(Produtos p) {
        boolean sucesso = false;
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, login, senha);
            PreparedStatement comandoSQL = conexao.prepareStatement(
                    "INSERT INTO produtos (nomeProduto, quant, precoVenda, fornecedor, precoCompra) VALUES (?, ?, ?, ?, ?)");
            comandoSQL.setString(1, p.getNomeProduto());
            comandoSQL.setInt(2, p.getQuant());
            comandoSQL.setDouble(3, p.getPrecoVenda());
            comandoSQL.setString(4, p.getFornecedor());
            comandoSQL.setDouble(5, p.getPrecoCompra());
            int linhasAfetadas = comandoSQL.executeUpdate();
            sucesso = linhasAfetadas > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return sucesso;
    }

    public static boolean alterar(Produtos a) {
        boolean sucesso = false;
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, login, senha);
            PreparedStatement comandoSQL = conexao.prepareStatement(
                    "UPDATE produtos SET nomeProduto=?, quant=?, precoVenda=?, fornecedor=?, precoCompra=? WHERE id=?");
            comandoSQL.setString(1, a.getNomeProduto());
            comandoSQL.setInt(2, a.getQuant());
            comandoSQL.setDouble(3, a.getPrecoVenda());
            comandoSQL.setString(4, a.getFornecedor());
            comandoSQL.setDouble(5, a.getPrecoCompra());
            comandoSQL.setInt(6, a.getId());
            int linhasAfetadas = comandoSQL.executeUpdate();
            sucesso = linhasAfetadas > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return sucesso;
    }

    public static boolean excluir(int idExcluir) {
        boolean retorno = false;
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(URL, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM produtos WHERE id = ?");

            comandoSQL.setInt(1, idExcluir);

            int linhasAfetadas = comandoSQL.executeUpdate();

            retorno = linhasAfetadas > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutosDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (conexao != null) {
                try {
                    conexao.close();

                } catch (SQLException ex) {
                    Logger.getLogger(ProdutosDAO.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return retorno;
    }

    public static ArrayList<Produtos> listar() {
        ArrayList<Produtos> list = new ArrayList<>();

        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(URL, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM produtos");

            ResultSet rs = comandoSQL.executeQuery();

            while (rs.next()) {
                Produtos item = new Produtos(
                        rs.getInt("id"),
                        rs.getString("nomeProduto"),
                        rs.getInt("precoVenda"),
                        rs.getDouble("precoCompra"),
                        rs.getString("fornecedor"), rs.getInt("quant"));
                list.add(item);

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutosDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (conexao != null) {
                try {
                    conexao.close();

                } catch (SQLException ex) {
                    Logger.getLogger(ProdutosDAO.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return list;
    }

    public static ArrayList<Produtos> buscarPorNomeProduto(String nomeProduto) {
        ArrayList<Produtos> list = new ArrayList<>();

        Connection conexao = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(URL, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT id, nomeProduto, precoVenda, precoCompra, fornecedor, quant FROM produtos WHERE nomeProduto = ?");

            comandoSQL.setString(1, nomeProduto);
//           
            ResultSet rs = comandoSQL.executeQuery();

            while (rs.next()) {

                Produtos item = new Produtos(
                        rs.getInt("id"),
                        rs.getString("nomeProduto"),
                        rs.getInt("precoVenda"),
                        rs.getDouble("precoCompra"),
                        rs.getString("fornecedor"), rs.getInt("quant"));
                list.add(item);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

}
