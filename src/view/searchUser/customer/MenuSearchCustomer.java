package view.searchUser.customer;

import input.Input;
import manager.CustomerManager;
import model.person.Customer;

import java.util.List;

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
                    searchCustomerByName();
                    break;
                case 2:
                    searchCustomerByGender();
                    break;
                case 3:
                    searchCustomerByEmailPhone();
                    break;
                case 4:
                    searchCustomerByRangeAge();
                    break;
                case 5:
                    searchCustomerHighestPurChase();
                    break;
                case 6:
                    searchCustomerHighestTotalMoney();
                    break;
                case 7:
                    sortCustomerByTotalMoney();
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

    private void searchCustomerByName() {
        System.out.println("=====Tìm kiếm khách hàng theo tên gần đúng=====");
        System.out.print("Nhập tên muốn tìm kiếm: ");
        String name = Input.inputString();
        List<Customer> list = customerManager.getCustomerByName(name);
        if (list.isEmpty()){
            System.out.println("Không có khách hàng nào có tên chứa " + name.toLowerCase());
        } else {
            System.out.println("Danh sách khách hàng có tên chứa " + name.toLowerCase());
            for (Customer customer : list) {
                System.out.println(customer);
            }
        }
    }

    private void searchCustomerByGender() {
        System.out.println("Tìm kiếm khách hàng theo giới tính");
        System.out.print("Nhập giới tính: ");
        String gender = Input.inputString();
        List<Customer> list = customerManager.getCustomerByGender(gender);
        if (list.isEmpty()){
            System.out.println("Không có khách hng nào có giới tính " + gender.toLowerCase());
        } else {
            System.out.println("Danh sách khách hàng giới tính " + gender.toLowerCase());
            for (Customer customer : list){
                System.out.println(customer);
            }
        }
    }

    private void searchCustomerByEmailPhone() {
        System.out.println("=====Tìm kiếm khách hàng theo email và số điện thoại=====");
        System.out.print("Nhập email: ");
        String email = Input.inputString();
        System.out.print("Nhập số điện thoại: ");
        String phone = Input.inputString();
        List<Customer> list = customerManager.getCustomerByEmailPhone(email, phone);
        if (list.isEmpty()){
            System.out.println("Không có khách hàng nào chứa email là " + email.toLowerCase() + " và số điện thoại là " + phone);
        } else {
            System.out.println("Danh sách khách hàng có email chứa " + email.toLowerCase() + " và số điện thoại chứa " + phone );
            for (Customer customer : list){
                System.out.println(customer);
            }
        }
    }

    private void searchCustomerByRangeAge() {
        System.out.println("=====Tìm kiếm khách hàng theo khoảng tuổi=====");
        System.out.println("1. Từ 10 đến 18");
        System.out.println("2. Từ 18 đến 25");
        System.out.println("3. Từ 25 đến 35");
        System.out.println("4. Từ 35 đến 50");
        System.out.println("5. Trên 50");
        System.out.print("Nhập lựa chọn: ");
        int choice = Input.inputInteger();
        switch (choice){
            case 1:
                List<Customer> list1 = customerManager.getCustomerByRangeAge(10,18);
                if (list1.isEmpty()){
                    System.out.println("Không có khách hàng nào có tuổi từ 10 đến 18");
                } else {
                    System.out.println("Danh sách khách hàng có tuổi từ 10 đến 18");
                    for (Customer customer : list1){
                        System.out.println(customer);
                    }
                }
                break;
            case 2:
                List<Customer> list2 = customerManager.getCustomerByRangeAge(18,25);
                if (list2.isEmpty()){
                    System.out.println("Không có khách hàng nào có tuổi từ 18 đến 25");
                } else {
                    System.out.println("Danh sách khách hàng có tuổi từ 18 đến 25");
                    for (Customer customer : list2){
                        System.out.println(customer);
                    }
                }
                break;
            case 3:
                List<Customer> list3 = customerManager.getCustomerByRangeAge(25,35);
                if (list3.isEmpty()){
                    System.out.println("Không có khách hàng nào có tuổi từ 25 đến 35");
                } else {
                    System.out.println("Danh sách khách hàng có tuổi từ 25 đến 35");
                    for (Customer customer : list3){
                        System.out.println(customer);
                    }
                }
                break;
            case 4:
                List<Customer> list4 = customerManager.getCustomerByRangeAge(35,50);
                if (list4.isEmpty()){
                    System.out.println("Không có khách hàng nào có tuổi từ 35 đến 50");
                } else {
                    System.out.println("Danh sách khách hàng có tuổi từ 35 đến 50");
                    for (Customer customer : list4){
                        System.out.println(customer);
                    }
                }
                break;
            case 5:
                List<Customer> list5 = customerManager.getCustomerByRangeAge(50,Integer.MAX_VALUE);
                if (list5.isEmpty()){
                    System.out.println("Không có khách hàng nào có tuổi trên 50");
                } else {
                    System.out.println("Danh sách khách hàng có tuổi trên 50");
                    for (Customer customer : list5){
                        System.out.println(customer);
                    }
                }
                break;
            default:
                System.out.println("Không có lựa chọn phù hợp!");
                break;
        }
    }

    private void searchCustomerHighestPurChase() {
        System.out.println("=====Tìm kiếm khách hàng có số lần mua hàng nhiều nhất=====");
        Customer customer = customerManager.getCustomerHighestPurchase();
        System.out.println("Thông tin khách hàng");
        System.out.println(customer);
    }

    private void searchCustomerHighestTotalMoney() {
        System.out.println("=====Tìm kiếm khách hàng có tổng tiền chi cao nhất=====");
        Customer customer = customerManager.getCustomerHighestTotalMoney();
        System.out.println("Thông tin khách hàng");
        System.out.println(customer);
    }

    private void sortCustomerByTotalMoney() {
        System.out.println("=====Sắp xếp khách hàng theo tổng tiền đã chi=====");
        List<Customer> list = customerManager.sortCustomerByTotalMoney();
        for (Customer customer : list){
            System.out.println(customer);
        }
    }
}
