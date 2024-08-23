package manager;

import model.user.CustomerUser;
import model.user.StaffUser;
import model.user.User;
import readwritedata.ReadWriteUser;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    ReadWriteUser readWriteUser = new ReadWriteUser();
    List<User> users;
    public AccountManager() {
        this.users = this.readWriteUser.readUser();
    }

    public void addUser(User user){
        users.add(user);
        readWriteUser.writeUser(users);
    }

    public boolean checkExistUserStaff(String userName) {
        for (User user : users){
            if (user instanceof StaffUser){
                if (user.getUserName().equals(userName)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkExistUserCustomer(String userName) {
        for (User user : users){
            if (user instanceof CustomerUser){
                if (user.getUserName().equals(userName)){
                    return false;
                }
            }
        }
        return true;
    }

    public void updateUser(String userName, User user){
        int index = findIndexByUserName(userName);
        users.set(index,user);
        readWriteUser.writeUser(users);
    }

    public void updateUserPassWord(String userName, String passWord, String newPassWord, User user){
        int index = findIndexByUserNamePassWord(userName,passWord);
        user = users.get(index);
        user.setPassword(newPassWord);
        users.set(index,user);
        readWriteUser.writeUser(users);
    }

    public void removeUser(String userName, String passWord, User user) {
        int index = findIndexByUserNamePassWord(userName,passWord);
        user = users.get(index);
        users.remove(user);
        readWriteUser.writeUser(users);
    }

    public int findIndexByUserName(String userName){
        this.users = this.readWriteUser.readUser();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(userName)){
                return i;
            }
        }
        return -1;
    }

    public int findIndexByUserNamePassWord (String userName, String passWord) {
        this.users = this.readWriteUser.readUser();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(userName) && users.get(i).getPassword().equals(passWord)){
                return i;
            }
        }
        return -1;
    }

    public User findUserByUserNamePassWord(String userName, String passWord){
        this.users = this.readWriteUser.readUser();
        for (User user : users) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(passWord)){
                return user;
            }
        }
        return null;
    }

    public User findCustomerUserByUserNamePassWord(String userName, String passWord){
        this.users = this.readWriteUser.readUser();
        for (User user : users) {
            if (user instanceof CustomerUser){
                if (user.getUserName().equals(userName) && user.getPassword().equals(passWord)){
                    return user;
                }
            }
        }
        return null;
    }

    public User findStaffUserByUserNamePassWord(String userName, String passWord){
        this.users = this.readWriteUser.readUser();
        for (User user : users) {
            if (user instanceof StaffUser){
                if (user.getUserName().equals(userName) && user.getPassword().equals(passWord)){
                    return user;
                }
            }
        }
        return null;
    }

    public boolean loginCustomer(String userName, String passWord){
        for(User user : users) {
            if (user instanceof CustomerUser){
                if (user.getUserName().equals(userName) && user.getPassword().equals(passWord)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean loginStaff(String userName, String passWord){
        for(User user : users) {
            if (user instanceof StaffUser){
                if (user.getUserName().equals(userName) && user.getPassword().equals(passWord)){
                    return true;
                }
            }
        }
        return false;
    }

    public List<User> getUserByUserName(String userName){
        this.users = this.readWriteUser.readUser();
        List<User> list = new ArrayList<>();
        for (User user : users){
            if(user.getUserName().toLowerCase().contains(userName.toLowerCase())){
                list.add(user);
            }
        }
        return list;
    }

    public List<User> getAll(){
        this.users = this.readWriteUser.readUser();
        return this.users;
    }

    public List<CustomerUser> getCustomerUser() {
        List<CustomerUser> list = new ArrayList<>();
        for (User user : users){
            if(user instanceof CustomerUser){
                list.add((CustomerUser) user);
            }
        }
        return list;
    }

    public List<StaffUser> getStaffUser() {
        List<StaffUser> list = new ArrayList<>();
        for (User user : users){
            if(user instanceof StaffUser){
                list.add((StaffUser) user);
            }
        }
        return list;
    }
}
