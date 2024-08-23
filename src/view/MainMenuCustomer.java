package view;

import input.Input;
import view.product.MenuSearchProduct;
import view.product.MenuShowProduct;

public class MainMenuCustomer {
    MenuSearchProduct menuSearchProduct = new MenuSearchProduct();
    MenuShowProduct menuShowProduct = new MenuShowProduct();
    public void showMainMenuCustomer() {
        int choice;
        do {
            System.out.println("==========Trang chủ khách hàng==========");
            System.out.println("1. Tìm kiếm sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice){
                case 1:
                    menuSearchProduct.showMenuSearchProduct();
                    break;
                case 2:
                    menuShowProduct.showMenuListProduct();
                    break;
                case 0:
                    System.out.println("Thoát trang chủ khách hàng!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }
}
