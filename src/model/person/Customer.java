package model.person;

import java.time.LocalDate;

public class Customer extends Person{
    private static int idIncrement = 10000;
    private int numOfPurchase;
    private double totalMoney;

    public Customer() {
    }

    public Customer(String name, int age, String gender, String address, String email, String phone, int numOfPurchase, double totalMoney){
        super(idIncrement,name, age, gender, address, email, phone);
        this.numOfPurchase = numOfPurchase;
        this.totalMoney = totalMoney;
        idIncrement++;
    }

    public Customer(int id, String name, int age, String gender, String address, String email, String phone, int numOfPurchase, double totalMoney){
        super(id, name, age, gender, address, email, phone);
        this.numOfPurchase = numOfPurchase;
        this.totalMoney = totalMoney;
        if (id >= idIncrement){
            idIncrement = id + 1;
        }
    }

    public int getNumOfPurchase() {
        return numOfPurchase;
    }

    public void setNumOfPurchase(int numOfPurchase) {
        this.numOfPurchase = numOfPurchase;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String toString() {
        return "=====Khách hàng=====" +
                super.toString() +
                "\nSố lần mua hàng: " + numOfPurchase +
                "\nTồng tiền đã chi: " + totalMoney;
    }

}
