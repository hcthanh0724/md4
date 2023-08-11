package com.example.demothymeleaf.model;

public class Student {
    private int id;
    private String name;
    private int age;
    private String country;
    private String img;
    private int id_class;
    private String name_class;

    public Student() {
    }

    public Student(int id, String name, int age, String country, String img, String name_class) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.country = country;
        this.img = img;
        this.name_class = name_class;
    }

    public Student(int id, String name, int age, String country, String img, int id_class, String name_class) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.country = country;
        this.img = img;
        this.id_class = id_class;
        this.name_class = name_class;
    }

    public String getName_class() {
        return name_class;
    }

    public void setName_class(String name_class) {
        this.name_class = name_class;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getId_class() {
        return id_class;
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }
}
