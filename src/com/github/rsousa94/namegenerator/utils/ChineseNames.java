package com.github.rsousa94.namegenerator.utils;


import java.io.IOException;
import java.util.Random;


public class ChineseNames extends Names {

    public static final String SURNAMES_FILENAME = "chinese_surnames.txt";
    public static final String MALE_NAMES_FILENAME = "chinese_male.txt";
    public static final String FEMALE_NAMES_FILENAME = "chinese_female.txt";

    public boolean mWesternized;
    public String[] mMaleNames;
    public String[] mFemaleNames;
    public String[] mSurnames;

    public ChineseNames() throws IOException {
        mSurnames = readNames(SURNAMES_FILENAME);
        mMaleNames = readNames(MALE_NAMES_FILENAME);
        mFemaleNames = readNames(FEMALE_NAMES_FILENAME);
    }

    /**
     * Generates a random name for a given gender
     * A Chinese name is usually made from a family name (surname) and a given name.
     *
     * @param gender the gender of the name
     * @return A random Chinese name for a certain gender including a given name and a surname
     */
    @Override
    public String nextName(int gender) {
        Random random = new Random();
        String name = "";

        if (mWesternized) {
            if (gender == Names.FEMALE)
                name += mFemaleNames[random.nextInt(mFemaleNames.length)] + " ";
            else
                name += mMaleNames[random.nextInt(mMaleNames.length)] + " ";

            name += mSurnames[random.nextInt(mSurnames.length)];
        } else {
            name += mSurnames[random.nextInt(mSurnames.length)] + " ";

            if (gender == Names.FEMALE)
                name += mFemaleNames[random.nextInt(mFemaleNames.length)] + " ";
            else
                name += mMaleNames[random.nextInt(mMaleNames.length)] + " ";
        }

        return name;
    }
}
