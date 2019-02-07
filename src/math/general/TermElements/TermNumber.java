package math.general.TermElements;

public class TermNumber extends TermElement {
    private double number;

    public TermNumber(String termEl)
    {
        number = Double.parseDouble(termEl);
    }

    public double getNumber() { return number; }

    @Override
    public TermElementType getType() {
        return TermElementType.TERM_ELEMENT_NUMBER;
    }

    @Override
    public String toString(){
        return String.valueOf(number);
    }
}
