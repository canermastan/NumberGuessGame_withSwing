package com.canermastan.utilities;

import java.util.Random;

public class Utilities {
    public static int generateRandomNumber(int randomNumber){
        Random random = new Random();
        randomNumber = random.nextInt(99) + 1; // [1,99]
        return randomNumber;
    }
}
