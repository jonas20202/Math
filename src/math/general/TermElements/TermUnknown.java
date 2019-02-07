package math.general.TermElements;

public class TermUnknown extends TermElement{
    private String unknown;
    public TermUnknown(String unknown){

    }

    @Override
    public TermElementType getType() {
        return TermElementType.TERM_ELEMENT_UNKNOWN;
    }
}
