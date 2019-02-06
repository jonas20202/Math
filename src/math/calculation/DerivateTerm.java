package math.calculation;

import math.general.Function;
import math.general.TermElements.TermElement;
import math.general.TermElements.TermElementType;
import math.general.TermElements.TermFunction;

import java.util.ArrayList;

public class DerivateTerm {
    public static Function createDerivation(Function function){
        ArrayList<TermElement> functionElements = function.getTermElements();

        //TODO Term nach plus und minus in einzelne Bestandteile aufteilen
        //TODO Produktregel auf die einzelnen Elemente anwenden
        return null;
    }

    private static ArrayList<TermElement> derivateSubTerm(ArrayList<TermElement> subElements, String functionDepend){
        ArrayList<TermElement> productRule = new ArrayList<>();
        for(int i = 0; i < subElements.size(); i++){
            TermElement curEl = subElements.get(i);
            if(curEl.getType() == TermElementType.TERM_ELEMENT_UNKNOWN && curEl.getTermString().equals(functionDepend)){
                productRule.add(curEl);
            }else if(curEl.getType() == TermElementType.TERM_ELEMENT_FUNCTION && ){
                TermFunction tFunc = (TermFunction)curEl;
                if(((TermFunction) curEl).hasUnknown())
                    productRule.add(curEl);
            }
        }


    }
}
