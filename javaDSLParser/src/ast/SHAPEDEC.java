package ast;


import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;


public class SHAPEDEC extends STATEMENT {
    List<String> polyShapes = Arrays.asList("Sphere", "Cube");
    String shape;
    String name;

    @Override
    public void parse() {
        // "make me a"
        tokenizer.getAndCheckNext( "make me a");
        // some shape string
        shape = tokenizer.getNext().trim(); //TODO: remove need for trim
        // "called"
        tokenizer.getAndCheckNext("called");
        // some name string
        name = tokenizer.getNext().trim(); //TODO: remove need for trim
    }

    @Override
    public void evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        if (polyShapes.contains(shape)) {
            writer.println("cmds.poly" + shape + "(name='" + name + "')");
        }
        else {
            writer.println("cmds.shadingNode('blinn', name='" + name + "', asShader=True)");
        }
    }
}
