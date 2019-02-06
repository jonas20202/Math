package math.general.TermElements;

public class TermNumber extends TermElement {
    private double number;

    TermNumber(String termEl)
    {
        super(termEl);
        number = Double.parseDouble(termEl);
    }

    double getNumber() { return number; }

    @Override
    TermElementType getType() {
        return TermElementType.TERM_ELEMENT_NUMBER;
    }
}
