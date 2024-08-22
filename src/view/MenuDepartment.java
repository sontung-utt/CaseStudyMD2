package view;

import input.Input;
import manager.DepartmentManager;
import model.department.Department;

import java.util.List;

public class MenuDepartment {
    DepartmentManager departmentManager = new DepartmentManager();
    public void showMenuDepartment(){
        int choice;
        do {
            System.out.println("========Quản lý phòng ban========");
            System.out.println("1. Thêm phòng ban");
            System.out.println("2. Sửa thông tin phòng ban");
            System.out.println("3. Xóa phòng ban");
            System.out.println("4. Hiển thị danh sách phòng ban");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    showMenuAdd();
                    break;
                case 2:
                    showMenuEdit();
                    break;
                case 3:
                    showMenuRemove();
                    break;
                case 4:
                    showMenuAll();
                    break;
                case 0:
                    System.out.println("Thoát chương trình quản lý phòng ban!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }

    private void showMenuAdd(){
        System.out.println("=====Thêm mới phòng ban=====");
        System.out.print("Nhập tên phòng ban: ");
        String name = Input.inputString();
        System.out.print("Nhập hệ số lương: ");
        double salaryCoefficient = Input.inputDouble();
        Department department = new Department(name, salaryCoefficient);
        departmentManager.add(department);
        System.out.println("Thêm mới phòng ban thành công!");
    }

    private void showMenuEdit(){
        System.out.println("=====Sửa thông tin phòng ban=====");
        System.out.print("Nhập mã phòng ban muốn sửa: ");
        int idEdit = Input.inputInteger();
        Department oldDepartment = departmentManager.findDepartmentById(idEdit);
        if (oldDepartment != null){
            System.out.println("Thông tin phòng ban hiện tại\n" + oldDepartment);
            System.out.print("Nhập tên phòng ban: ");
            String name = Input.inputString();
            System.out.print("Nhập hệ số lương: ");
            double salaryCoefficient = Input.inputDouble();
            Department department = new Department(idEdit,name,salaryCoefficient);
            departmentManager.update(idEdit,department);
            System.out.println("Sửa thông tin phòng ban thành công!");
        } else {
            System.out.println("Không tìm thấy mã phòng ban!");
        }
    }

    private void showMenuRemove() {
        System.out.println("=====Xóa phòng ban=====");
        System.out.print("Nhập mã phòng ban muốn xóa: ");
        int idRemove = Input.inputInteger();
        if (departmentManager.findIndexById(idRemove)!=-1){
            departmentManager.remove(idRemove);
            System.out.println("Xóa phòng ban thành công!");
        }else {
            System.out.println("Không tìm thấy mã phòng ban!");
        }
    }

    private void showMenuAll() {
        System.out.println("=====Hiển thị danh sách phòng ban=====");
        List<Department> departmentList = departmentManager.getAll();
        for (Department department : departmentList){
            System.out.println(department);
        }
    }
}
