package com.edu.ulab.app.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends EntityStorage {
    private String fullName;
    private String title;
    private int age;
    private Set<Long> booksId = new HashSet<>();

    public void update(UserEntity user){
        this.age = user.getAge();
        this.title = user.getTitle();
        this.fullName = user.getFullName();
        this.id = user.getId();
    }
}
