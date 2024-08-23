package model.user;

public abstract class User {
    private String userName;
    private String passWord;

    public User(){
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return passWord;
    }

    public void setPassword(String password) {
        this.passWord = password;
    }

    public abstract String getRole();

    public String toString(){
        return "Tên đăng nhập: " + userName;
    }
}
