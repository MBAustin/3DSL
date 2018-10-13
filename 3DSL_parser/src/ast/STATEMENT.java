package ast;

import libs.Node;

public  abstract class STATEMENT extends Node {
    public static STATEMENT getSubStatement(){
        if (tokenizer.checkToken("#")){
            return new COMMENT();
        }
        if (tokenizer.checkToken("store")){
            return new STORE();
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
            return new DEC();
        }
        if (tokenizer.checkToken("call")){
            return new PROCCALL();
        }
        if (tokenizer.checkToken("clone")){
            return new CLONE();
        }
        if (tokenizer.checkToken("call")){
            return new PROCCALL();
        }
        else return null;
    }
}
