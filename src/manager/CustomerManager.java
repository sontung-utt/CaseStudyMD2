package manager;

import model.person.Customer;
import readwritedata.ReadWriteCustomer;

import java.util.Collections;
import java.util.List;

public class CustomerManager implements IManager<Customer>{
    List<Customer> customers;
    ReadWriteCustomer readWriteCustomer = new ReadWriteCustomer();
    public CustomerManager(){
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
        customers.set(index,customer);
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
        for (int i = 0; i < customers.size(); i++){
            if (customers.get(i).getId()==id){
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

    public Customer findCustomerById (int id) {
        for (Customer customer : customers){
            if (customer.getId()==id){
                return customer;
            }
        }
        return null;
    }
}
