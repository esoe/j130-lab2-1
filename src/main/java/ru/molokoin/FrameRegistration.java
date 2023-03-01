package ru.molokoin;

import java.awt.*;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameRegistration extends JFrame{
    private JLabel idLable;
    private JTextField idField;
    private JLabel fioLable;
    private JTextField fioField;
    private JLabel phoneLable;
    private JTextField phoneField;
    private JLabel mailLable;
    private JTextField mailField;
    private JLabel adresLable;
    private JTextField adresField;
    private JLabel createdLable;
    private JTextField createdField;
    private JLabel positionLable;
    private JTextField positionField;
    private JButton addPosition;
    
    public FrameRegistration(){
        //Create and set up the window.
        setTitle("Регистрация заказа");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        idLable = new JLabel("ID: ");
        idLable.setPreferredSize(new Dimension(60, 20));
        idField = new JTextField(20);

        fioLable = new JLabel("name: " + "     ");
        fioLable.setPreferredSize(new Dimension(60, 20));
        fioField = new JTextField(20);
        
        phoneLable = new JLabel("phone: " + "    ");
        phoneLable.setPreferredSize(new Dimension(60, 20));
        phoneField = new JTextField(20);
        
        mailLable = new JLabel("mail: " + "        ");
        mailLable.setPreferredSize(new Dimension(60, 20));
        mailField = new JTextField(20);
        
        adresLable = new JLabel("adres: " + "     ");
        adresLable.setPreferredSize(new Dimension(60, 20));
        adresField = new JTextField(20);
        
        createdLable = new JLabel("created: " + " ");
        createdLable.setPreferredSize(new Dimension(60, 20));
        createdField = new JTextField(20);
        
        positionLable = new JLabel("position: " + "");
        positionLable.setPreferredSize(new Dimension(60, 20));
        positionField = new JTextField(20);
        
        
        // fioLable.setPreferredSize(new Dimension(175, 100));
        getContentPane().add(inputpane(), BorderLayout.CENTER);
        addPosition = new JButton("Добавить к заказу ...");
        getContentPane().add(addPosition, BorderLayout.SOUTH);
 
        //Display the window.
        pack();
        setVisible(true);
        
    }
    /**
     * Формируем строку ввода данных, состоящую из:
     * - наименования поля (label)
     * - поля ввода данных (field)
     * 
     * @param label
     * @param field
     * @return
     */
    public JPanel minipane(JLabel label, JTextField field){
        JPanel pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
        pane.add(label);
        pane.add(field);
        return pane;
    }
    /**
     * Формируем панель ввода данных
     * - добавляем панели строк
     * @return
     */
    public JPanel inputpane(){
        JPanel pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        pane.add(minipane(idLable, idField));
        pane.add(minipane(fioLable, fioField));
        pane.add(minipane(phoneLable, phoneField));
        pane.add(minipane(phoneLable, phoneField));
        pane.add(minipane(mailLable, mailField));
        pane.add(minipane(adresLable, adresField));
        pane.add(minipane(createdLable, createdField));
        pane.add(minipane(positionLable, positionField));
        return pane;
    }
    public static void main(String[] args) {
        new FrameRegistration();
    }
}