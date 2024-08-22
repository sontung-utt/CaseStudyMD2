package model.category;

public class CAccessory extends Category{

    public CAccessory(){
    }

    public CAccessory(String name){
        super(name);
    }

    public CAccessory(int id, String name) {
        super(id, name);
    }

    public String getCategoryType() {
        return "Đồ phụ kiện";
    }

    public String toString() {
        return super.toString() +
                "\nLoại hình sản phẩm: " + getCategoryType();
    }
}
