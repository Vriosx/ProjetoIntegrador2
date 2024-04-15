/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloPdv.models;

/**
 *
 * @author Vitor
 */
public class Produtos {
    
    private int codigo;
    private String nomeProduto;
    private String precoVenda;
    private String precoCompra;

    public Produtos() {
    }

    public Produtos(int codigo, String nomeProduto, String precoVenda, String precoCompra) {
        this.codigo = codigo;
        this.nomeProduto = nomeProduto;
        this.precoVenda = precoVenda;
        this.precoCompra = precoCompra;
    }

    public Produtos(String nomeProduto, String precoVenda, String precoCompra) {
        this.nomeProduto = nomeProduto;
        this.precoVenda = precoVenda;
        this.precoCompra = precoCompra;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(String precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(String precoCompra) {
        this.precoCompra = precoCompra;
    }
    
    
    
}
