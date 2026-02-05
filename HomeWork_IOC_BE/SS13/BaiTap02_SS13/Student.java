package IOC_BE.SS13.BaiTap02_SS13;

import java.util.Scanner;

public class Student implements IBaseStudent {
    private int id;
    private String name;
    private String email;

    public Student() {
    }

    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    //    getter setter
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

    @Override
    public void inputStudnet(Scanner sc) {

    }

    @Override
    public void displayData() {
        System.out.printf("ID: %d | Name: %s | Email: %s\n", this.id, this.name, this.email);
    }
}