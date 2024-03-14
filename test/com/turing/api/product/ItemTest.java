package com.turing.api.product;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @org.junit.jupiter.api.Test
    void systemOut() {
        Item s = new Item();
        String s3=s.systemOut();
        System.out.println("___>"+s3);
        String s2 = "Hello";
        Assertions.assertEquals(s.systemOut(),"Hello");
    }

    @org.junit.jupiter.api.Test
    void add() {
        Item a1 = new Item();
       /* int a3 =a1.add();
        System.out.println();
        System.out.println("___>"+a3);*/
        int a = 1;
        int b = 2;
        assertEquals(a1.add(3,2),5);
    }
}