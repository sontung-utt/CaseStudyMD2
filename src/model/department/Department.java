package model.department;

public class Department {
    private int id;
    private String name;
    private double salaryCoefficient;
    private static int idIncrement = 1;

    public Department(){
    }

    public Department(String name, double salaryCoefficient){
        this.id = idIncrement;
        this.name = name;
        this.salaryCoefficient = salaryCoefficient;
        idIncrement++;
    }

    public Department(int id, String name, double salaryCoefficient){
        this.id = id;
        this.name = name;
        this.salaryCoefficient = salaryCoefficient;
        if (id >= idIncrement){
            idIncrement = id + 1;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public double getSalaryCoefficient() {
        return salaryCoefficient;
    }

    public void setSalaryCoefficient(double salaryCoefficient) {
        this.salaryCoefficient = salaryCoefficient;
    }

    public String toString() {
        return "=====Phòng ban=====" +
                "\nMã văn phòng: " + id +
                "\nTên văn phòng: " + name +
                "\nHệ số lương: " + salaryCoefficient;
    }
}
