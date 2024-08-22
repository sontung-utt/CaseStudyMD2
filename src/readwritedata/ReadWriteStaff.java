package readwritedata;

import model.person.Staff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteStaff {
    File file = new File("data/person/staff.csv");

    public void writeStaff(List<Staff> staffList) {
        String data = "";
        for (Staff staff : staffList) {
            data += staff.getId() + "," + staff.getName() + "," + staff.getAge() + "," + staff.getGender() + "," + staff.getAddress() + "," +
                    staff.getEmail() + "," + staff.getPhone() + "," + staff.getIdDepartments() + "," + staff.getSalary() + "\n";
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Staff> readStaff() {
        List<Staff> staffList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine())!=null){
                String[] data = line.split(",");
                Staff staff = new Staff(Integer.parseInt(data[0]),data[1],Integer.parseInt(data[2]),data[3],data[4],data[5],data[6],Integer.parseInt(data[7]),Double.parseDouble(data[8]));
                staffList.add(staff);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return staffList;
    }
}
