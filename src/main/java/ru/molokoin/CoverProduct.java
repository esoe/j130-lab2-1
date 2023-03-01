package ru.molokoin;

public class CoverProduct {
    private int article;
    private String design;
    private String color;
    private int price;
    private int balance;
    public CoverProduct(){}
    public CoverProduct(int article, String design, String color, int price, int balance){
        setArticle(article);
        setDesign(design);
        setColor(color);
        setPrice(price);
        setBalance(balance);
    }
    /**
     * @param article the article to set
     */
    public void setArticle(int article) {
        this.article = article;
    }
    /**
     * @param design the design to set
     */
    public void setDesign(String design) {
        this.design = design;
    }
    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }
    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }
    /**
     * @param balance the balance to set
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }
    /**
     * @return the article
     */
    public int getArticle() {
        return article;
    }
    /**
     * @return the design
     */
    public String getDesign() {
        return design;
    }
    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }
    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }
    /**
     * @return the balance
     */
    public int getBalance() {
        return balance;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getArticle() + "\t");
        sb.append(getDesign() + "\t");
        sb.append(getColor() + "\t");
        sb.append(getPrice() + "\t");
        sb.append(getBalance());
        return sb.toString();
    }
}
