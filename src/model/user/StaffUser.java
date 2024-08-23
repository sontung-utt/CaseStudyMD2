package model.user;

public class StaffUser extends User{
    public StaffUser(){
    }

    public StaffUser(String userName, String passWord){
        super(userName,passWord);
    }

    @Override
    public String getRole() {
        return "Nhân sự";
    }

    public String toString(){
        return super.toString() +
                "\nLoại tài khoản: " + getRole();
    }
}
