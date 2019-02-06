package math.general.TermElements;

public class TermNumber extends TermElement {
    private double number;

    TermNumber(String termEl)
    {
        number = Double.parseDouble(termEl);
    }

    double getNumber() { return number; }

    @Override
    public TermElementType getType() {
        return TermElementType.TERM_ELEMENT_NUMBER;
    }

    @Override
    public TermElement getDerivation() {
        return null;
    }

    @Override
    public String toString(){
        return String.valueOf(number);
    }
}
