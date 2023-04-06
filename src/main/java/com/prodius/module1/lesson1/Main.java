package com.prodius.module1.lesson1;

import com.prodius.module1.lesson1.service.StringService;
import com.prodius.module1.lesson1.util.StringInputUtil;

public class Main {
    public static void main(String[] args) {
        final String line = StringInputUtil.getString(3);

        final StringService stringService = new StringService();
        stringService.duplicateCharacters(line);
    }
}
