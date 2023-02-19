package com.prodius.lesson2;

import com.prodius.lesson2.util.StringUtil;

import java.util.Arrays;

/*
Пользователь вводит число (больше 5). Генерируется случайная строка длинной равной этому числу. Далее каждый четный
символ строки дублируется. Меняется местами первый и последний символ. Высчитывается итоговая длина строки и делиться
на введенное пользователем число. Если остаток от деления равен 0 - тест пройден. Если нет вырезается случайный символ
из строки и тест повторяется
 */
public class Main {
    public static void main(String[] args) {
        final StringUtil stringUtil = new StringUtil();
        final int line = stringUtil.getUserString();
        final String newLine = stringUtil.getRandomString(line);
        final char[] addChar = stringUtil.addCharacters(newLine);
        stringUtil.changeCharacters(addChar);
        stringUtil.stringCheck(Arrays.toString(addChar));
    }
}
