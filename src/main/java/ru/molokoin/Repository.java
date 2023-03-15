package ru.molokoin;

import java.security.KeyStore.Entry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        String query = "SELECT design, color, price, balance FROM products WHERE article="+ article;
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
                product.setPrice(Integer.valueOf(rs.getString("price")));
                product.setBalance(Integer.valueOf(rs.getString("balance")));
                product.setArticle(article);
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
    /**
     * Реализация добавления заказа в базу
     * @param name
     * @param phone
     * @param mail
     * @param address
     * @param needs
     */
    public static void addRequest(String name, int phone, String mail, String address, Map<Integer, Integer> needs) {
        List<String> querries = new ArrayList<>();
        querries.add(createInsertRequests(name, phone, mail, address));//запрос добавления данных заказчика merchent.requests
        for (String string : createInsertPositions(needs)) {
            querries.add(string);
        }
        Connection con = null;
        Statement stmt = null;
        try (Connection connection = DriverManager.getConnection(access.getLink(), access.getLogin(), access.getPassword())){
            con = connection;
            stmt = con.createStatement();
            for (String querry : querries) {
                System.out.println("Обработка запроса: " + querry);
                stmt.executeUpdate(querry);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Формирует строку запроса, для регистрации нового заказчика в таблице merchent.requests
     * @param name
     * @param phone
     * @param mail
     * @param address
     * @return
     */
    public static String createInsertRequests(String name, int phone, String mail, String address){
        System.out.println("Формируем строку запроса createInsertRequests() ...");
        //id = autoincremented
        String created = "CURRENT_DATE()";
        String position = "P";
        String delivery = "NULL";
        StringBuilder querry = new StringBuilder();
        querry.append("INSERT INTO merchent.requests (");
        querry.append("created, customer_name, customer_phone, customer_mail, customer_address, position, delivery" + ") ");
        querry.append("VALUES (");
        querry.append(created + ", ");
        querry.append("'" + name + "'" + ", ");
        querry.append("'" + phone + "'" + ", ");
        querry.append("'" + mail + "'" + ", ");
        querry.append("'" + address + "'" + ", ");
        querry.append("'" + position + "'" + ", ");
        querry.append(delivery + ");");//нету апострофов
        System.out.println("сформирован запрос: " + querry);
        return querry.toString();
    }

    /**
     * Формирует строку запроса, для регистрации нового заказа в таблице merchent.positions
     * @param needs
     * @return
     */
    public static List<String> createInsertPositions(Map<Integer, Integer> needs){
        List<String> querries = new ArrayList<>();
        System.out.println("Формируем список запросов createInsertPositions() ...");
        for (Map.Entry<Integer, Integer>  entry : needs.entrySet()) {
            StringBuilder querry = new StringBuilder();
            String article = String.valueOf(entry.getKey());// needs-key
            String quantity = String.valueOf(entry.getValue());// needs-value
            String id = String.valueOf(getNewRequestID());//id заказчика merchent.requests
            String price  = String.valueOf(getProductByArticle(Integer.valueOf(article)).getPrice());// цена продукта merchent.products
            querry.append("INSERT INTO merchent.positions (");
            querry.append("article, id, price, quantity" + ") ");
            querry.append("VALUES (");
            querry.append("'" + article + "'" + ", ");
            querry.append("'" + id + "'" + ", ");
            querry.append("'" + price + "'" + ", ");
            querry.append("'" + quantity + "'" + ");");
            querries.add(querry.toString());
        }
        for (String string : querries) {
            System.out.println("Получена строка: " + string);
        }
        return querries;
    }

}
