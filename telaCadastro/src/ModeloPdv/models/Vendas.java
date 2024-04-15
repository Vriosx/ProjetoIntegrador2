
package ModeloPdv.models;

/**
 *
 * @author Vitor
 */
public class Vendas {
    
  private String cpf;
  private int idProduto;

    public Vendas() {
    }

    public Vendas(String cpf, int idProduto) {
        this.cpf = cpf;
        this.idProduto = idProduto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
  
    
    
}
