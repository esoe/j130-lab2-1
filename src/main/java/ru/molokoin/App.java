package ru.molokoin;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        {
            System.out.println("Перечень продуктов (products) ...");
            for (CoverProduct product : Repository.getProducts()) {
            System.out.println(product);
            }
        }

        //получение сведений о продукте по id
        {
            int article = 3251615;
            // int article = 3251616;
            // int article = 3251617;
            // int article = 3251619;
            // int article = 3251620;
            System.out.println("Продукт (products) по article : " + article + " ...");
            //System.out.println(Repository.getProductByArticle(article).toString());
            CoverProduct cp = Repository.getProductByArticle(article);
            System.out.println(cp.getDesign() + "\t" + cp.getColor());
        }
        
        /**
         * регистрация заказа, предусматривает передачу в базу данных следующих данных:
         * - ФИО заказчика;
         * - контактный телефон;
         * - адрес эл. почты;
         * - адрес доставки;
         * - артикулы товаров, включённых в заказ;
         * 
         * Таблица products не меняется (только предоставляет данные)
         * Таблица заказы
         * - заполняются переданные поля
         * - генерится id
         * - генерится дата регистрации (created)
         * - генерится статус позиции (position P)
         * 
         * Таблица позиции (positions)
         * - id заказа (из таблицы заказы)
         * - article продукта (пользователь выбирает из списка-таблица продукты)
         * - цена из таблицы products (автоподстановка)
         * - количество указывает пользователь
         */
        CoverRequest request = new CoverRequest();
        ControllerRegistration controller = new ControllerRegistration();
        /**
         * Заполнение полей request, которые берутся по умолчанию
         * - id
         * - created
         * - position
         * 
         */
        controller.preset(request);
    }
    /**
     * Ввод данных в консоли
     * @return input
     */
    public static String input(){
        Console console = System.console();
        if (console == null) {
            System.err.println("Консоль не обнаружена ...");
            System.exit(1);
        }
        String input = console.readLine();
        return input;
    }
    
}
