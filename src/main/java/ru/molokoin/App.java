package ru.molokoin;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

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
            System.out.println("Продукт (products) по article : " + article + " ...");
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
        {
            //данные заказчика
            String name = "ФИО Заказчика";
            int phone = 1234567;
            String mail = "some@mail.domain";
            String address = "Адрес доставки";
            // данные продукта 
            Map<Integer, Integer> needs = new HashMap<Integer, Integer>();
            
            int article = 3251615;// подумать как указать несколько артикулов
            int count = 1;
            needs.put(article, count);

            article = 3251616;
            count = 2;
            needs.put(article, count);
            /**
             * Доступные артикулы продуктов:
             * - 3251617
             * - 3251619
             * - 3251620
             * TODO добавление заказа не уменьшает кличество продукции на складе
             */
            Repository.addRequest(name, phone, mail, address, needs);
        }
    }
    /**
     * Ввод данных в консоли : не потребовалось
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
