package math.general;

public abstract class TermElement {
    private String termEl;

    TermElement(String termEl){
        this.termEl = termEl;
    }

    public abstract TermElementType getType();
    public String getTermString() { return termEl;}
}
