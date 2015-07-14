package com.github.rsousa94.namegenerator.utils;


import java.io.IOException;
import java.util.Random;


public class ArabicNames extends Names {

    public static final String SURNAMES_FILENAME = "arabic_surnames.txt";
    public static final String MALE_NAMES_FILENAME = "arabic_male.txt";
    public static final String FEMALE_NAMES_FILENAME = "arabic_female.txt";

    public String[] mMaleNames;
    public String[] mFemaleNames;
    public String[] mSurnames;

    public ArabicNames() throws IOException {
        mSurnames = readNames(SURNAMES_FILENAME);
        mMaleNames = readNames(MALE_NAMES_FILENAME);
        mFemaleNames = readNames(FEMALE_NAMES_FILENAME);
    }

    /**
     * Generates a random name for a given gender
     *
     * @param gender the gender of the name
     * @return A random Arabic name for a certain gender
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
