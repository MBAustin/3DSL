package libs;

import java.util.Arrays;

public class Vector {
    public String a,b,c;
    public String variable;
    public Vector(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    

    public Vector(String variable) {
        this.variable = variable;
    }

    public static Boolean isVector(String str) {
        return str.substring(0,1).equals("(");
    }

    private static String parseVal(String val) {
        if (val.contains("~")) {
            String lowVal = val.split("~")[0].substring(6);
            String highVal = val.split("~")[1];
            return "random.uniform("+lowVal+", "+highVal+")";
        }
        else {
            return val;
        }

    }

    public static Vector fromString(String str) {
        String[] numbers = str.split("[(,)]");
        if (numbers.length != 4) {
            if (numbers.length == 1) {
                return new Vector(str);
            }
            System.out.println("FAILED: Got wrong amount of numbers in vector: " + str + ";  " + Arrays.toString(numbers));
            System.exit(0);
        }
        System.out.println("got vector " + str + " as " + Arrays.toString(numbers));



        return new Vector(parseVal(numbers[1]), parseVal(numbers[2]), parseVal(numbers[3]));
    }

    public  String toString() {
        return "(" + this.a + ", " + this.b + ", " + this.c + ")";
    }
}
