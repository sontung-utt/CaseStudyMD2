package model.product;

import java.time.LocalDate;

public class DeviceVisual extends Product{
    private String resolution;

    public DeviceVisual(){
    }

    public DeviceVisual(String name, double price, int quantity, LocalDate purchaseDate, int warranty, String description, int idCategory, int idBrand, String resolution){
        super(name, price, quantity, purchaseDate, warranty, description, idCategory, idBrand);
        this.resolution = resolution;
    }

    public DeviceVisual(int id, String name, double price, int quantity, LocalDate purchaseDate, int warranty, String description, int idCategory, int idBrand, String resolution){
        super(id, name, price, quantity, purchaseDate, warranty, description, idCategory, idBrand);
        this.resolution = resolution;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String toString() {
        return "=====Thiết bị hình ảnh=====" +
                super.toString() +
                "\nĐộ phân giải: " + resolution;
    }
}

