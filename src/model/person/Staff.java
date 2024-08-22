package model.person;

import model.department.Department;

public class Staff extends Person{
    private static int idIncrement = 1;
    private int idDepartments;
    private double salary;

    public Staff(){
    }

    public Staff(String name, int age, String gender, String address, String email, String phone, int idDepartments, double salary){
        super(idIncrement, name, age, gender, address, email, phone);
        this.idDepartments = idDepartments;
        this.salary = salary;
        idIncrement++;
    }

    public Staff(int id,String name, int age, String gender, String address, String email, String phone, int idDepartments, double salary){
        super(id, name, age, gender, address, email, phone);
        this.idDepartments = idDepartments;
        this.salary = salary;
        if (id >= idIncrement){
            idIncrement = id + 1;
        }
    }

    public int getIdDepartments() {
        return idDepartments;
    }

    public void setIdDepartments(int idDepartments) {
        this.idDepartments = idDepartments;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getTotalSalary(Department department) {
        if (department.getId()==this.idDepartments){
            return salary * department.getSalaryCoefficient();
        }
        return this.salary;
    }

    public String toString() {
        return "=====Nhân sự====="
                + super.toString() +
                "\nTiền lương: " + salary;
    }
}
