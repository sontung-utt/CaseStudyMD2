package manager;

import model.department.Department;
import model.person.Staff;
import readwritedata.ReadWriteStaff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StaffManager implements IManager<Staff>{

    List<Staff> staffList;
    DepartmentManager departmentManager = new DepartmentManager();
    ReadWriteStaff readWriteStaff = new ReadWriteStaff();
    public StaffManager(){
        this.staffList = this.readWriteStaff.readStaff();
    }
    @Override
    public void add(Staff staff) {
        staffList.add(staff);
        readWriteStaff.writeStaff(staffList);
    }

    @Override
    public void update(int id, Staff staff) {
        int index = findIndexById(id);
        staffList.set(index,staff);
        readWriteStaff.writeStaff(staffList);
    }

    @Override
    public void remove(int id) {
        int index = findIndexById(id);
        staffList.remove(index);
        readWriteStaff.writeStaff(staffList);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < staffList.size(); i++){
            if (staffList.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Staff> getAll() {
        this.staffList = this.readWriteStaff.readStaff();
        return this.staffList;
    }

    public Staff findStaffById(int id) {
        for (Staff staff : staffList){
            if (staff.getId()==id){
                return staff;
            }
        }
        return null;
    }

    public List<Staff> getStaffByName(String name){
        List<Staff> list = new ArrayList<>();
        for (Staff staff : staffList){
            if (staff.getName().toLowerCase().contains(name.toLowerCase())){
                list.add(staff);
            }
        }
        return list;
    }

    public List<Staff> getStaffByGender(String gender) {
        List<Staff> list = new ArrayList<>();
        for (Staff staff : staffList){
            if (staff.getGender().equalsIgnoreCase(gender)){
                list.add(staff);
            }
        }
        return list;
    }

    public List<Staff> getStaffByDepartment(int idDepartment) {
        List<Staff> list = new ArrayList<>();
        for (Staff staff : staffList) {
            if (staff.getIdDepartments()==idDepartment){
                list.add(staff);
            }
        }
        return list;
    }

    public List<Staff> getStaffByRangeAge(int min, int max){
        List<Staff> list = new ArrayList<>();
        for (Staff staff : staffList){
            if (staff.getAge()>=min && staff.getAge()<=max){
                list.add(staff);
            }
        }
        return list;
    }

    public double getSalaryForStaff(int id){
        Staff staff = findStaffById(id);
        if (staff != null){
            Department department = departmentManager.findDepartmentById(staff.getIdDepartments());
            if (department != null) {
                return staff.getTotalSalary(department);
            } else {
                return staff.getSalary();
            }
        }
        return 0;
    }

    public Staff getHighestSalaryStaff() {
        Staff highestSalaryStaff = null;
        double highestSalary = 0;
        for (Staff staff : staffList){
            Department department = departmentManager.findDepartmentById(staff.getIdDepartments());
            if (department!=null){
                double totalSalary = staff.getTotalSalary(department);
                if (totalSalary > highestSalary){
                    highestSalary = totalSalary;
                    highestSalaryStaff = staff;
                }
            }
        }
        return highestSalaryStaff;
    }

    public void sortStaffBySalary() {
        staffList.sort((s1,s2)->{
            Department department1 = departmentManager.findDepartmentById(s1.getIdDepartments());
            Department department2 = departmentManager.findDepartmentById(s2.getIdDepartments());

            double totalSalary1 = (department1 != null) ? s1.getTotalSalary(department1) : s1.getSalary();
            double totalSalary2 = (department2 != null) ? s2.getTotalSalary(department2) : s2.getSalary();

            return Double.compare(totalSalary2,totalSalary1);
        });
    }

}
