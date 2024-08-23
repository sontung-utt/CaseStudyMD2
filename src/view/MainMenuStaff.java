package view;

import input.Input;

public class MainMenuStaff {
    MenuCompany menuCompany = new MenuCompany();
    MenuStore menuStore = new MenuStore();
    MenuCustomer menuCustomer = new MenuCustomer();
    public void showMainMenuStaff() {
        int choice;
        do {
            System.out.println("==========Trang chủ nhân sự==========");
            System.out.println("1. Quản lý công ty");
            System.out.println("2. Quản lý cửa hàng");
            System.out.println("3. Quản lý khách hàng");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    menuCompany.showMenuCompany();
                    break;
                case 2:
                    menuStore.showMenuStore();
                    break;
                case 3:
                    menuCustomer.showMenuCustomer();
                    break;
                case 0:
                    System.out.println("Thoát trang chủ nhân sự!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);

    }
}
