package model.category;

public class CFurniture extends Category{

    public CFurniture(){
    }

    public CFurniture(String name){
        super(name);
    }

    public CFurniture(int id, String name) {
        super(id, name);
    }

    public String getCategoryType() {
        return "Đồ nội thất";
    }


    public String toString() {
        return super.toString() +
                "\nLoại hình sản phẩm: " + getCategoryType();
    }
}
