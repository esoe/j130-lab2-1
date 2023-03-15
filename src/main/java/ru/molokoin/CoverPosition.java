package ru.molokoin;

public class CoverPosition {
    private int id;//requests.id
    private int article;//products.article
    private int price;
    private int quantity;
    public CoverPosition(int id, int article, int price, int quantity){
        this.id = id;
        this.article = article;
        this.price = price;
        this.quantity = quantity;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the article
     */
    public int getArticle() {
        return article;
    }
    /**
     * @param article the article to set
     */
    public void setArticle(int article) {
        this.article = article;
    }
    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }
    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }
    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
