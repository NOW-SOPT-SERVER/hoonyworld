package org.example;

import org.example.classes.Person;
import org.example.classes.PersonBuilder;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("이동훈",24, "Male");
        person1.walk();
        Person person2 = new Person("동훈", 45);
        person1.walk();

        // getter
        System.out.println(person1.getName());
        System.out.println(person2.getName());

        // setter
        person1.setName("삼동훈");
        System.out.println(person1.getName());

        // static
        Person.run();
        Person p = new Person("d", 3, "D");

        // PersonBuilder
        Person personWithBuilder = new PersonBuilder()
                .name("이동훈")
                .age(24)
                .sex("male")
                .build();

        // 정적 팩토리 메서드 패턴
        Person personWithFactoryMethod = Person.create("이동훈", 24, "Male");
    }
}