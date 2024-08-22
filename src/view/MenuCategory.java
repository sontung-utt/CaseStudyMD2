package view;

import input.Input;
import view.category.MenuAddCategory;
import view.category.MenuEditCategory;
import view.category.MenuRemoveCategory;
import view.category.MenuShowCategory;

public class MenuCategory {

    MenuAddCategory menuAddCategory = new MenuAddCategory();
    MenuEditCategory menuEditCategory = new MenuEditCategory();
    MenuRemoveCategory menuRemoveCategory = new MenuRemoveCategory();
    MenuShowCategory menuShowCategory = new MenuShowCategory();

    public void showMenuCategory() {
        int choice;
        do {
            System.out.println("========Quản lý loại sản phẩm========");
            System.out.println("1. Thêm mới loại sản phẩm");
            System.out.println("2. Sửa thông tin loại sản phẩm");
            System.out.println("3. Xóa loại sản phẩm");
            System.out.println("4. Hiển thị danh sách loại sản phẩm");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    menuAddCategory.showMenuAddCategory();
                    break;
                case 2:
                    menuEditCategory.showMenuEditCategory();
                    break;
                case 3:
                    menuRemoveCategory.showMenuRemoveCategory();
                    break;
                case 4:
                    menuShowCategory.showMenuListCategory();
                    break;
                case 0:
                    System.out.println("Thoát chương trình quản lý loại sản phẩm!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }
}
