package math.general.TermElements;

import math.general.Function;

public class TermFunction extends TermElement {
    private String operator;
    private Function function;

    TermFunction(String term, String functionDepend, String operator){
        super(term);
        this.operator = operator;
        function = new Function(term, functionDepend);
    }

    @Override
    TermElementType getType() {
        return TermElementType.TERM_ELEMENT_FUNCTION;
    }

    public boolean hasUnknown(){
        for(int i = 0; i < function.getTermElements().size(); i++){
            TermElement curEl = function.getTermElements().get(i);
            if(curEl.getType() == TermElementType.TERM_ELEMENT_UNKNOWN && curEl.getTermString().equals(function.getFunktionDepend()))
                return true;
        }
        return false;
    }

    public String getOperator() {
        return operator;
    }
}
