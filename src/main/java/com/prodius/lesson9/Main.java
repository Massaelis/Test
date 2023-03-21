package com.prodius.lesson9;

public class Main {
    public static void main(String[] args) {
//        parse();
//        compare();
//        booleanExamples();

        final MyOptional<String> strOptional = MyOptional.ofNullable("test");
        final String strValue = strOptional.get();

        final MyOptional<Integer> intOptional = MyOptional.ofNullable(123);
        final Integer intValue = intOptional.get();

        final ParamMethod paramMethod = new ParamMethod();
        final String s1 = paramMethod.toString(strOptional);
        final String s2 = paramMethod.toString(intOptional);

        final String s11 = ParamMethod.toString2(strOptional);
        final String s22 = ParamMethod.toString2(intOptional);

    }

    private static void arrayExample() {
        Integer[] numbers = new Integer[]{1, 2};
//        int[] ints = numbers ERROR

        int[] ints = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            ints[i] = numbers[i];
        }

    }

    private static void parse() {
        System.out.println(Integer.parseInt("2"));
        System.out.println(Double.parseDouble("2"));
        System.out.println(Boolean.parseBoolean("true"));
    }

    private static void compare() {
        double a = 0.1;
        double b = 0.2;
        double c = a + b;
        double d = 0.3;

        System.out.println(c);
        System.out.println(d);
        System.out.println(c == d);
        System.out.println(Double.compare(c, d));
    }

    private static void booleanExamples() {
        Boolean input1 = true;
        Boolean input2 = false;
        Boolean input3 = null;
//        boolean input4 = null; ERROR
        if (Boolean.TRUE.equals(input1)) {
            System.out.println("input1 is true");
        }
        if (Boolean.FALSE.equals(input2)) {
            System.out.println("input2 is false");
        }
        if (Boolean.TRUE.equals(input3)) {
            System.out.println("input3 is true");
        }
    }
}
