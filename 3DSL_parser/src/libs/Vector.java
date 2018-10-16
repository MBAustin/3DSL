package libs;

import java.util.Arrays;

public class Vector {
    public float a,b,c;
    public Vector(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static Boolean isVector(String str) {
        return str.substring(0,1).equals("(");
    }

    public static Vector fromString(String str) {
        String[] numbers = str.split("[(,)]");
        if (numbers.length != 4) {
            System.out.println("FAILED: Got wrong amount of numbers in vector: " + str + ";  " + Arrays.toString(numbers));
            System.exit(0);
        }
        System.out.println("got vector " + str + " as " + Arrays.toString(numbers));
        return new Vector(Float.parseFloat(numbers[1]), Float.parseFloat(numbers[2]), Float.parseFloat(numbers[3]));
    }
}
