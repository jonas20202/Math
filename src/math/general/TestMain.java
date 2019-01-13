package math.general;

import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args){
        Function f = new Function("x*sin(x+(-7)+-45)", "x");
        ArrayList<TermElement> elements = f.getTermElements();
    }
}
