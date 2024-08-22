package view.category;

import input.Input;
import manager.CategoryManager;
import model.category.*;

public class MenuEditCategory {

    CategoryManager categoryManager = new CategoryManager();

    public void showMenuEditCategory(){
        System.out.println("=====Sửa thông tin loại sản phẩm=====");
        System.out.print("Nhập mã loại sản phẩm muốn sửa: ");
        int idEdit = Input.inputInteger();
        Category oldCategory = categoryManager.findCategoryById(idEdit);
        if (oldCategory != null){
            System.out.println("Thông tin loại sản phẩm hiện tại\n" + oldCategory);
            //System.out.println("Loại của loại sản phẩm: " + oldCategory.getClass().getName());
            Category newCategory = null;
            if (oldCategory instanceof CAccessory){
                System.out.println("=====Sửa thông tin loại đồ phụ kiện=====");
                System.out.print("Nhập loại đồ phụ kiện: ");
                String name = Input.inputString();
                CAccessory category = new CAccessory(idEdit,name);
                categoryManager.update(idEdit, category);
                System.out.println("Sửa loại đồ phụ kiện thành công!");
            } else if (oldCategory instanceof CDeviceVisual){
                System.out.println("=====Sửa thông tin loại thiết bị hình ảnh=====");
                System.out.print("Nhập loại thiết bị hình ảnh: ");
                String name = Input.inputString();
                CDeviceVisual category = new CDeviceVisual(idEdit,name);
                categoryManager.update(idEdit,category);
                System.out.println("Sửa loại thiết bị hình ảnh thành công!");
            } else if (oldCategory instanceof CElectronic) {
                System.out.println("=====Sửa thông tin loại đồ công nghệ=====");
                System.out.print("Nhập loại đồ công nghệ: ");
                String name = Input.inputString();
                CElectronic category = new CElectronic(idEdit,name);
                categoryManager.update(idEdit,category);
                System.out.println("Sửa loại đồ công nghệ thành công!");
            } else if (oldCategory instanceof CFurniture) {
                System.out.println("=====Sửa thông tin loại đồ nội thất=====");
                System.out.print("Nhập loại đồ nội thất: ");
                String name = Input.inputString();
                CFurniture category = new CFurniture(idEdit,name);
                categoryManager.update(idEdit,category);
                System.out.println("Sửa loại đồ nội thất thành công!");
            }
        } else {
            System.out.println("Không tìm thấy loại sản phẩm!");
        }
    }
}
