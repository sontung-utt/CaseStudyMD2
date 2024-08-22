package manager;

import model.department.Department;
import readwritedata.ReadWriteDepartment;

import java.util.Collections;
import java.util.List;

public class DepartmentManager implements IManager<Department>{
    List<Department> departments;
    ReadWriteDepartment readWriteDepartment = new ReadWriteDepartment();
    public DepartmentManager(){
        this.departments = this.readWriteDepartment.readDepartment();
    }

    @Override
    public void add(Department department) {
        departments.add(department);
        readWriteDepartment.writeDepartment(departments);
    }

    @Override
    public void update(int id, Department department) {
        int index = findIndexById(id);
        departments.set(index,department);
        readWriteDepartment.writeDepartment(departments);
    }

    @Override
    public void remove(int id) {
        int index = findIndexById(id);
        departments.remove(index);
        readWriteDepartment.writeDepartment(departments);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < departments.size(); i++) {
            if (departments.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Department> getAll() {
        this.departments = this.readWriteDepartment.readDepartment();
        return this.departments;
    }

    public Department findDepartmentById(int id) {
        for (Department department : departments){
            if (department.getId() == id){
                return department;
            }
        }
        return null;
    }

    public int getDepartmentId(int index){
        Department department = departments.get(index);
        return department.getId();
    }
}
