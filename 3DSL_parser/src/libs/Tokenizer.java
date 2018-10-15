package libs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import ui.Main;

public class Tokenizer {


    private static String program;
    private String[] tokens;
    private int currentToken;
    private static Tokenizer theTokenizer;

    private Tokenizer(String filename){
        try {
            program = new String(Files.readAllBytes(Paths.get(filename)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Didn't find file");
            System.exit(0);
        }
        tokenize();
    }

    private void tokenize (){
        String tokenizedProgram = program;
        tokenizedProgram = tokenizedProgram.replace("    ", "\t");
        tokenizedProgram = tokenizedProgram.replace("\t","\t ");
        tokenizedProgram = tokenizedProgram.replace("\n"," %newLine% ");

        tokens = tokenizedProgram.split("[ ]+");

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("%newLine%")) {
                tokens[i] = Main.NEWLINE;
            } else if (tokens[i].equals("\t")) {
                tokens[i] = Main.TAB;
            } else {
                // Do nothing
            }
        }

        System.out.println(Arrays.asList(tokens));


//        tokenizedProgram = tokenizedProgram.replace("\n","");
//        tokenizedProgram = tokenizedProgram.replaceAll("([0-9]+)","_$1_");
//        System.out.println(program);
//
//        for (String s : literals){
////            tokenizedProgram = tokenizedProgram.replaceAll(s,"_"+s+"_");
//            tokenizedProgram = tokenizedProgram.replace(s,"_"+s+"_");
//            System.out.println(tokenizedProgram);
//        }
////        tokenizedProgram = tokenizedProgram.replaceAll("__","_");
//        tokenizedProgram = tokenizedProgram.replaceAll("[ ]+","");
//        System.out.println(tokenizedProgram);
//        String [] temparray=tokenizedProgram.split("[_]+");
//        tokens = new String[temparray.length-1];
//
//        System.arraycopy(temparray,1,tokens,0,temparray.length-1);

    }

    private String checkNext(){
        String token="";
        if (currentToken<tokens.length){
            token = tokens[currentToken];
        }
        else
            token="NO_MORE_TOKENS";
        return token;
    }

    public String getNext(){
        String token="";
        if (currentToken<tokens.length){
            token = tokens[currentToken];
            currentToken++;
        }
        else
            token="NULLTOKEN";
        return token;
    }


    public boolean checkToken(String regexp){
        String s = checkNext();
        System.out.println("comparing: |"+s+"|  to  |"+regexp+"|");
        return (s.matches(regexp));
    }


    public String getAndCheckNext(String regexp){
        String s = getNext();
        if (!s.matches(regexp)) {
            System.out.println("FAILED!!!! when comparing " + s + " to " + regexp);
            System.exit(0);
        }
        System.out.println("matched: "+s+"  to  "+regexp);
        return s;
    }

    public Vector getVector() {
        String vector = getNext();
        String[] numbers = vector.split("[(,)]");
        if (numbers.length != 4) {
            System.out.println("FAILED: Got wrong amount of numbers in vector: " + vector + ";  " + Arrays.toString(numbers));
            System.exit(0);
        }
        System.out.println("got vector " + vector + " as " + Arrays.toString(numbers));
        return new Vector(Float.parseFloat(numbers[1]), Float.parseFloat(numbers[2]), Float.parseFloat(numbers[3]));
    }

    public boolean moreTokens(){
        return currentToken<tokens.length;
    }

    public static void makeTokenizer(String filename){
        if (theTokenizer==null){
            theTokenizer = new Tokenizer(filename);
        }
    }

    public static Tokenizer getTokenizer(){
        return theTokenizer;
    }

}
