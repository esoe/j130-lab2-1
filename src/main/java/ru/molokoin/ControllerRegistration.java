package ru.molokoin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerRegistration {
    private FrameRegistration frame;
    private CoverRequest request;
    
    public ControllerRegistration(){
    }
    public void preset(CoverRequest request){
        request.setId(0);
        // создание формы с заполненными предустановленными полями 
        init(request);
    }
    public void init(CoverRequest request){
        frame = new FrameRegistration();
        /**
         * добавляем обработчик нажатия на кнопку
         * - вносим данные заполненных полей в базу
         * - открываем окно добавления новых позиций в заказ
         */
        frame.getAddPositionButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //открываем окно добавления новых позиций в заказ
                System.out.println("Добавить позицию к заказу ...");
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
