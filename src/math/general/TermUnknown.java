package math.general;

public class TermUnknown extends TermElement{

    TermUnknown(String unknown){
        super(unknown);
    }

    @Override
    TermElementType getType() {
        return TermElementType.TERM_ELEMENT_UNKNOWN;
    }
}
