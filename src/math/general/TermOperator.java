package math.general;

public class TermOperator extends TermElement {
    private char operator;

    TermOperator(char operator){
        super(new String() + operator);
        this.operator = operator;
    }

    @Override
    TermElementType getType() {
        return TermElementType.TERM_ELEMENT_OPERATOR;
    }
}
