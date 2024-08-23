package readwritedata;

import model.user.CustomerUser;
import model.user.StaffUser;
import model.user.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteUser {
    File file = new File("data/user/user.csv");
    public void writeUser(List<User> list) {
        String data = "";
        for (User user : list){
            String role = "";
            if (user instanceof StaffUser) role = "StaffUser";
            if (user instanceof CustomerUser) role = "CustomerUser";
            data += role + "," + user.getUserName() + "," + user.getPassword() + "\n";
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public List<User> readUser() {
        List<User> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine())!=null){
                String[] data = line.split(",");
                String role = data[0];
                String userName = data[1];
                String passWord = data[2];
                User user = null;
                switch (role) {
                    case "StaffUser":
                        user = new StaffUser(userName,passWord);
                        break;
                    case "CustomerUser":
                        user = new CustomerUser(userName,passWord);
                        break;
                    default:
                        System.out.println("Loại tài khoản " + role + " không hợp lệ!");
                        continue;
                }
                list.add(user);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
