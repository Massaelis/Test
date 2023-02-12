package com.prodius.lesson1.array;

import com.prodius.lesson1.array.service.StringService;
import com.prodius.lesson1.array.util.StringInputUtil;

public class Main {
    public static void main(String[] args) {
        final String line = StringInputUtil.getString(3);

        final StringService stringService = new StringService();
        stringService.duplicateCharacters(line);
    }
}
