package org.example;

import org.junit.Test;

import java.util.ArrayList;

public class JavaStreams {
    @Test
    public void regular() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Alekhya");
        names.add("Adam");
        names.add("Ram");
        int count = 0;
        for (String actual : names) {
            if (actual.startsWith("A")) {
                count++;
            }

        }

        System.out.println(count);

    }
    @Test
    public void streamFilter() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Alekhya");
        names.add("Adam");
        names.add("Ram");

        Long c = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);
    }
}
