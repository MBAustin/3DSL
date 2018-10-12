package ast;

import libs.Node;

public  abstract class STATEMENT extends Node {
    public static STATEMENT getSubStatement(){
        if (tokenizer.checkToken("set")) {
            return new SET();
        }
        if (tokenizer.checkToken("get")){
            return new USE();
        }
        if (tokenizer.checkToken("new")){
            return new DEC();
        }
        if (tokenizer.checkToken("print")){
            return new PRINT();
        }
        if (tokenizer.checkToken("times")){
            return new TIMES();
        }
        if (tokenizer.checkToken("def")){
            //the fact that we're including this might be a problem
            //as we evolve our language -- eventually we may want to put procedure definitions
            //in another category
            return new PROCDEC();
        }
        if (tokenizer.checkToken("call")){
            return new PROCCALL();
        }
        else return null;
    }
}
