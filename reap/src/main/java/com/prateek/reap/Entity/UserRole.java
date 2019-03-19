package com.prateek.reap.Entity;

import com.prateek.reap.aop.TimestampAware;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "user_role")
public class UserRole implements TimestampAware<Integer> {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Integer id;

        String name;

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Integer getGoldStar() {
                return goldStar;
        }

        public void setGoldStar(Integer goldStar) {
                this.goldStar = goldStar;
        }

        public Integer getSilverStar() {
                return silverStar;
        }

        public void setSilverStar(Integer silverStar) {
                this.silverStar = silverStar;
        }

        public Integer getBronzeStar() {
                return bronzeStar;
        }

        public void setBronzeStar(Integer bronzeStar) {
                this.bronzeStar = bronzeStar;
        }

        public Integer getPriority() {
                return priority;
        }

        public void setPriority(Integer priority) {
                this.priority = priority;
        }

        public Set<User> getUsers() {
                return users;
        }

        public void setUsers(Set<User> users) {
                this.users = users;
        }

        Integer goldStar;

        Integer silverStar;

        Integer bronzeStar;

        Integer priority;

        @ManyToMany(fetch = FetchType.EAGER,
                mappedBy = "roles")
        Set<User> users = new HashSet<>();

        LocalDateTime createdAt;

        LocalDateTime updatedAt;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public LocalDateTime getCreatedAt() {
                return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
                this.createdAt = createdAt;
        }

        public LocalDateTime getUpdatedAt() {
                return updatedAt;
        }

        public void setUpdatedAt(LocalDateTime updatedAt) {
                this.updatedAt = updatedAt;
        }



}
