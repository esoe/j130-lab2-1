package ru.molokoin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CoverRequest {
    private int id;
    private Date created;
    private String name;
    private String phone;
    private String mail;
    private String address;
    private String position;
    private Date delivery;
    private List<CoverPosition> positions;
    public CoverRequest(){
        this(null, null, null, null);
    }

    public CoverRequest(String name, String phone, String mail, String address){
        setId(Repository.getNewRequestID());
        setCreated(new Date());//в обложке лучше хранить строку
        setName(name);
        setPhone(phone);
        setMail(mail);
        setAddress(address);
        setPosition("P");
        setDelivery(null);
        setPositions(new ArrayList<>());
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param created the created to set
     */
    public void setCreated(Date created) {
        this.created = created;
    }
    /**
     * @return the created
     */
    public Date getCreated() {
        return created;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }
    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }
    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }
    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }
    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }
    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }
    /**
     * @param delivery the delivery to set
     */
    public void setDelivery(Date delivery) {
        this.delivery = delivery;
    }
    /**
     * @return the delivery
     */
    public Date getDelivery() {
        return delivery;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        return super.toString();
    }
    /**
     * @param positions the positions to set
     */
    public void setPositions(List<CoverPosition> positions) {
        this.positions = positions;
    }
    /**
     * @return the positions
     */
    public List<CoverPosition> getPositions() {
        return positions;
    }
}
