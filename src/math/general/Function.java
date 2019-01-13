package math.general;

import math.calculation.DerivateTerm;

import java.util.ArrayList;

public class Function {
    private String funktionTerm;
    private String funktionDepend; //Bei Funtkion f(x) steht hier x
    private ArrayList<TermElement> termElements = new ArrayList<>();

    Function(String funktionTerm, String funktionDepend){
        this.funktionTerm = funktionTerm;
        this.funktionDepend = funktionDepend;
        createTermElements();
    }

    public String getFunktionDepend() { return funktionDepend;}
    public Function getDerivation(){
        return DerivateTerm.createDerivation(this);
    }

    public ArrayList<TermElement> getTermElements() { return termElements; }

    private void createTermElements(){
        int termLen = funktionTerm.length();
        String curCombination = "";
        for(int i = 0; i < termLen; i++){

            char cur = funktionTerm.charAt(i);
            curCombination = "" + cur;

            if(HelperClass.isNumber(curCombination)){
                for(int a = ++i; a < termLen; a++, i++){

                    cur = funktionTerm.charAt(a);
                    if(HelperClass.isNumber(curCombination + cur)){
                        curCombination += cur;
                    }else
                        break;
                }
                termElements.add(new TermNumber(curCombination));
                if(i >= termLen)
                    break;
            }

            if(HelperClass.isSimpleOperator(cur)){
                termElements.add(new TermOperator(cur));
                continue;
            }

            if(cur == '(') {
                int closeEl = HelperClass.findClosingOperator(funktionTerm, i);
                if(closeEl == -1)
                    return; //TODO Error
                termElements.add(new TermFunction(funktionTerm.substring(i+1, closeEl), funktionDepend, "("));
                i = closeEl;
                continue;
            }

            if(termLen - i >= 6) {
                String strOperatorStr = "" + cur + funktionTerm.charAt(i+1) + funktionTerm.charAt(i+2);
                if(strOperatorStr.equals("sin") || strOperatorStr.equals("cos") || strOperatorStr.equals("tan")){
                    int closeEl = HelperClass.findClosingOperator(funktionTerm, i+3);
                    if(closeEl == -1)
                        return; //TODO Error
                    termElements.add(new TermFunction(funktionTerm.substring(i+4, closeEl), funktionDepend, strOperatorStr));
                    i = closeEl;
                    continue;
                }
            }

            termElements.add(new TermUnknown(curCombination));
        }
    }
}
