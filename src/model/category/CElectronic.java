package model.category;

public class CElectronic extends Category{

    public CElectronic(){
    }

    public CElectronic(String name){
        super(name);
    }

    public CElectronic(int id, String name) {
        super(id, name);
    }

    public String getCategoryType() {
        return "Đồ công nghệ";
    }

    public String toString() {
        return super.toString() +
                "\nLoại hình sản phẩm: " + getCategoryType();
    }
}
