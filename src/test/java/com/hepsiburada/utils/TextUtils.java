package com.hepsiburada.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtils {

    //Util for extracting number of reviews from string
    public static String getNumberOfReviews(String inputString) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            return matcher.group();
        }else{
            return "";
        }
    }
}
