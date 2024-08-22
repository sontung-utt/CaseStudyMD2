package model.person;

public class Person {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String address;
    private String email;
    private String phone;

    public Person(){
    }

    public Person(String name, int age, String gender, String address, String email, String phone){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public Person(int id, String name, int age, String gender, String address, String email, String phone){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "\nTên: " + name +
                "\nTuổi: " + age +
                "\nGiới tính: " + gender +
                "\nĐịa chỉ: " + address +
                "\nEmail: " + email +
                "\nPhone: " + phone;
    }

}
