package com.github.rsousa94.namegenerator.utils;




import com.github.rsousa94.namegenerator.NameGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public abstract class Names {

    public static final String NAMES_FOLDER = "names";
    public static final int FEMALE = 0;
    public static final int MALE = 1;


    public String nextName(){
        Random random = new Random();
        // get random gender
        boolean gender = random.nextBoolean();

        if(gender)
            return nextName(Names.FEMALE);
        else
            return nextName(Names.MALE);
    }

    public abstract String nextName(int gender);

    static String[] readNames(String filename) throws IOException {
        ArrayList<String> tmp = new ArrayList<>();
        InputStream inputStream = NameGenerator.class.getClassLoader().getResourceAsStream(NAMES_FOLDER+"/"+filename);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String input = bufferedReader.readLine();
        while (input!= null){
            tmp.add(input);
            input = bufferedReader.readLine();
        }

        return tmp.toArray(new String[tmp.size()]);
    }


}
