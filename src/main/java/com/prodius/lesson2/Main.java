package com.prodius.lesson2;

import com.prodius.lesson2.util.StringUtil;

public class Main {
    public static void main(String[] args) {
       final StringUtil stringUtil = new StringUtil();
       final int line = StringUtil.getUserString();
       final String newLine = stringUtil.getRandomString(line);
       final String changeCharacters = stringUtil.changeCharacters(newLine);
       final int stringLength =  stringUtil.stringCheck(changeCharacters);
    }
}
