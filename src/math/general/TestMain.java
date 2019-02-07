package math.general;

import math.general.TermElements.Term;
import math.general.TermElements.TermElement;

import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args){
        Term term = new Term("2*4+3*2+5*5*2");
        System.out.println(term.toString());
        term.calc();
        System.out.println(term.toString());
    }
}
