package math.general.TermElements;

public abstract class TermElement {

    //Constructor
    TermElement(){

    }

    //Public Methods
    public abstract TermElementType getType();
    public abstract TermElement getDerivation();
}
