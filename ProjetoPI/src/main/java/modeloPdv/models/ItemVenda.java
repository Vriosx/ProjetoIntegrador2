package ModeloPdv.models;

/**
 * Represents an item in a sale transaction.
 * Contains details such as item sale ID, sale ID, product ID, product quantity, and unit price.
 * 
 * Author: Deivid
 */
public class ItemVenda {

    private int idItemVenda;
    private int idVenda;
    private int idProduto;
    private int qtdProduto;
    private double vlrUnitario;

    /**
     * Constructor for creating an item without specifying sale ID and item sale ID.
     * 
     * @param idProduto the ID of the product
     * @param qtdProduto the quantity of the product
     * @param vlrUnitario the unit price of the product
     */
    public ItemVenda(int idProduto, int qtdProduto, double vlrUnitario) {
        this.idProduto = idProduto;
        this.qtdProduto = qtdProduto;
        this.vlrUnitario = vlrUnitario;
    }

    /**
     * Constructor for creating an item with specified sale ID.
     * 
     * @param idVenda the ID of the sale
     * @param idProduto the ID of the product
     * @param qtdProduto the quantity of the product
     * @param vlrUnitario the unit price of the product
     */
    public ItemVenda(int idVenda, int idProduto, int qtdProduto, double vlrUnitario) {
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.qtdProduto = qtdProduto;
        this.vlrUnitario = vlrUnitario;
    }

    public int getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(int idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public double getVlrUnitario() {
        return vlrUnitario;
    }

    public void setVlrUnitario(double vlrUnitario) {
        this.vlrUnitario = vlrUnitario;
    }
}
