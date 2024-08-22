package manager;

import model.person.Customer;
import readwritedata.ReadWriteCustomer;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager implements IManager<Customer> {
    List<Customer> customers;
    ReadWriteCustomer readWriteCustomer = new ReadWriteCustomer();

    public CustomerManager() {
        this.customers = this.readWriteCustomer.readCustomer();
    }

    @Override
    public void add(Customer customer) {
        customers.add(customer);
        readWriteCustomer.writeCustomer(customers);
    }

    @Override
    public void update(int id, Customer customer) {
        int index = findIndexById(id);
        customers.set(index, customer);
        readWriteCustomer.writeCustomer(customers);
    }

    @Override
    public void remove(int id) {
        int index = findIndexById(id);
        customers.remove(index);
        readWriteCustomer.writeCustomer(customers);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Customer> getAll() {
        this.customers = this.readWriteCustomer.readCustomer();
        return this.customers;
    }

    public Customer findCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> getCustomerByName(String name) {
        List<Customer> list = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getName().toLowerCase().contains(name.toLowerCase())) {
                list.add(customer);
            }
        }
        return list;
    }

    public List<Customer> getCustomerByGender(String gender) {
        List<Customer> list = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getGender().equalsIgnoreCase(gender)) {
                list.add(customer);
            }
        }
        return list;
    }

    public List<Customer> getCustomerByEmailPhone(String email, String phone) {
        List<Customer> list = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getEmail().toLowerCase().contains(email.toLowerCase()) && customer.getPhone().contains(phone)) {
                list.add(customer);
            }
        }
        return list;
    }

    public List<Customer> getCustomerByRangeAge(int min, int max) {
        List<Customer> list = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getAge() >= min && customer.getAge() < max) {
                list.add(customer);
            }
        }
        return list;
    }

    public Customer getCustomerHighestPurchase() {
        Customer highestCustomerPurchase = null;
        int maxOfPurchase = customers.get(0).getNumOfPurchase();
        for (Customer customer : customers) {
            if (customer.getNumOfPurchase() > maxOfPurchase) {
                maxOfPurchase = customer.getNumOfPurchase();
                highestCustomerPurchase = customer;
            }
        }
        return highestCustomerPurchase;
    }

    public Customer getCustomerHighestTotalMoney() {
        Customer highestCustomerTotalMoney = null;
        double maxTotalMoney = customers.get(0).getTotalMoney();
        for (Customer customer : customers) {
            if (customer.getNumOfPurchase() > maxTotalMoney) {
                maxTotalMoney = customer.getTotalMoney();
                highestCustomerTotalMoney = customer;
            }
        }
        return highestCustomerTotalMoney;
    }

    public List<Customer> sortCustomerByTotalMoney() {
        List<Customer> list = getAll();
        list.sort((s1, s2) -> Double.compare(s2.getTotalMoney(), s1.getTotalMoney()));
        return list;
    }
}
