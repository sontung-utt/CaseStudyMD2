package view;

import input.Input;

public class MenuCompany {
    MenuDepartment menuDepartment = new MenuDepartment();
    MenuStaff menuStaff = new MenuStaff();

    public void showMenuCompany() {
        int choice;
        do {
            System.out.println("========Quản lý công ty========");
            System.out.println("1. Quản lý phòng ban");
            System.out.println("2. Quản lý nhân sự");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    menuDepartment.showMenuDepartment();
                    break;
                case 2:
                    menuStaff.showMenuStaff();
                    break;
                case 0:
                    System.out.println("Thoát chương trình quản lý công ty!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }
}
