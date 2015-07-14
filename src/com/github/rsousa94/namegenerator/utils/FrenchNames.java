package com.github.rsousa94.namegenerator.utils;


import java.io.IOException;
import java.util.Random;


public class FrenchNames extends Names {

    public static final String SURNAMES_FILENAME = "french_surnames.txt";
    public static final String MALE_NAMES_FILENAME = "french_male.txt";
    public static final String FEMALE_NAMES_FILENAME = "french_female.txt";

    public String[] mMaleNames;
    public String[] mFemaleNames;
    public String[] mSurnames;

    public FrenchNames() throws IOException {
        mSurnames = readNames(SURNAMES_FILENAME);
        mMaleNames = readNames(MALE_NAMES_FILENAME);
        mFemaleNames = readNames(FEMALE_NAMES_FILENAME);
    }

    /**
     * Generates a random name for a given gender
     *
     * @param gender the gender of the name
     * @return A random French name for a certain gender including a given name and a surname
     */
    @Override
    public String nextName(int gender) {
        Random random = new Random();
        String name = "";
        int names = random.nextInt(3) + 1;

        for (int i = 0; i < names; i++) {
            if (gender == Names.FEMALE)
                name += mFemaleNames[random.nextInt(mFemaleNames.length)] + " ";
            else
                name += mMaleNames[random.nextInt(mMaleNames.length)] + " ";
        }

        name += mSurnames[random.nextInt(mSurnames.length)];

        return name;
    }
}
