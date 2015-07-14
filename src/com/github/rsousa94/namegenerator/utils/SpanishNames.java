package com.github.rsousa94.namegenerator.utils;


import java.io.IOException;
import java.util.Random;


public class SpanishNames extends Names {

    public static final String SURNAMES_FILENAME = "spanish_surnames.txt";
    public static final String MALE_NAMES_FILENAME = "spanish_male.txt";
    public static final String FEMALE_NAMES_FILENAME = "spanish_female.txt";

    public String[] mMaleNames;
    public String[] mFemaleNames;
    public String[] mSurnames;

    public SpanishNames() throws IOException {
        mSurnames = readNames(SURNAMES_FILENAME);
        mMaleNames = readNames(MALE_NAMES_FILENAME);
        mFemaleNames = readNames(FEMALE_NAMES_FILENAME);
    }

    /**
     * Generates a random name for a given gender
     * A Dutch name consists of one or more given names and a surname.
     *
     * @param gender the gender of the name
     * @return A random Chinese name for a certain gender including a given name and a surname
     */
    @Override
    public String nextName(int gender) {
        Random random = new Random();
        String name = "";
        int names = random.nextInt(3) + 1;
        int surnames = random.nextInt(3) + 1;

        for (int i = 0; i < names; i++) {
            if (gender == Names.FEMALE)
                name += mFemaleNames[random.nextInt(mFemaleNames.length)] + " ";
            else
                name += mMaleNames[random.nextInt(mMaleNames.length)] + " ";
        }

        for (int i = 0; i < surnames; i++) {
            if (i != surnames - 1)
                name += mSurnames[random.nextInt(mSurnames.length)] + " ";
            else
                name += mSurnames[random.nextInt(mSurnames.length)];
        }

        return name;
    }
}
