package com.hicks.team.utils;

import java.util.Random;

public class StyleUtils {

    private static final Random random = new Random();

    public static String getRandomBackgroundColor() {
        return String.format("background-color: rgba(%d,%d,%d,%.2f)",
                random.nextInt(256), random.nextInt(256), random.nextInt(256), 0.1);
    }

}
