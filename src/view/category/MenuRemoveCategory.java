package view.category;

import input.Input;
import manager.CategoryManager;
import model.category.CFurniture;

public class MenuRemoveCategory {
    CategoryManager categoryManager = new CategoryManager();

    public void showMenuRemoveCategory(){
        System.out.println("=====Xóa loại sản phẩm=====");
        System.out.print("Nhập mã loại sản phẩm muốn xóa: ");
        int idRemove = Input.inputInteger();
        if (categoryManager.findIndexById(idRemove) != -1){
            categoryManager.remove(idRemove);
            System.out.println("Xóa loại sản phẩm thành công!");
        } else {
            System.out.println("Không tìm thấy mã loại sản phẩm!");
        }
    }
}
