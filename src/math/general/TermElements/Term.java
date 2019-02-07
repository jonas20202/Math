package math.general.TermElements;

import math.general.HelperClass;

import java.util.ArrayList;

public class Term extends TermElement{
    //Attributes
    private ArrayList<TermElement> termElements = new ArrayList<>();

    //Constructor
    public Term (String term){
        createTermElements(term);
    }

    //Constructor
    public Term (ArrayList<TermElement> termElements){
        this.termElements = termElements;
    }

    //Public Methods
    @Override
    public TermElementType getType() {
        return TermElementType.TERM_ELEMENT_TERM;
    }

    @Override
    public String toString(){
        String ret = "(";
        for(TermElement el : termElements){
            ret += el.toString();
        }
        return ret + ")";
    }

    public double calc(){
        calcTerm();
        return ((TermNumber)termElements.get(0)).getNumber();
    }

    public boolean hasUnknown(){
        for(TermElement curEl : termElements){
            if(curEl.getType() == TermElementType.TERM_ELEMENT_UNKNOWN)
                return true;

            if(curEl.getType() == TermElementType.TERM_ELEMENT_TERM){
                Term curTerm = (Term)curEl;
                if(curTerm.hasUnknown())
                    return true;
            }
        }
        return false;
    }

    //Private Methods
    private void createTermElements(String term){
        int termLen = term. length();
        String curString = "";

        for(int i = 0; i < termLen; i++){
            char cur = term.charAt(i);
            curString = "" + cur;

            //if the current char is a Number search the complete Number
            if(HelperClass.isNumber(curString)){
                for(int a = ++i; a < termLen; a++, i++){
                    cur = term.charAt(a);
                    if(cur == '.' || cur == ','){
                        i++; a++;
                        curString += ".";
                        cur = term.charAt(a);
                    }
                    if(HelperClass.isNumber(curString + cur)){
                        curString += cur;
                    }else
                        break;
                }
                //Create the Number
                termElements.add(new TermNumber(curString));

                //If the end of the String is alreade reached
                if(i >= termLen)
                    break;
            }

            curString = "" + cur;

            //If the current char is an simple Operator(+,-,/,*)
            if(HelperClass.isSimpleOperator(cur)){
                //create the TermOperator
                termElements.add(new TermOperator(curString));
                continue;
            }

            //If the current char is a '(', the ')' will be found and the term between created
            else if(cur == '(') {
                //Finds the closing Bracket
                int closeBracket = HelperClass.findClosingOperator(term, i);
                if(closeBracket == -1)
                    return; //TODO Error

                //Creates the term between the Brackets
                termElements.add(new Term(term.substring(i+1, closeBracket)));
                i = closeBracket;
                continue;
            }

            //If the cur Element is one of the other Operators(sin, cos, tan, log)
            else if(termLen - i >= 6) {
                String strOperatorStr = "" + cur + term.charAt(i+1) + term.charAt(i+2);
                if(strOperatorStr.equals("sin") || strOperatorStr.equals("cos") || strOperatorStr.equals("tan")){
                    int closeBracket = HelperClass.findClosingOperator(term, i+3);
                    if(closeBracket == -1)
                        return; //TODO Error

                    //Creates the Operator
                    termElements.add( new TermOperator(strOperatorStr));

                    //Creates the term between the Brackets
                    termElements.add(new Term(term.substring(i+4, closeBracket)));
                    i = closeBracket;
                    continue;
                }

            }
            //Creates the Unknown like x,y,z
            termElements.add(new TermUnknown(curString));
        }

        //Iterate over all termElements to shorter them
        ArrayList<TermElement> combineElements = new ArrayList<>();
        int startIndex = 0;
        for(int i = 0; i < termElements.size(); i++){
            TermElement curEl = termElements.get(i);
            if(curEl.getType() == TermElementType.TERM_ELEMENT_OPERATOR &&
                    (((TermOperator)curEl).getOperatorType() == TermOperatorType.TERM_OPERATOR_TYPE_MULTIPLICATION ||
                            ((TermOperator)curEl).getOperatorType() == TermOperatorType.TERM_OPERATOR_TYPE_DIVISION )) {
                if(combineElements.size() == 0) {
                    startIndex = i -1;
                    combineElements.add(termElements.get(startIndex));
                    termElements.remove(termElements.get(startIndex));
                    i--;
                }
                combineElements.add(curEl);
                termElements.remove(curEl);
                combineElements.add(termElements.get(startIndex));

                if(termElements.get(startIndex).getType() == TermElementType.TERM_ELEMENT_OPERATOR){
                    combineElements.add(termElements.get(startIndex+1));
                    termElements.remove(termElements.get(startIndex+1));
                }
                termElements.remove(termElements.get(startIndex));
                i--;
            }else if (combineElements.size() > 0){
                termElements.add(startIndex, new Term(new ArrayList<TermElement>(combineElements)));
                combineElements.clear();
            }
        }
        if (combineElements.size() > 0) {
            termElements.add(startIndex, new Term(new ArrayList<TermElement>(combineElements)));
            combineElements.clear();
        }
    }

    private void cancelTerm(){

    }


    private void calcTerm(){
        for(int i = 0; i < termElements.size(); i++){
            TermElement curEl = termElements.get(i);
            if(curEl.getType() == TermElementType.TERM_ELEMENT_OPERATOR){
                TermOperator curOperator = (TermOperator) curEl;

                if(curOperator.getOperatorType() == TermOperatorType.TERM_OPERATOR_TYPE_PLUS ||
                curOperator.getOperatorType() == TermOperatorType.TERM_OPERATOR_TYPE_MINUS ||
                curOperator.getOperatorType() == TermOperatorType.TERM_OPERATOR_TYPE_MULTIPLICATION ||
                curOperator.getOperatorType() == TermOperatorType.TERM_OPERATOR_TYPE_DIVISION) {

                    TermElement prevEl = termElements.get(i - 1);
                    TermElement nextEl = termElements.get(i + 1);

                    if (prevEl.getType() == TermElementType.TERM_ELEMENT_TERM){
                        Term prevTerm = (Term)prevEl;
                        prevEl = new TermNumber(Double.toString(prevTerm.calc()));
                    }
                    if (nextEl.getType() == TermElementType.TERM_ELEMENT_TERM){
                        Term nextTerm = (Term)nextEl;
                        nextEl = new TermNumber(Double.toString(nextTerm.calc()));
                    }

                    TermNumber erg = HelperClass.calc((TermNumber) prevEl, curOperator,(TermNumber) nextEl);
                    termElements.remove(i-1);
                    termElements.remove(i-1);
                    termElements.remove(i-1);
                    termElements.add(i-1, erg);
                    i--;
                }
            }

        }
    }
}
