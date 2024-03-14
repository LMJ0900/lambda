package com.turing.api.enums;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum Navigation {
    EXIT("x", (sc) -> {
        return false;
    }),
    MEMBER("m", (sc) -> {
        return true;
    }),
    ARTICLE("a", (sc) -> {
        return true;
    }),
    BOARD("b", (sc) -> {
        return true;
    }),
    CRAWLER("c", (sc) -> {
        return true;
    }),
    ACCOUNT("ac", (sc) -> {
        return true;
    }),
    NAVIGATION_ERROR("er", (sc) -> {
        return true;
    }),
    ;
    private final String menu;
    private final Predicate<Scanner> predicate;

    Navigation(String menu, Predicate<Scanner> predicate) {
        this.menu = menu;
        this.predicate = predicate;
    }

    public static boolean selectmain(Scanner sc) {
        System.out.println(
                "x-Exit u-user a-Article ac-Account c-Crawler b-Board");
        String msg = sc.next();
        return Stream.of(Navigation.values())
                .filter(i -> i.menu.equals(msg))
                .findAny().orElse(NAVIGATION_ERROR)
                .predicate.test(sc);
    }

}
