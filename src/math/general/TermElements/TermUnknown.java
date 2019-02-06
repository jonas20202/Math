package math.general.TermElements;

public class TermUnknown extends TermElement{

    TermUnknown(String unknown){

    }

    @Override
    public TermElementType getType() {
        return TermElementType.TERM_ELEMENT_UNKNOWN;
    }

    @Override
    public TermElement getDerivation() {
        return null;
    }
}
