package view;

import input.Input;
import manager.CustomerManager;
import model.person.Customer;
import validate.Validate;

import java.util.List;

public class MenuCustomer {

    CustomerManager customerManager = new CustomerManager();
    public void showMenuCustomer(){
        int choice;
        do {
            System.out.println("========Quản lý khách hàng========");
            System.out.println("1. Thêm mới khách hàng");
            System.out.println("2. Sửa thông tin khách hàng");
            System.out.println("3. Xóa khách hàng");
            System.out.println("4. Hiển thị danh sách khách hàng");
            System.out.println("5. Tìm kiếm khách hàng");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    showMenuAddCustomer();
                    break;
                case 2:
                    showMenuEditCustomer();
                    break;
                case 3:
                    showMenuRemoveCustomer();
                    break;
                case 4:
                    showAllCustomer();
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("Thoát chương trình quản lý khách hàng!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice!=0);
    }

    private void showMenuAddCustomer() {
        System.out.println("=====Thêm mới khách hàng=====");
        String name = Validate.validateName();
        System.out.print("Nhập tuổi: ");
        int age = Input.inputInteger();
        if(age < 10){
            System.out.println("Tuổi khách hàng chưa đủ! Không thể thêm khách hàng.");
            return;
        }
        System.out.print("Nhập giới tính: ");
        String gender = Input.inputString();
        System.out.print("Nhập địa chỉ: ");
        String address = Input.inputString();
        String email = Validate.validateEmail();
        String phone = Validate.validatePhone();
        System.out.print("Nhập số lần mua hàng: ");
        int numOfPurchase = Input.inputInteger();
        System.out.print("Nhập số tiền đã chi: ");
        double totalMoney = Input.inputDouble();
        Customer customer = new Customer(name,age,gender,address,email,phone,numOfPurchase,totalMoney);
        customerManager.add(customer);
        System.out.println("Thêm khách hàng thành công!");
    }

    private void showMenuEditCustomer() {
        System.out.println("=====Sửa thông tin khách hàng=====");
        System.out.print("Nhập mã khách hàng muốn sửa: ");
        int idEdit = Input.inputInteger();
        Customer oldCustomer = customerManager.findCustomerById(idEdit);
        if (oldCustomer!=null){
            System.out.println("Thông tin khách hàng hiện tại\n" + oldCustomer);
            String name = Validate.validateName();
            System.out.print("Nhập tuổi: ");
            int age = Input.inputInteger();
            if(age < 10){
                System.out.println("Tuổi khách hàng chưa đủ! Không thể thêm khách hàng.");
                return;
            }
            System.out.print("Nhập giới tính: ");
            String gender = Input.inputString();
            System.out.print("Nhập địa chỉ: ");
            String address = Input.inputString();
            String email = Validate.validateEmail();
            String phone = Validate.validatePhone();
            System.out.print("Nhập số lần mua hàng: ");
            int numOfPurchase = Input.inputInteger();
            System.out.print("Nhập số tiền đã chi: ");
            double totalMoney = Input.inputDouble();
            Customer customer = new Customer(idEdit,name,age,gender,address,email,phone,numOfPurchase,totalMoney);
            customerManager.update(idEdit,customer);
            System.out.println("Sửa thông tin khách hàng thành công!");
        } else {
            System.out.println("Không tìm thấy mã khách hàng!");
        }
    }

    private void showMenuRemoveCustomer() {
        System.out.println("=====Xóa khách hàng=====");
        System.out.print("Nhập mã khách hàng muốn xóa: ");
        int idRemove = Input.inputInteger();
        if (customerManager.findIndexById(idRemove)!=-1){
            customerManager.remove(idRemove);
            System.out.println("Xóa khách hàng thành công!");
        } else {
            System.out.println("Không tìm thấy mã khách hàng!");
        }
    }

    private void showAllCustomer(){
        System.out.println("=====Hiển thị danh sách khách hàng=====");
        List<Customer> list = customerManager.getAll();
        for (Customer customer : list){
            System.out.println(customer);
        }
    }
}
