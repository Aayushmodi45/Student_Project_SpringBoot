package com.example.studentdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student
{
    @Id
    @GeneratedValue
    int sid;

    @Column(name="name")
    String name;

    @Column(name = "mail")
    String mail;

    @Column(name = "pass")
    String pass;

    @Column(name = "mobile")
    String mobile;

    public Student()
    {

    }
    public Student(String name, String mail, String pass, String mobile) {
        this.name = name;
        this.mail = mail;
        this.pass = pass;
        this.mobile = mobile;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
