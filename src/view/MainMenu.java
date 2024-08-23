package view;

import input.Input;
import manager.AccountManager;
import model.user.CustomerUser;
import model.user.StaffUser;
import model.user.User;
import validate.Validate;

import java.util.List;

public class MainMenu {
    AccountManager accountManager = new AccountManager();
    MainMenuStaff mainMenuStaff = new MainMenuStaff();
    MainMenuCustomer mainMenuCustomer = new MainMenuCustomer();

    public void showMainMenu() {
        int choice;
        do {
            System.out.println("==========Trang chủ hệ thống==========");
            System.out.println("1. Đăng nhập hệ thống");
            System.out.println("2. Đăng ký tài khoản");
            System.out.println("3. Đổi mật khẩu");
            System.out.println("4. Sửa thông tin tài khoản");
            System.out.println("5. Xóa tài khoản");
            System.out.println("6. Tìm kiếm tài khoản theo tên gần đúng");
            System.out.println("7. Danh sách tài khoản");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    showLogin();
                    break;
                case 2:
                    showRegister();
                    break;
                case 3:
                    showChangePassWord();
                    break;
                case 4:
                    showChangeUser();
                    break;
                case 5:
                    showRemoveUser();
                    break;
                case 6:
                    showGetUserByUserName();
                    break;
                case 7:
                    showUser();
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
            }
        } while (choice != 0);

    }

    private void showLogin(){
        System.out.println("=====Đăng nhập hệ thống=====");
        int choice;
        do {
            System.out.println("===Chọn loại tài khoản đăng nhập===");
            System.out.println("1. Tài khoản nhân sự");
            System.out.println("2. Tài khoản khách hàng");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    showLoginStaff();
                    break;
                case 2:
                    showLoginCustomer();
                    break;
                case 0:
                    System.out.println("Thoát đăng nhập!");
                    break;
                default:
                    System.out.println("không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }

    private void showLoginStaff(){
        System.out.println("=====Đăng nhập tài khoản nhân sự=====");
        System.out.print("Nhập tên đăng nhập: ");
        String userName = Input.inputString();
        System.out.print("Nhập mật khẩu: ");
        String passWord = Input.inputString();
        if(accountManager.loginStaff(userName,passWord)){
            System.out.println("Đăng nhập tài khoản nhân sự thành công!");
            mainMenuStaff.showMainMenuStaff();
        } else {
            System.out.println("Tên đăng nhập hoặc mật khẩu không đúng!");
        }
    }

    private void showLoginCustomer(){
        System.out.println("=====Đăng nhập tài khoản khách hàng=====");
        System.out.print("Nhập tên đăng nhập: ");
        String userName = Input.inputString();
        System.out.print("Nhập mật khẩu: ");
        String passWord = Input.inputString();
        if(accountManager.loginCustomer(userName,passWord)){
            System.out.println("Đăng nhập tài khoản khách hàng thành công!");
            mainMenuCustomer.showMainMenuCustomer();
        } else {
            System.out.println("Tên đăng nhập hoặc mật khẩu không đúng!");
        }
    }

    private void showRegister() {
        System.out.println("=====Đăng ký tài khoản=====");
        int choice;
        do {
            System.out.println("===Chọn loại đăng ký===");
            System.out.println("1. Tài khoản nhân sự");
            System.out.println("2. Tài khoản khách hàng");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    showRegisterStaff();
                    break;
                case 2:
                    showRegisterCustomer();
                    break;
                case 0:
                    System.out.println("Thoát đăng ký!");
                    break;
                default:
                    System.out.println("không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }

    private void showRegisterCustomer() {
        System.out.println("=====Đăng ký tài khoản khách hàng=====");
        String userName = Validate.validateUsername();
        if (accountManager.checkExistUserCustomer(userName)) {
            String passWord = Validate.validatePassword();
            CustomerUser customerUser = new CustomerUser(userName, passWord);
            accountManager.addUser(customerUser);
            System.out.println("Đăng ký tài khoản khách hàng thành công!");
        } else {
            System.out.println("Tên tài khoản đã tồn tại!");
        }
    }

    private void showRegisterStaff() {
        System.out.println("=====Đăng ký tài khoản nhân sự=====");
        String userName = Validate.validateUsername();
        if (accountManager.checkExistUserStaff(userName)) {
            String passWord = Validate.validatePassword();
            StaffUser staffUser = new StaffUser(userName, passWord);
            accountManager.addUser(staffUser);
            System.out.println("Đăng ký tài khoản nhân sự thành công!");
        } else {
            System.out.println("Tên tài khoản đã tồn tại!");
        }
    }

    private void showChangePassWord() {
        System.out.println("=====Đổi mật khẩu=====");
        int choice;
        do {
            System.out.println("===Chọn loại tài khoản===");
            System.out.println("1. Tài khoản nhân sự");
            System.out.println("2. Tài khoản khách hàng");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    changePassWordStaff();
                    break;
                case 2:
                    changePassWordCustomer();
                    break;
                case 0:
                    System.out.println("Thoát đổi mật khẩu!");
                    break;
                default:
                    System.out.println("không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }

    private void changePassWordCustomer() {
        System.out.println("=====Đổi mật khẩu tài khoản khách hàng=====");
        System.out.print("Nhập tên tài khoản: ");
        String userName = Input.inputString();
        System.out.print("Nhập mật khẩu cũ: ");
        String passWord = Input.inputString();
        User user = accountManager.findUserByUserNamePassWord(userName, passWord);
        if (user != null) {
            String newPassWord = Validate.validatePassword();
            CustomerUser customerUser = new CustomerUser(userName, passWord);
            accountManager.updateUserPassWord(userName, passWord, newPassWord, customerUser);
            System.out.println("Đổi mật khẩu thành công!");
        } else {
            System.out.println("Tên đăng nhập hoặc mật khẩu không đúng!");
        }
    }

    private void changePassWordStaff() {
        System.out.println("=====Đổi mật khẩu tài khoản nhân sự=====");
        System.out.print("Nhập tên tài khoản: ");
        String userName = Input.inputString();
        System.out.print("Nhập mật khẩu cũ: ");
        String passWord = Input.inputString();
        User user = accountManager.findUserByUserNamePassWord(userName, passWord);
        if (user != null) {
            String newPassWord = Validate.validatePassword();
            StaffUser staffUser = new StaffUser(userName, passWord);
            accountManager.updateUserPassWord(userName, passWord, newPassWord, staffUser);
            System.out.println("Đổi mật khẩu thành công!");
        } else {
            System.out.println("Tên đăng nhập hoặc mật khẩu không đúng!");
        }
    }

    private void showChangeUser() {
        System.out.println("=====Sửa thông tin tài khoản=====");
        int choice;
        do {
            System.out.println("===Chọn loại tài khoản===");
            System.out.println("1. Tài khoản nhân sự");
            System.out.println("2. Tài khoản khách hàng");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    showChangeUserStaff();
                    break;
                case 2:
                    showChangeUserCustomer();
                    break;
                case 0:
                    System.out.println("Thoát sửa thông tin!");
                    break;
                default:
                    System.out.println("không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }

    private void showChangeUserStaff() {
        System.out.println("=====Sửa thông tin tài khoản nhân sự=====");
        System.out.print("Nhập tên tài khoản: ");
        String userName = Input.inputString();
        System.out.print("Nhập mật khẩu: ");
        String passWord = Input.inputString();
        User user = accountManager.findStaffUserByUserNamePassWord(userName, passWord);
        if (user != null) {
            String newUserName = Validate.validateUsername();
            String newPassWord = Validate.validatePassword();
            if (accountManager.checkExistUserStaff(newUserName)){
                StaffUser staffUser = new StaffUser(newUserName, newPassWord);
                accountManager.updateUser(userName, staffUser);
                System.out.println("Sửa thông tin tài khoản thành công!");
            } else {
                System.out.println("Tên tài khoản đã tồn tại!");
            }
        } else {
            System.out.println("Tên đăng nhập hoặc mật khẩu không đúng!");
        }
    }

    private void showChangeUserCustomer() {
        System.out.println("=====Sửa thông tin tài khoản khách hàng=====");
        System.out.print("Nhập tên tài khoản: ");
        String userName = Input.inputString();
        System.out.print("Nhập mật khẩu: ");
        String passWord = Input.inputString();
        User user = accountManager.findCustomerUserByUserNamePassWord(userName, passWord);
        if (user != null) {
            String newUserName = Validate.validateUsername();
            String newPassWord = Validate.validatePassword();
            if(accountManager.checkExistUserCustomer(newUserName)){
                CustomerUser customerUser = new CustomerUser(newUserName, newPassWord);
                accountManager.updateUser(userName, customerUser);
                System.out.println("Sửa thông tin tài khoản thành công!");
            } else {
                System.out.println("Tên tài khoản đã tồn tại!");
            }
        } else {
            System.out.println("Tên đăng nhập hoặc mật khẩu không đúng!");
        }
    }

    private void showRemoveUser() {
        System.out.println("=====Xóa tài khoản=====");
        int choice;
        do {
            System.out.println("===Chọn loại tài khoản===");
            System.out.println("1. Tài khoản nhân sự");
            System.out.println("2. Tài khoản khách hàng");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    showRemoveUserStaff();
                    break;
                case 2:
                    showRemoveUserCustomer();
                    break;
                case 0:
                    System.out.println("Thoát xóa mật khẩu!");
                    break;
                default:
                    System.out.println("không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }

    private void showRemoveUserStaff() {
        System.out.println("=====Xóa tài khoản nhân sự=====");
        System.out.print("Nhập tên tài khoản: ");
        String userName = Input.inputString();
        System.out.print("Nhập mật khẩu: ");
        String passWord = Input.inputString();
        User user = accountManager.findUserByUserNamePassWord(userName, passWord);
        if (user != null) {
            StaffUser staffUser = new StaffUser(userName, passWord);
            accountManager.removeUser(userName, passWord, staffUser);
            System.out.println("Xóa tài khoản thành công!");
        } else {
            System.out.println("Tên đăng nhập hoặc mật khẩu không đúng!");
        }
    }

    private void showRemoveUserCustomer() {
        System.out.println("=====Xóa tài khoản khách hàng=====");
        System.out.print("Nhập tên tài khoản: ");
        String userName = Input.inputString();
        System.out.print("Nhập mật khẩu: ");
        String passWord = Input.inputString();
        User user = accountManager.findUserByUserNamePassWord(userName, passWord);
        if (user != null) {
            CustomerUser customerUser = new CustomerUser(userName, passWord);
            accountManager.removeUser(userName, passWord, customerUser);
            System.out.println("Xóa tài khoản thành công!");
        } else {
            System.out.println("Tên đăng nhập hoặc mật khẩu không đúng!");
        }
    }

    private void showGetUserByUserName() {
        System.out.println("=====Tìm kiếm tài khoản theo tên gần đúng=====");
        System.out.print("Nhập tên tài khoản: ");
        String userName = Input.inputString();
        List<User> list = accountManager.getUserByUserName(userName);
        if (list.isEmpty()){
            System.out.println("Không có tài khoản nào có tên chứa " + userName);
        } else {
            System.out.println("Danh sách tài khoản có tên chứa " + userName);
            for (User user : list) {
                System.out.println(user);
            }
        }
    }

    private void showUser() {
        System.out.println("=====Danh sách tài khoản=====");
        int choice;
        do {
            System.out.println("===Chọn loại tài khoản===");
            System.out.println("1. Tài khoản nhân sự");
            System.out.println("2. Tài khoản khách hàng");
            System.out.println("3. Tất cả tài khoản");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    showStaffUser();
                    break;
                case 2:
                    showCustomerUser();
                    break;
                case 3:
                    showAllUser();
                    break;
                case 0:
                    System.out.println("Thoát danh sách tài khoản!");
                    break;
                default:
                    System.out.println("không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }

    private void showAllUser() {
        System.out.println("=====Danh sách tất cả tài khoản=====");
        List<User> list = accountManager.getAll();
        for(User user : list){
            System.out.println(user);
        }
    }

    private void showCustomerUser() {
        System.out.println("=====Danh sách tài khoản khách hàng=====");
        List<CustomerUser> list = accountManager.getCustomerUser();
        for (User user : list){
            System.out.println(user);
        }
    }

    private void showStaffUser() {
        System.out.println("=====Danh sách tài khoản nhân sự=====");
        List<StaffUser> list = accountManager.getStaffUser();
        for (User user : list){
            System.out.println(user);
        }
    }
}
