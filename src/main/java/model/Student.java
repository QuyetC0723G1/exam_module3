package model;

import java.sql.Date;

public class Student {
    private int id;
   private String name;
    private String email;
    private String birthday;
    private String address;
    private  String phonenumber;
    private String classRoomId;
    private Clazz clazz;


    public Student(String name, String email, String birthday, String address, String phonenumber, String classRoomId) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
        this.phonenumber = phonenumber;
        this.classRoomId = classRoomId;
    }

    public Student(int id, String name, String email, String birthday, String address, String phonenumber, String classRoomId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
        this.phonenumber = phonenumber;
        this.classRoomId = classRoomId;
    }

    public Student(int id, String name, String email, String birthday, String address, String phonenumber, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
        this.phonenumber = phonenumber;
        this.clazz = clazz;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDay() {
        return birthday;
    }

    public void setBirthDay(String birthDay) {
        this.birthday = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phonenumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phonenumber = phoneNumber;
    }

    public String getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(String classRoomId) {
        this.classRoomId = classRoomId;
    }
}
