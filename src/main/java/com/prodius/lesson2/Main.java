package com.prodius.lesson2;

import com.prodius.lesson2.util.StringUtil;

public class Main {
    public static void main(String[] args) {
       final StringUtil stringUtil = new StringUtil();
       final int line = StringUtil.getUserString();
       final String newLine = stringUtil.getRandomString(line);
       final char[] addChar = stringUtil.addCharacters(newLine);
       final String changeCharacters = stringUtil.changeCharacters(String.valueOf(addChar));
       final int stringLength =  stringUtil.stringCheck(changeCharacters);
    }
}
