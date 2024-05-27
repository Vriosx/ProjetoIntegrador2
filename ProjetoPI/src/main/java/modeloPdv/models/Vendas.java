package ModeloPdv.models;

import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a sale transaction in the system.
 * Contains details such as sale ID, value, date, client ID, and list of items in the sale.
 * 
 * Author: Vitor
 */
public class Vendas {
    
    private int idVenda;
    private float valorVenda;
    private Date dataVenda;
    private int idCliente;
    
    
    private ArrayList<ItemVenda> listaItens = new ArrayList<>();

    
    
    public Vendas() {
    }

   

    public Vendas(float valorVenda, Date dataVenda, int idCliente, ArrayList<ItemVenda> listaItens) {
        this.valorVenda = valorVenda;
        this.dataVenda = new Date(dataVenda.getTime());
        this.idCliente = idCliente;
        this.listaItens = new ArrayList<>(listaItens);
    }

    public Vendas(int idVenda, float valorVenda, Date dataVenda, int idCliente, ArrayList<ItemVenda> listaItens) {
        this.idVenda = idVenda;
        this.valorVenda = valorVenda;
        this.dataVenda = new Date(dataVenda.getTime());
        this.idCliente = idCliente;
        this.listaItens = new ArrayList<>(listaItens);
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Date getDataVenda() {
        return new Date(dataVenda.getTime());
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = new Date(dataVenda.getTime());
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList<ItemVenda> getListaItens() {
        return new ArrayList<>(listaItens);
    }

    public void setListaItens(ArrayList<ItemVenda> listaItens) {
        this.listaItens = new ArrayList<>(listaItens);
    }
}
