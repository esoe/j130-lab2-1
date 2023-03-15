package ru.molokoin;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Форма отображения перечня позиций заказа:
 * - таблица позици заказа
 * - кнопка добавить позицию (открывает окно формирования позиции - Product)
 * - закрывается окно на "крестик"(незачем тут реализовывать отдельную кнопку)
 */
public class FramePositions extends JFrame{
    private JScrollPane scrollPane;
    private JTable table;
    private JButton addButton;
    public FramePositions(List<CoverPosition> positions){
        //Создание и настройка окна.
        setTitle("WISHLIST");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        

        //отображение окна
        pack();
        setVisible(true);

    }
    /**
     * Метод возвращает панель с таблицей
     * @param positions
     * @return
     */
    public JPanel initTable(List<CoverPosition> positions){
        JPanel panel = new JPanel();
        //формируем заголовки таблицы


        //формируем таблицу
        table = new JTable();
        // добавляем таблицу на скролл
        scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        //добавляем скролл на панель
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }
}
