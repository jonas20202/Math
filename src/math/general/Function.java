package math.general;

import math.general.TermElements.*;

public class Function {
    private Term funktionTerm;
    private TermUnknown funktionDepend;

    Function(String funktionTerm, String funktionDepend){
        this.funktionTerm = new Term(funktionTerm);
        this.funktionDepend = new TermUnknown(funktionDepend);
    }

    public TermUnknown getFunktionDepend() { return funktionDepend;}

}
