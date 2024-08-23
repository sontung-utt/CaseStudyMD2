package model.user;

public class CustomerUser extends User{
    public CustomerUser(){
    }

    public CustomerUser(String userName, String passWord) {
        super(userName, passWord);
    }

    @Override
    public String getRole() {
        return "Khách hàng";
    }

    public String toString(){
        return super.toString() +
                "\nLoại tài khoản: " + getRole();
    }
}
