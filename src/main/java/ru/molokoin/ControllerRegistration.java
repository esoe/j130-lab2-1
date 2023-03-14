package ru.molokoin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ControllerRegistration {
    private FrameRegistration frame;
    private CoverRequest request;
    private List<CoverPosition> positions;

    public ControllerRegistration(){
        String name = "";//указывает пользователь
        String phone = "";//указывает пользователь
        String mail = "";//указывает пользователь
        String address = "";//указывает пользователь
        request = new CoverRequest(name, phone, mail, address);
        frame = new FrameRegistration();
        
        String id = String.valueOf(request.getId());
        frame.getIdField().setText(id);//получить новый ID из базы
        frame.getIdField().setEditable(false);
        
        String created;//текущая дата
        created = request.getCreated().toString();
        frame.getCreatedField().setText(created);
        frame.getCreatedField().setEditable(false);

        String position = request.getPosition();
        frame.getPositionField().setText(position);//означает, что позиция еще не доставлена
        frame.getPositionField().setEditable(false);

        positions = new ArrayList<>();
    }
    
    public void init(){
        /**
         * Открываем окно добавления новой позиции в заказ. Надо решить:
         * - когда нажимается кнопка, данные заказчика уже внесены?
         * данные может и внесены, но кнопка может нажиматься множество раз, каждый раз переписывать данные заказчика в базе смысла мало ..
         * просто открываем окно которое будет добавлять в список заказов новые позиции.
         * Писать данные в базу будем один раз, когда работа с программйо завершится ...
         */
        frame.getWishlisButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //открываем окно добавления новых позиций в заказ
                System.out.println("Показать позиции заказа и добавить новые ...");
            }
        });

        /**
         * Сохраняем в базу данные заказчика и оформленные им заказы
         */
        frame.getSaveAndCloseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Сохранить данные заказчика и позичии его заказа и выйти ...");
            }
        });
    }
    /**
     * Переносим данные внесенные пользователем
     * - в обертку и затем
     * - в базу
     */
    public void readRequest(){
    }
}
