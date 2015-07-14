package com.github.rsousa94.namegenerator;


public class Main {

    public static void main(String[] args) {

        NameGenerator nameGenerator = new NameGenerator(NameGenerator.ENGLISH);
        String name = nameGenerator.nextName();
        System.out.println(name);
    }
}
