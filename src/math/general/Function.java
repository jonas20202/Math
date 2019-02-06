package math.general;

import math.calculation.DerivateTerm;
import math.general.TermElements.*;

import java.util.ArrayList;

public class Function {
    private String funktionTerm;
    private String funktionDepend; //Bei Funtkion f(x) steht hier x
    private ArrayList<TermElement> termElements = new ArrayList<>();

    Function(String funktionTerm, String funktionDepend){
        this.funktionTerm = funktionTerm;
        this.funktionDepend = funktionDepend;
    }

    public String getFunktionDepend() { return funktionDepend;}
    public Function getDerivation(){
        return DerivateTerm.createDerivation(this);
    }

    public ArrayList<TermElement> getTermElements() { return termElements; }

}
