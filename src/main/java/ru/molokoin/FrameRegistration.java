package ru.molokoin;

import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameRegistration extends JFrame{
    private JLabel idLable;
    private JTextField idField;
    private JLabel createdLable;
    private JTextField createdField;
    private JLabel nameLable;
    private JTextField nameField;
    private JLabel phoneLable;
    private JTextField phoneField;
    private JLabel mailLable;
    private JTextField mailField;
    private JLabel addressLable;
    private JTextField addressField;
    private JLabel positionLable;
    private JTextField positionField;
    private JButton saveAndCloseButton;
    private JButton wishlisButton;
    
    public FrameRegistration(){
        //Создание и настройка окна.
        setTitle("Регистрация заказа");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
 
        // инициализация и настройка элементов интерфейса
        idLable = new JLabel("ID: ");
        idLable.setPreferredSize(new Dimension(60, 20));
        idField = new JTextField(20);

        nameLable = new JLabel("name: " + "     ");
        nameLable.setPreferredSize(new Dimension(60, 20));
        nameField = new JTextField(20);
        
        phoneLable = new JLabel("phone: " + "    ");
        phoneLable.setPreferredSize(new Dimension(60, 20));
        phoneField = new JTextField(20);
        
        mailLable = new JLabel("mail: " + "        ");
        mailLable.setPreferredSize(new Dimension(60, 20));
        mailField = new JTextField(20);
        
        addressLable = new JLabel("adres: " + "     ");
        addressLable.setPreferredSize(new Dimension(60, 20));
        addressField = new JTextField(20);
        
        createdLable = new JLabel("created: " + " ");
        createdLable.setPreferredSize(new Dimension(60, 20));
        createdField = new JTextField(20);
        
        positionLable = new JLabel("position: " + "");
        positionLable.setPreferredSize(new Dimension(60, 20));
        positionField = new JTextField(20);
        
        // компановка графических элементов
        getContentPane().add(inputpane(), BorderLayout.CENTER);
        saveAndCloseButton = new JButton("save & close");
        getContentPane().add(saveAndCloseButton, BorderLayout.SOUTH);

        wishlisButton = new JButton("WISHLIST");
        getContentPane().add(wishlisButton, BorderLayout.NORTH);

 
        //отображение окна
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
     * - добавляем панели строк (minipanes)
     * @return
     */
    public JPanel inputpane(){
        JPanel pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        pane.add(minipane(idLable, idField));
        pane.add(minipane(nameLable, nameField));
        pane.add(minipane(phoneLable, phoneField));
        pane.add(minipane(mailLable, mailField));
        pane.add(minipane(addressLable, addressField));
        pane.add(minipane(createdLable, createdField));
        pane.add(minipane(positionLable, positionField));
        return pane;
    }
    /**
     * @return the idField
     */
    public JTextField getIdField() {
        return idField;
    }
    /**
     * @return the fioField
     */
    public JTextField getNameField() {
        return nameField;
    }
    /**
     * @return the phoneField
     */
    public JTextField getPhoneField() {
        return phoneField;
    }
    /**
     * @return the mailField
     */
    public JTextField getMailField() {
        return mailField;
    }
    /**
     * @return the adresField
     */
    public JTextField getAddressField() {
        return addressField;
    }
    /**
     * @return the createdField
     */
    public JTextField getCreatedField() {
        return createdField;
    }
    /**
     * @return the positionField
     */
    public JTextField getPositionField() {
        return positionField;
    }

    /**
     * @return the wishlisButton
     */
    public JButton getWishlisButton() {
        return wishlisButton;
    }
    /**
     * @return the saveAndCloseButton
     */
    public JButton getSaveAndCloseButton() {
        return saveAndCloseButton;
    }
}