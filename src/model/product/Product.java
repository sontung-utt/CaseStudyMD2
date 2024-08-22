package model.product;

import java.time.LocalDate;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private LocalDate purchaseDate;
    private int warranty;
    private String description;
    private int idCategory;
    private int idBrand;
    private static int idIncrement = 1;

    public Product() {
    }

    public Product(String name, double price, int quantity, LocalDate purchaseDate, int warranty, String description, int idCategory, int idBrand) {
        this.id = idIncrement;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.warranty = warranty;
        this.description = description;
        this.idCategory = idCategory;
        this.idBrand = idBrand;
        idIncrement++;
    }

    public Product(int id, String name, double price, int quantity, LocalDate purchaseDate, int warranty, String description, int idCategory, int idBrand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.warranty = warranty;
        this.description = description;
        this.idCategory = idCategory;
        this.idBrand = idBrand;
        if (id >= idIncrement){
            idIncrement = id + 1;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }

    public String toString() {
        return "\nMã sản phẩm: " + id +
                "\nTên sản phẩm: " + name +
                "\nGiá sản phẩm: " + price +
                "\nSố lượng: " + quantity +
                "\nNgày mua: " + purchaseDate +
                "\nThời gian bảo hành: " + warranty + " tháng" +
                "\nMô tả sản phẩm: " + description;
    }
}
