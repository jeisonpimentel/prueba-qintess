package com.example.prueba.entity;

import java.util.Comparator;

public class Prueba1 {

    private int age;
    private String name;

    public Prueba1(){}

    public Prueba1(final int age, final String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
