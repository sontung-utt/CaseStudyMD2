package view.searchUser.staff;

import input.Input;
import manager.DepartmentManager;
import manager.StaffManager;
import model.department.Department;
import model.person.Staff;

import java.util.List;

public class MenuSearchStaff {
    StaffManager staffManager = new StaffManager();
    DepartmentManager departmentManager = new DepartmentManager();
    public void showMenuSearchStaff() {
        int choice;
        do {
            System.out.println("=====Tìm kiếm nhân sự=====");
            System.out.println("1. Tìm kiếm nhân sự theo tên gần đúng");
            System.out.println("2. Tìm kiếm nhân sự theo giới tính");
            System.out.println("3. Tìm kiếm nhân sự theo phòng ban");
            System.out.println("4. Tìm kiếm nhân sự theo khoảng tuổi");
            System.out.println("5. Tìm kiếm nhân sự có lương cao nhất");
            System.out.println("6. Sắp xếp nhân sự theo lương");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    searchStaffByName();
                    break;
                case 2:
                    searchStaffByGender();
                    break;
                case 3:
                    searchStaffByDepartment();
                    break;
                case 4:
                    searchStaffByRangeAge();
                    break;
                case 5:
                    searchHighestSalaryStaff();
                    break;
                case 6:
                    sortStaffBySalary();
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

    private void searchStaffByName() {
        System.out.println("=====Tìm kiếm nhân sự theo tên gần đúng=====");
        System.out.print("Nhập tên muốn tìm kiếm: ");
        String name = Input.inputString();
        List<Staff> list = staffManager.getStaffByName(name);
        if (list.isEmpty()){
            System.out.println("Không có nhân sự nào có tên chứa " + name.toLowerCase());
        } else {
            System.out.println("Danh sách nhân sự có tên chứa " + name.toLowerCase());
            for (Staff staff : list){
                Department department = departmentManager.findDepartmentById(staff.getIdDepartments());
                System.out.println(staff + "\nPhòng ban: " + department.getName());
            }
        }
    }

    private void searchStaffByGender() {
        System.out.println("=====Tìm kiếm nhân sự theo giới tính=====");
        System.out.print("Nhập giới tính: ");
        String gender = Input.inputString();
        List<Staff> list = staffManager.getStaffByGender(gender);
        if (list.isEmpty()){
            System.out.println("Không có nhân sự nào giới tính " + gender.toLowerCase());
        } else {
            System.out.println("Danh sách nhân sự giới tính " + gender.toLowerCase());
            for (Staff staff : list) {
                Department department = departmentManager.findDepartmentById(staff.getIdDepartments());
                System.out.println(staff + "\nPhòng ban: " + department.getName());
            }
        }
    }

    private void searchStaffByDepartment() {
        System.out.println("=====Tìm kiếm nhân sự theo phòng ban=====");
        System.out.println("Danh sách phòng ban");
        List<Department> list = departmentManager.getAll();
        for (int i = 0; i < list.size(); i++){
            System.out.println((i + 1) + ". " + list.get(i).getName());
        }
        int index, id;
        do {
            System.out.print("Chọn phòng ban muốn tìm kiếm: ");
            int choice = Input.inputInteger();
            index = choice - 1;
            if(index >= list.size() || index < 0){
                System.out.println("Không tồn tại phòng ban! Yêu cầu chọn lại.");
            }
        } while (index >= list.size() || index < 0);
        id = departmentManager.getDepartmentId(index);
        List<Staff> staffList = staffManager.getStaffByDepartment(id);
        if (staffList.isEmpty()){
            System.out.println("Không có nhân sự nào ở phòng " + list.get(index).getName());
        } else {
            System.out.println("Danh sách nhân sự phòng " + list.get(index).getName());
            for (Staff staff : staffList){
                Department department = departmentManager.findDepartmentById(staff.getIdDepartments());
                System.out.println(staff + "\nPhòng ban: " + department.getName());
            }
        }
    }

    private void searchStaffByRangeAge() {
        System.out.println("=====Tìm kiếm nhân sự theo khoảng tuổi=====");
        int min, max;
        do {
            do {
                System.out.print("Nhập tuổi nhỏ nhất: ");
                min = Input.inputInteger();
                if(min < 18 || min > 65){
                    System.out.println("Tuổi không hợp lệ! Yêu cầu nhập lại.");
                }
            } while (min < 18 || min > 65);
            do {
                System.out.print("Nhập tuổi lớn nhất: ");
                max = Input.inputInteger();
                if(max < 18 || max > 65){
                    System.out.println("Tuổi không hợp lệ! Yêu cầu nhập lại.");
                }
            } while (max < 18 || max > 65);
            if (min >= max){
                System.out.println("Nhập tuổi không hợp lệ! Yêu cầu nhập lại.");
            }
        } while (min >= max);
        List<Staff> list = staffManager.getStaffByRangeAge(min, max);
        if (list.isEmpty()){
            System.out.println("Không có nhân sự nào có khoảng tuổi từ " + min + " đến " + max);
        } else {
            System.out.println("Danh sách nhân sự có khoảng tuổi từ " + min + " đến " + max);
            for (Staff staff : list){
                Department department = departmentManager.findDepartmentById(staff.getIdDepartments());
                System.out.println(staff + "\nPhòng ban: " + department.getName());
            }
        }
    }

    private void searchHighestSalaryStaff() {
        System.out.println("=====Tìm kiếm nhân sự có tiền lương cao nhất=====");
        Staff staff = staffManager.getHighestSalaryStaff();
        Department department = departmentManager.findDepartmentById(staff.getIdDepartments());
        System.out.println(staff + "\nPhòng ban: " + department.getName() + "\nTổng tiền lương: " + staffManager.getSalaryForStaff(staff.getId()));
    }

    private void sortStaffBySalary() {
        System.out.println("=====Sắp xếp nhân sự theo tiền lượng=====");
        List<Staff> list = staffManager.getAll();
        staffManager.sortStaffBySalary();
        for (Staff staff : list){
            Department department = departmentManager.findDepartmentById(staff.getIdDepartments());
            System.out.println(staff + "\nPhòng ban: " + department.getName() + "\nTổng tiền lương: " + staffManager.getSalaryForStaff(staff.getId()));
        }

    }
}
