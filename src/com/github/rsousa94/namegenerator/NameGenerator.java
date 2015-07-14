package com.github.rsousa94.namegenerator;



import com.github.rsousa94.namegenerator.utils.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class NameGenerator {

    public static final int ARABIC = 0;
    public static final int CHINESE = 1;
    public static final int DUTCH = 2;
    public static final int ENGLISH = 3;
    public static final int FRENCH = 4;
    public static final int GERMAN = 5;
    public static final int HINDI = 6;
    public static final int ITALIAN = 7;
    public static final int JAPANESE = 8;
    public static final int KOREAN = 9;
    public static final int PORTUGUESE = 10;
    public static final int RUSSIAN = 11;
    public static final int SPANISH = 12;

    private int mLanguage;
    private boolean mWesternized;
    private String[] mFemaleNames;
    private String[] mMaleNames;
    private String[] mSurnames;
    private Names mNames;

    public static final String LanguageError = "Invalid language. Choose one from the following:\n" +
            "NameGenerator.ARABIC\nNameGenerator.CHINESE\nNameGenerator.DUTCH\nNameGenerator.ENGLISH\n" +
            "NameGenerator.FRENCH\nNameGenerator.GERMAN\nNameGenerator.HINDI\nNameGenerator.ITALIAN\n" +
            "NameGenerator.JAPANESE\nNameGenerator.KOREAN\nNameGenerator.PORTUGUESE\nNameGenerator.RUSSIAN\n" +
            "NameGenerator.SPANISH";

    public static final String NamesError = "Names and surnames must be greater or equal to 1";
    public static final String GenderError = "Invalid gender. Choose Names.FEMALE or Names.MALE";

    /**
     * Starts a new NameGenerator instance with a certain language and westernization enabled or disabled
     *
     * @param language the language of the names
     * @param western  enable or disable westernized form of names
     */
    public NameGenerator(int language, boolean western) {
        mLanguage = language;
        mWesternized = western;
        setLanguage(mLanguage);
    }

    /**
     * Starts a new NameGenerator instance with a certain language and westernization enabled
     *
     * @param language the language of the names
     */
    public NameGenerator(int language) {
        mLanguage = language;
        mWesternized = true;
        setLanguage(mLanguage);
    }

    /**
     * Get the current selected language of names for this NameGenerator instance
     *
     * @return current language of names
     */
    public int getLanguage() {
        return mLanguage;
    }

    /**
     * Sets the current selected language of names for this NameGenerator instance
     *
     * @param language the language to be set
     * @return true if language was changed successfully, false otherwise
     * @throws IOException if it can't read the names
     */
    public boolean setLanguage(int language) {
        if (language < ARABIC || language > SPANISH)
            throw new IllegalArgumentException(LanguageError);

        try {
            switch (language) {
                case ARABIC:
                    mNames = new ArabicNames();
                    mFemaleNames = ((ArabicNames) mNames).mFemaleNames;
                    mMaleNames = ((ArabicNames) mNames).mMaleNames;
                    mSurnames = ((ArabicNames) mNames).mSurnames;
                    break;
                case CHINESE:
                    mNames = new ChineseNames();
                    mFemaleNames = ((ChineseNames) mNames).mFemaleNames;
                    mMaleNames = ((ChineseNames) mNames).mMaleNames;
                    mSurnames = ((ChineseNames) mNames).mSurnames;
                    break;
                case DUTCH:
                    mNames = new DutchNames();
                    mFemaleNames = ((DutchNames) mNames).mFemaleNames;
                    mMaleNames = ((DutchNames) mNames).mMaleNames;
                    mSurnames = ((DutchNames) mNames).mSurnames;
                    break;
                case ENGLISH:
                    mNames = new EnglishNames();
                    mFemaleNames = ((EnglishNames) mNames).mFemaleNames;
                    mMaleNames = ((EnglishNames) mNames).mMaleNames;
                    mSurnames = ((EnglishNames) mNames).mSurnames;
                    break;
                case FRENCH:
                    mNames = new FrenchNames();
                    mFemaleNames = ((FrenchNames) mNames).mFemaleNames;
                    mMaleNames = ((FrenchNames) mNames).mMaleNames;
                    mSurnames = ((FrenchNames) mNames).mSurnames;
                    break;
                case GERMAN:
                    mNames = new GermanNames();
                    mFemaleNames = ((GermanNames) mNames).mFemaleNames;
                    mMaleNames = ((GermanNames) mNames).mMaleNames;
                    mSurnames = ((GermanNames) mNames).mSurnames;
                    break;
                case HINDI:
                    mNames = new HindiNames();
                    mFemaleNames = ((HindiNames) mNames).mFemaleNames;
                    mMaleNames = ((HindiNames) mNames).mMaleNames;
                    mSurnames = ((HindiNames) mNames).mSurnames;
                    break;
                case ITALIAN:
                    mNames = new ItalianNames();
                    mFemaleNames = ((ItalianNames) mNames).mFemaleNames;
                    mMaleNames = ((ItalianNames) mNames).mMaleNames;
                    mSurnames = ((ItalianNames) mNames).mSurnames;
                    break;
                case JAPANESE:
                    mNames = new JapaneseNames(mWesternized);
                    mFemaleNames = ((JapaneseNames) mNames).mFemaleNames;
                    mMaleNames = ((JapaneseNames) mNames).mMaleNames;
                    mSurnames = ((JapaneseNames) mNames).mSurnames;
                    break;
                case KOREAN:
                    mNames = new KoreanNames(mWesternized);
                    mFemaleNames = ((KoreanNames) mNames).mFemaleNames;
                    mMaleNames = ((KoreanNames) mNames).mMaleNames;
                    mSurnames = ((KoreanNames) mNames).mSurnames;
                    break;
                case PORTUGUESE:
                    mNames = new PortugueseNames();
                    mFemaleNames = ((PortugueseNames) mNames).mFemaleNames;
                    mMaleNames = ((PortugueseNames) mNames).mMaleNames;
                    mSurnames = ((PortugueseNames) mNames).mSurnames;
                    break;
                case RUSSIAN:
                    mNames = new RussianNames();
                    mFemaleNames = ((RussianNames) mNames).mFemaleNames;
                    mMaleNames = ((RussianNames) mNames).mMaleNames;
                    mSurnames = ((RussianNames) mNames).mSurnames;
                    break;
                case SPANISH:
                    mNames = new SpanishNames();
                    mFemaleNames = ((SpanishNames) mNames).mFemaleNames;
                    mMaleNames = ((SpanishNames) mNames).mMaleNames;
                    mSurnames = ((SpanishNames) mNames).mSurnames;
                    break;
                default:
                    return false;
            }
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    /**
     * Generates a random name
     *
     * @return A random name for the current selected language
     */
    public String nextName() {
        return mNames.nextName();
    }

    /**
     * Generates a random name for a certain gender
     *
     * @param gender   name gender
     * @return A random name for the current selected language and for a given gender
     */
    public String nextName(int gender) {
        if (gender != Names.FEMALE && gender != Names.MALE)
            throw new IllegalArgumentException(GenderError);

        return mNames.nextName(gender);
    }

    /**
     * Generates a random name for a certain gender with a certain number of names and surnames
     *
     * @param gender   name gender
     * @param names    number of given names
     * @param surnames number of surnames
     * @return A random name for a given gender, with a certain number of names and surnames
     */
    public String nextName(int gender, int names, int surnames) {
        if (names <= 0 || surnames <= 0)
            throw new IllegalArgumentException(NamesError);

        if (gender != Names.FEMALE && gender != Names.MALE)
            throw new IllegalArgumentException(GenderError);

        Random random = new Random();
        String name = "";

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

    /**
     * Returns a random name for a certain gender and with specified surnames
     *
     * @param gender   name gender
     * @param names    number of given names
     * @param surnames number of surnames
     * @return A random name for a given gender, with a certain number of names and a set of defined surnames
     */
    public String nextName(int gender, int names, String[] surnames) {
        if (names <= 0 || surnames == null || surnames.length == 0)
            throw new IllegalArgumentException(NamesError);

        if (gender != Names.FEMALE && gender != Names.MALE)
            throw new IllegalArgumentException(GenderError);

        Random random = new Random();
        String name = "";

        for (int i = 0; i < names; i++) {
            if (gender == Names.FEMALE)
                name += mFemaleNames[random.nextInt(mFemaleNames.length)] + " ";
            else
                name += mMaleNames[random.nextInt(mMaleNames.length)] + " ";
        }

        ArrayList<Integer> positions = new ArrayList<>();

        for (int i = 0; i < surnames.length; i++) {
            int pos = random.nextInt(surnames.length);

            while(positions.contains(pos))
                pos = random.nextInt(surnames.length);

            String surname = surnames[pos];
            positions.add(pos);

            if (i != surnames.length-1)
                name += surname + " ";
            else
                name += surname;
        }

        return name;
    }

}
