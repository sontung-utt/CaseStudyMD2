package model.category;

public class Category {
    private int id;
    private String name;
    private static int idIncrement = 1;

    public Category(){
    }

    public Category(String name){
        this.id = idIncrement;
        this.name = name;
        idIncrement++;
    }

    public Category(int id, String name){
        this.id = id;
        this.name = name;
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

    public String getCategoryType() {
        return "Category";
    }

    public String toString() {
        return "=====Loại sản phẩm=====" +
                "\nMã loại sản phẩm: " + id +
                "\nTên loại sản phẩm: " + name;
    }
}
