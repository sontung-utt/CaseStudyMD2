package model.category;

public class CDeviceVisual extends Category{

    public CDeviceVisual(){
    }

    public CDeviceVisual(String name){
        super(name);
    }

    public CDeviceVisual(int id, String name) {
        super(id, name);
    }

    public String getCategoryType() {
        return "Thiết bị âm thanh";
    }

    public String toString() {
        return super.toString() +
                "\nLoại hình sản phẩm: " + getCategoryType();
    }
}
