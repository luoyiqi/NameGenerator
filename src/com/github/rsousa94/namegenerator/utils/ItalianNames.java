package com.github.rsousa94.namegenerator.utils;


import java.io.IOException;
import java.util.Random;

public class ItalianNames extends Names {

    public static final String SURNAMES_FILENAME = "italian_surnames.txt";
    public static final String MALE_NAMES_FILENAME = "italian_male.txt";
    public static final String FEMALE_NAMES_FILENAME = "italian_female.txt";


    public String[] mMaleNames;
    public String[] mFemaleNames;
    public String[] mSurnames;

    public ItalianNames() throws IOException {
        mSurnames = readNames(SURNAMES_FILENAME);
        mMaleNames = readNames(MALE_NAMES_FILENAME);
        mFemaleNames = readNames(FEMALE_NAMES_FILENAME);
    }

    /**
     * Generates a random name for a given gender
     *
     * @param gender the gender of the name
     * @return A random Italian name for a certain gender including a given name and a surname
     */
    @Override
    public String nextName(int gender) {
        Random random = new Random();
        String name = "";
        int names = random.nextInt(4) + 1;

        for (int i = 0; i < names; i++) {
            if (gender == Names.FEMALE)
                name += mFemaleNames[random.nextInt(mFemaleNames.length)] + " ";
            else
                name += mMaleNames[random.nextInt(mMaleNames.length)] + " ";
        }

        name += mSurnames[random.nextInt(mSurnames.length)];

        return name;
    }

    /**
     * Generates a random name with a given surname
     *
     * @param surname Surname to be given
     * @return A random japanese name including a first name and a surname
     */
    public String nextName(String surname) {
        Random random = new Random();
        int gender = random.nextInt(2);

        if (gender == Names.FEMALE)
            return mFemaleNames[random.nextInt(mFemaleNames.length)] + " " + surname;
        else
            return mMaleNames[random.nextInt(mMaleNames.length)] + " " + surname;
    }

    /**
     * Generates a random name with a given surname and for a certain gender
     *
     * @param surname Surname to be given
     * @param gender  name gender
     * @return A random female or male name including a first name and a surname
     */
    public String nextName(String surname, int gender) {
        Random random = new Random();

        if (gender == Names.FEMALE)
            return mFemaleNames[random.nextInt(mFemaleNames.length)] + " " + surname;
        else
            return mMaleNames[random.nextInt(mMaleNames.length)] + " " + surname;
    }

}
