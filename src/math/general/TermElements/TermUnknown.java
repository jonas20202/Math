package math.general.TermElements;

public class TermUnknown extends TermElement{

    TermUnknown(String unknown){
        super(unknown);
    }

    @Override
    TermElementType getType() {
        return TermElementType.TERM_ELEMENT_UNKNOWN;
    }
}
