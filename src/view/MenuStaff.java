package view;

import input.Input;
import manager.DepartmentManager;
import manager.StaffManager;
import model.department.Department;
import model.person.Staff;
import validate.Validate;
import view.product.MenuSearchProduct;
import view.searchUser.staff.MenuSearchStaff;

import java.util.List;

public class MenuStaff {

    StaffManager staffManager = new StaffManager();
    DepartmentManager departmentManager = new DepartmentManager();
        MenuSearchStaff menuSearchStaff = new MenuSearchStaff();
    public void showMenuStaff(){
        int choice;
        do {
            System.out.println("========Quản lý nhân sự========");
            System.out.println("1. Thêm mới nhân sự");
            System.out.println("2. Sửa thông tin nhân sự");
            System.out.println("3. Xóa nhân sự");
            System.out.println("4. Hiển thị danh sách nhân sự");
            System.out.println("5. Tìm kiếm nhân sự");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    showMenuAddStaff();
                    break;
                case 2:
                    showMenuEditStaff();
                    break;
                case 3:
                    showMenuRemoveStaff();
                    break;
                case 4:
                    showAllStaff();
                    break;
                case 5:
                    menuSearchStaff.showMenuSearchStaff();
                    break;
                case 0:
                    System.out.println("Thoát chương trình quản lý nhân sự!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice!=0);
    }

    private void showMenuAddStaff() {
        System.out.println("=====Thêm mới nhân sự=====");
        String name = Validate.validateName();
        System.out.print("Nhập tuổi: ");
        int age = Input.inputInteger();
        if(age < 18 || age > 65){
            System.out.println("Tuổi nhân sự không phù hợp! Không thể thêm vào danh sách nhân sự.");
            return;
        }
        System.out.print("Nhập giới tính: ");
        String gender = Input.inputString();
        System.out.print("Nhập địa chỉ: ");
        String address = Input.inputString();
        String email = Validate.validateEmail();
        String phone = Validate.validatePhone();
        System.out.println("Danh sách phòng ban");
        List<Department> list = departmentManager.getAll();
        for (int i = 0; i < list.size(); i++){
            System.out.println((i + 1) + ". " + list.get(i).getName());
        }
        int index, idDepartment;
        do {
            System.out.print("Chọn phòng ban cho nhân sự: ");
            int choice = Input.inputInteger();
            index = choice - 1;
            if (index >= list.size() || index < 0) {
                System.out.println("Phòng ban không tồn tại! Yêu cầu chọn lại.");
            }
        } while (index >= list.size() || index < 0);
        idDepartment = departmentManager.getDepartmentId(index);
        System.out.print("Nhập tiền lương: ");
        double salary = Input.inputDouble();
        Staff staff = new Staff(name,age,gender,address,email,phone,idDepartment,salary);
        staffManager.add(staff);
        System.out.println("Thêm nhân sự thành công!");
    }

    private void showMenuEditStaff() {
        System.out.println("=====Sửa thông tin nhân sự=====");
        System.out.print("Nhập mã nhân sự muốn sửa: ");
        int idEdit = Input.inputInteger();
        Staff oldStaff = staffManager.findStaffById(idEdit);
        if (oldStaff != null){
            System.out.println("Thông tin nhân sự hiện tại\n" + oldStaff);
            String name = Validate.validateName();
            System.out.print("Nhập tuổi: ");
            int age = Input.inputInteger();
            if(age < 18 || age > 65){
                System.out.println("Tuổi nhân sự không phù hợp! Không thể sửa thông tin nhân sự.");
                return;
            }
            System.out.print("Nhập giới tính: ");
            String gender = Input.inputString();
            System.out.print("Nhập địa chỉ: ");
            String address = Input.inputString();
            String email = Validate.validateEmail();
            String phone = Validate.validatePhone();
            System.out.println("Danh sách phòng ban");
            List<Department> list = departmentManager.getAll();
            for (int i = 0; i < list.size(); i++){
                System.out.println((i + 1) + ". " + list.get(i).getName());
            }
            int index, idDepartment;
            do {
                System.out.print("Chọn phòng ban cho nhân sự: ");
                int choice = Input.inputInteger();
                index = choice - 1;
                if (index >= list.size() || index < 0) {
                    System.out.println("Phòng ban không tồn tại! Yêu cầu chọn lại.");
                }
            } while (index >= list.size() || index < 0);
            idDepartment = departmentManager.getDepartmentId(index);
            System.out.print("Nhập tiền lương: ");
            double salary = Input.inputDouble();
            Staff staff = new Staff(idEdit,name,age,gender,address,email,phone,idDepartment,salary);
            staffManager.update(idEdit,staff);
            System.out.println("Sửa thông tin nhân sự thành công!");
        } else {
            System.out.println("Không tìm thấy mã nhân sự!");
        }
    }

    private void showMenuRemoveStaff() {
        System.out.println("=====Xóa nhân sự=====");
        System.out.print("Nhập mã nhân sự muốn xóa: ");
        int idRemove = Input.inputInteger();
        if (staffManager.findIndexById(idRemove)!=-1){
            staffManager.remove(idRemove);
            System.out.println("Xóa nhân sự thành công");
        } else {
            System.out.println("Không tìm thấy mã nhân sự!");
        }
    }

    private void showAllStaff() {
        System.out.println("=====Hiển thị danh sách nhân sự=====");
        List<Staff> staffList = staffManager.getAll();
        for (Staff staff : staffList){
            System.out.println(staff);
        }
    }
}
