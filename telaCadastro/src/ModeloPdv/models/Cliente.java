
package ModeloPdv.models;

/**
 *
 * @author Vitor
 */
public class Cliente {
    
    private int idCliente;
    private String nomeCliente;
    private String endereco;
    private String CPF;
    private String telefone;
    private String email;

    public Cliente() {
        
    }

    public Cliente(int idCliente, String nomeCliente, String endereco, String CPF, String telefone, String email) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.endereco = endereco;
        this.CPF = CPF;
        this.telefone = telefone;
        this.email = email;
    }

    public Cliente(String nomeCliente, String endereco, String CPF, String email) {
        this.nomeCliente = nomeCliente;
        this.endereco = endereco;
        this.CPF = CPF;
        this.email = email;
    }
    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
