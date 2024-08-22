package model.product;

import java.time.LocalDate;

public class Accessory extends Product{
    private String color;
    private String material;

    public Accessory() {
    }

    public Accessory(String name, double price, int quantity, LocalDate purchaseDate, int warranty, String description, int idCategory, int idBrand, String color, String material){
        super(name, price, quantity, purchaseDate, warranty, description, idCategory, idBrand);
        this.material = material;
        this.color = color;
    }

    public Accessory(int id, String name, double price, int quantity, LocalDate purchaseDate, int warranty, String description, int idCategory, int idBrand, String color, String material) {
        super(id, name, price, quantity, purchaseDate, warranty, description, idCategory, idBrand);
        this.color = color;
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String toString() {
        return "=====Đồ phụ kiện=====" +
                super.toString() +
                "\nMàu sắc: " + color +
                "\nChất liệu: " + material;
    }
}
