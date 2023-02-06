package ru.nishpal.learning.entity;

import org.springframework.stereotype.Component;

@Component
public class SuperUser extends User implements Person{
    @Override
    public void init() {
        System.out.println("Я ЖИДКИЙ");
    }
}
