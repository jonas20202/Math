package math.general;

import math.general.TermElements.Term;
import math.general.TermElements.TermElement;

import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args){
        Term term = new Term("3+3*7*9");
        System.out.println(term.toString());
    }
}
