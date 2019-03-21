package com.prateek.reap.Entity;

public enum RoleType {
    ADMIN(0), USER(1), SUPERVISOR(2), PRACTICEHEAD(3);
    int priority;

    RoleType(int priority) {
        this.priority = priority;
    }
}
