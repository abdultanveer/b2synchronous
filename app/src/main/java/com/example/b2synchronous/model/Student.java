package com.example.b2synchronous.model;

//model pojo VO
public class Student {
    String name;
    int age;
    int phno;

    public Student(String name, int age, int phno) {
        this.name = name;
        this.age = age;
        this.phno = phno;
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

    public int getPhno() {
        return phno;
    }

    public void setPhno(int phno) {
        this.phno = phno;
    }
}
