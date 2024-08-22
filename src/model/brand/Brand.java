package model.brand;

public class Brand {
    private int id;
    private String name;
    private static int idIncrement = 1;

    public Brand(){
    }

    public Brand(String name) {
        this.id = idIncrement;
        this.name = name;
        idIncrement++;
    }

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
        if (id >= idIncrement) {
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

    public String toString(){
        return "=====Thương hiệu=====" +
                "\nMã thương hiệu: " + id +
                "\nTên thương hiệu: " + name;
    }
}
