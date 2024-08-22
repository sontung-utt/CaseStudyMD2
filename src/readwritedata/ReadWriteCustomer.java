package readwritedata;

import model.person.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteCustomer {
    File file = new File("data/person/customer.csv");
    public void writeCustomer(List<Customer> customerList) {
        String data = "";
        for (Customer customer : customerList){
            data += customer.getId() + "," + customer.getName() + "," + customer.getAge() + "," + customer.getGender() + "," +customer.getAddress() + "," +
                    customer.getEmail() + "," + customer.getPhone() + "," + customer.getNumOfPurchase() + "," + customer.getTotalMoney() + "\n";
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

    public List<Customer> readCustomer() {
        List<Customer> customers = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine())!= null) {
                String[] data = line.split(",");
                Customer customer = new Customer(Integer.parseInt(data[0]),data[1],Integer.parseInt(data[2]),data[3],data[4],data[5],data[6],Integer.parseInt(data[7]),Double.parseDouble(data[8]));
                customers.add(customer);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return customers;
    }
}
