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
import java.util.List;

@Entity
@Table(name="badgesGiven")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class BadgesGiven {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="giver_id",nullable = false)
    User giver;

    @ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="receiver_id",nullable = false)
    User receiver;

    @Enumerated
     Star stars;

    @Size(max=500,message="Please Enter Message within range of {max} characters")
    String comment;

    @CreatedDate
    LocalDateTime createdAt;

    @LastModifiedDate
    LocalDateTime updateAt;


    Boolean flag;

    @Enumerated
    Quarter quarter;



}
