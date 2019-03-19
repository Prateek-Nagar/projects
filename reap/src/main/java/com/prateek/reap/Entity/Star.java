package com.prateek.reap.Entity;

public enum Star {
    GOLD(30),SILVER(20),BRONZE(10);
    int weightage;

    Star(int weightage)
    {
        this.weightage=weightage;
    }
}
