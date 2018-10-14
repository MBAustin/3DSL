package ast;

import libs.Node;
import ui.Main;

public  abstract class STATEMENT extends Node {
    public static STATEMENT getSubStatement(){
        if (tokenizer.checkToken("#")){
            return new COMMENT();
        }
        if (tokenizer.checkToken("store")){
            return new DEC();
        }
        if (tokenizer.checkToken("make")){
            return new MAKE();
        }
        if (tokenizer.checkToken("move")){
            return new MOVE();
        }
        if (tokenizer.checkToken("rotate")){
            return new ROTATE();
        }
        if (tokenizer.checkToken("scale")){
            return new SCALE();
        }
        if (tokenizer.checkToken("set")){
            return new SET();
        }
        if (tokenizer.checkToken("attach")){
            return new ATTACH();
        }
        if (tokenizer.checkToken("cut")){
            return new CUT();
        }
        if (tokenizer.checkToken("group")){
            return new GROUP();
        }
        if (tokenizer.checkToken("for")){ //TODO: Is this right?
            return new FOREACH();
        }
        if (tokenizer.checkToken("function")){
            return new PROCDEC();
        }
        if (tokenizer.checkToken("call")){
            return new PROCCALL();
        }
        if (tokenizer.checkToken("clone")){
            return new CLONE();
        }



        // TODO If we want to allow comments on lines of code we code parse statements to their last keyword. Not the NEWLINE token
        // EG) rotate MyCone by (45,0,0) # rotating my cone
        // And then in here parse for # and it will find the comment and pass it. But we would need it to handle finding
        // NEWLINE and TAB characters and ignore them here as well.
        if (tokenizer.checkToken(Main.NEWLINE)){
            return new HANDLENEWLINEANDTABS();
        }
        if (tokenizer.checkToken(Main.TAB)){
            return new HANDLENEWLINEANDTABS();
        }
        else return null;
    }
}
