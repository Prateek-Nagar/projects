package com.prateek.reap.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "item")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(nullable = false)
    @Size(min = 0, max = 30, message = "Please Enter Name in Range of 0-30 characters")
    String name;

    @Column(nullable = true)
    String imageUrl;

    @Column(nullable = false)
    Integer weightage;

    Boolean activeFlag;

    @CreatedDate
    LocalDateTime createdAt;

    @LastModifiedDate
    LocalDateTime updateAt;

    @OneToMany
    Set<ItemMapUser> itemMapUsers = new HashSet<>();


}
