package com.github.rsousa94.namegenerator;

import com.github.rsousa94.namegenerator.utils.Names;

public class Main {

    public static void main(String[] args) {

        NameGenerator nameGenerator = new NameGenerator(NameGenerator.ENGLISH);
        String name = nameGenerator.nextName();
        System.out.println(name);
    }
}
