package validate;

import input.Input;

public class Validate {
    public static String validateName() {
        String regex = "^[A-ZĐÂÊÔƠƯ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]+(?:\\s[A-ZĐÂÊÔƠƯ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]+)*$";
        do {
            System.out.print("Nhập tên: ");
            String name = Input.inputString();
            if (name.matches(regex)) {
                return name;
            } else {
                System.out.println("Tên sai định dạng! Yêu cầu nhập lại.");
            }
        } while (true);
    }

    public static String validateEmail() {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        do {
            System.out.print("Nhập email: ");
            String email = Input.inputString();
            if(email.matches(regex)){
                return email;
            } else {
                System.out.println("Email sai định dạng! Yêu cầu nhập theo định dạng test@gmail.com");
            }
        } while (true);
    }

    public static String validatePhone() {
        String regex = "^0[1-9]\\d{8}$";
        do {
            System.out.print("Nhập số điện thoại: ");
            String phone = Input.inputString();
            if(phone.matches(regex)){
                return phone;
            } else {
                System.out.println("Số điện thoại phải có định dạng 10 chữ số và số thứ hai khác 0");
            }
        } while (true);
    }

    public static String validateUsername(){
        String regex = "^[a-zA-Z0-9]{6,20}$";
        do {
            System.out.print("Nhập tên tài khoản: ");
            String userName = Input.inputString();
            if(userName.matches(regex)){
                return userName;
            } else {
                if (userName.length()<6 || userName.length()>20){
                    System.out.println("Tên tài khoản phải có ít nhất 6 và tối đa 20 kí tự!");
                } else {
                    System.out.println("Tài khoản chỉ có số hoặc chữ!");
                }
            }
        } while (true);
    }

    public static String validatePassword() {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@!#$%^&+=<>?/|]).{8,20}$";
        do {
            System.out.print("Nhập mật khẩu: ");
            String passWord = Input.inputString();
            if(passWord.matches(regex)){
                return passWord;
            } else {
                if(passWord.length() < 8 || passWord.length() > 20) {
                    System.out.println("Mật khẩu phải có ít nhất 8 và tối đa 20 ký tự!");
                } else {
                    System.out.println("Mật khẩu phải có đủ ký tự (Chữ hoa, chữ thường, số, kí tự đặc biệt)!");
                }
            }
        } while (true);
    }
}
