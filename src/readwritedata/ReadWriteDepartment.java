package readwritedata;

import model.department.Department;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteDepartment {
    File file = new File("data/department/department.csv");
    public void writeDepartment(List<Department> departments){
        String data ="";
        for (Department department : departments){
            data += department.getId() + "," + department.getName() + "," + department.getSalaryCoefficient() + "\n";
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public List<Department> readDepartment() {
        List<Department> departments = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine())!=null){
                String data[] = line.split(",");
                Department department = new Department(Integer.parseInt(data[0]),data[1],Double.parseDouble(data[2]));
                departments.add(department);
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return departments;
    }
}
