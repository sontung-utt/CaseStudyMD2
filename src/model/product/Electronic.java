package model.product;

import java.time.LocalDate;

public class Electronic extends Product{
    private double memory;
    private double storage;
    private String configuration;

    public Electronic(){
    }

    public Electronic(String name, double price, int quantity, LocalDate purchaseDate, int warranty, String description, int idCategory, int idBrand, double memory, double storage, String configuration) {
        super(name, price, quantity, purchaseDate, warranty, description, idCategory, idBrand);
        this.memory = memory;
        this.storage = storage;
        this.configuration = configuration;
    }

    public Electronic(int id, String name, double price, int quantity, LocalDate purchaseDate, int warranty, String description, int idCategory, int idBrand, double memory, double storage, String configuration) {
        super(id, name, price, quantity, purchaseDate, warranty, description, idCategory, idBrand);
        this.memory = memory;
        this.storage = storage;
        this.configuration = configuration;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    public double getStorage() {
        return storage;
    }

    public void setStorage(double storage) {
        this.storage = storage;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public String toString() {
        return "=====Đồ công nghệ=====" +
                super.toString() +
                "\nBộ nhớ: " + memory + "(Gb)" +
                "\nDung lượng: " + storage + "(Gb)" +
                "\nCấu hình: " + configuration;
    }
}
