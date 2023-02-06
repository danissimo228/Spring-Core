package ru.nishpal.learning.entity;

import org.springframework.stereotype.Component;
import ru.nishpal.learning.depcrecated.DeprecatedClass;
import ru.nishpal.learning.inject.InjectRandomInt;
import ru.nishpal.learning.postproxy.PostProxy;
import ru.nishpal.learning.profilingclass.Profiling;

import javax.annotation.PostConstruct;

@Profiling
@Component
@DeprecatedClass(newImpl = SuperUser.class)
public class User implements Person {
    @InjectRandomInt(min = 1, max = 10)
    private int age;

    private String name = "someName";

    @PostConstruct
    public void init() {
        System.out.println("Phase 2");
    }

    public User() {
        System.out.println("Phase 1");
    }

    @Override
    @PostProxy
    public void sayName() {
        System.out.println("Phase 3");
        for (int i = 0; i < age; i++) {
            System.out.println(name);
        }
    }

    public void setName(String name) {
        this.name = name;
    }
}
