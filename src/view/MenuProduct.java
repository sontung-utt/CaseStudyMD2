package view;

import input.Input;
import manager.ProductManager;
import view.product.*;

public class MenuProduct {
    ProductManager productManager = new ProductManager();
    MenuAddProduct menuAddProduct = new MenuAddProduct();
    MenuEditProduct menuEditProduct = new MenuEditProduct();
    MenuRemoveProduct menuRemoveProduct = new MenuRemoveProduct();
    MenuShowProduct menuShowProduct = new MenuShowProduct();
    MenuSearchProduct menuSearchProduct = new MenuSearchProduct();
    public void showMenuProduct(){
        int choice;
        do {
            System.out.println("========Quản lý sản phẩm========");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    menuAddProduct.showMenuAddProduct();
                    break;
                case 2:
                    menuEditProduct.showMenuEditProduct();
                    break;
                case 3:
                    menuRemoveProduct.showMenuRemoveProduct();
                    break;
                case 4:
                    menuShowProduct.showMenuListProduct();
                    break;
                case 5:
                    menuSearchProduct.showMenuSearchProduct();
                    break;
                case 0:
                    System.out.println("Thoát chương trình quản lý sản phẩm!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice!=0);
    }
}
