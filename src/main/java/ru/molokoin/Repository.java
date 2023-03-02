package ru.molokoin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    private static Access access = new Access("property\\access.prop");//путь к файлу настроек
    
    /**
     * Получение перечня продуктов (products) из базы (merchent)
     * @return
     */
    public static List<CoverProduct> getProducts(){
        List<CoverProduct> products = new ArrayList<>();
        String query = "SELECT article, design, color, price, balance FROM products";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try (Connection connection = DriverManager.getConnection(access.getLink(), access.getLogin(), access.getPassword())){
            con = connection;
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                CoverProduct current = new CoverProduct(rs.getInt("article"),
                                            rs.getString("design"),
                                            rs.getString("color"),
                                            rs.getInt("price"),
                                            rs.getInt("balance"));
                products.add(current);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    public static CoverProduct getProductByArticle(int article){
        CoverProduct product = new CoverProduct();
        String query = "SELECT design, color FROM products WHERE article="+ article;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try (Connection connection = DriverManager.getConnection(access.getLink(), access.getLogin(), access.getPassword())){
            con = connection;
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()){
                product = new CoverProduct();
                product.setDesign(rs.getString("design"));
                product.setColor(rs.getString("color"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
    public static int getNewRequestID() {
        int requestId = 0;
        String query = "SELECT MAX(id) as max FROM requests";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try (Connection connection = DriverManager.getConnection(access.getLink(), access.getLogin(), access.getPassword())){
            con = connection;
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()){
                requestId = rs.getInt("max") + 1;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return requestId;
    }
}
