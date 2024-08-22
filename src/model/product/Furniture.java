package model.product;

import java.time.LocalDate;

public class Furniture extends Product {
    private double consumption;
    private double volume;
    private double capacity;

    public Furniture() {
    }

    public Furniture(String name, double price, int quantity, LocalDate purchaseDate, int warranty, String description, int idCategory, int idBrand, double consumption, double volume, double capacity) {
        super(name, price, quantity, purchaseDate, warranty, description, idCategory, idBrand);
        this.consumption = consumption;
        this.volume = volume;
        this.capacity = capacity;
    }

    public Furniture(int id, String name, double price, int quantity, LocalDate purchaseDate, int warranty, String description, int idCategory, int idBrand, double consumption, double volume, double capacity) {
        super(id, name, price, quantity, purchaseDate, warranty, description, idCategory, idBrand);
        this.consumption = consumption;
        this.volume = volume;
        this.capacity = capacity;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public String toString() {
        return "=====Đồ nội thất=====" +
                super.toString() +
                "\nCông suất tiêu thụ: " + consumption + "(W)" +
                "\nKhối lượng: " + volume + "(Kg)" +
                "\nDung tích: " + capacity + "(L)";

    }
}
