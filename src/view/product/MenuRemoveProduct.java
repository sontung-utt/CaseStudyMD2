package view.product;

import input.Input;
import manager.ProductManager;

public class MenuRemoveProduct {
    ProductManager productManager = new ProductManager();
    public void showMenuRemoveProduct() {
        System.out.println("=====Xóa sản phẩm=====");
        System.out.print("Nhập mã sản phẩm muốn xóa: ");
        int idRemove = Input.inputInteger();
        if (productManager.findIndexById(idRemove)!=-1){
            productManager.remove(idRemove);
            System.out.println("Xóa sản phẩm thành công!");
        } else {
            System.out.println("Không tìm thấy mã sản phẩm!");
        }
    }
}
