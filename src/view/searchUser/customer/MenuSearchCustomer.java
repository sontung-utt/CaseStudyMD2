package view.searchUser.customer;

import input.Input;
import manager.CustomerManager;

public class MenuSearchCustomer {
    CustomerManager customerManager = new CustomerManager();
    public void showMenuSearchCustomer() {
        int choice;
        do {
            System.out.println("=====Tìm kiếm khách hàng=====");
            System.out.println("1. Tìm kiếm khách hàng theo tên gần đúng");
            System.out.println("2. Tìm kiếm khách hàng theo giới tính");
            System.out.println("3. Tìm kiếm khách hàng theo email và số điện thoại");
            System.out.println("4. Tìm kiếm khách hàng theo khoảng tuổi");
            System.out.println("5. Tìm kiếm khách hàng có số lần mua hàng nhiều nhất");
            System.out.println("6. Tìm kiếm khách hàng có tổng tiền chi cao nhất");
            System.out.println("7. Sắp xếp khách hàng theo tổng tiền đã chi");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 0:
                    System.out.println("Thoát chương trình tìm kiếm nhân sự!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }
}
