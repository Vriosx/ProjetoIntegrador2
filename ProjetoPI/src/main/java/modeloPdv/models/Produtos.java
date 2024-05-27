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

    private int id;
    private String nomeProduto;
    private double precoVenda;
    private double precoCompra;
    private String fornecedor;
    private int quant;

    public Produtos() {
    }

    public Produtos(int id, String nomeProduto, double precoVenda, double precoCompra, String fornecedor, int quant) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.precoVenda = precoVenda;
        this.precoCompra = precoCompra;
        this.fornecedor = fornecedor;
        this.quant = quant;
    }

    public Produtos(String nomeProduto, double precoVenda, double precoCompra, String fornecedor, int quant) {
        this.nomeProduto = nomeProduto;
        this.precoVenda = precoVenda;
        this.precoCompra = precoCompra;
        this.fornecedor = fornecedor;
        this.quant = quant;
    }
    
    

    public Produtos(String nomeProduto, double precoVenda, double precoCompra) {
        this.nomeProduto = nomeProduto;
        this.precoVenda = precoVenda;
        this.precoCompra = precoCompra;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    @Override
    public String toString() {
        return this.nomeProduto;
    }
    
    

}
