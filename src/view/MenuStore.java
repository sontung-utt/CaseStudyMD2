package view;

import input.Input;

public class MenuStore {
    MenuBrand menuBrand = new MenuBrand();
    MenuCategory menuCategory = new MenuCategory();
    MenuProduct menuProduct = new MenuProduct();

    public void showMenuStore() {
        int choice;
        do {
            System.out.println("========Quản lý cửa hàng========");
            System.out.println("1. Quản lý sản phẩm");
            System.out.println("2. Quản lý loại sản phẩm");
            System.out.println("3. Quản lý thương hiệu");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    menuProduct.showMenuProduct();
                    break;
                case 2:
                    menuCategory.showMenuCategory();
                    break;
                case 3:
                    menuBrand.showMenuBrand();
                    break;
                case 0:
                    System.out.println("Thoát chương trình quản lý cửa hàng!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }
}
