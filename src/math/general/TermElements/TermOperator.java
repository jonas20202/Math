package math.general.TermElements;

public class TermOperator extends TermElement {
    private TermOperatorType operatorType;

    TermOperator(String operator){
        switch (operator) {
            case "+":
                operatorType = TermOperatorType.TERM_OPERATOR_TYPE_PLUS;
                break;
            case "-":
                operatorType = TermOperatorType.TERM_OPERATOR_TYPE_MINUS;
                break;
            case "*":
                operatorType = TermOperatorType.TERM_OPERATOR_TYPE_MULTIPLICATION;
                break;
            case "/":
                operatorType = TermOperatorType.TERM_OPERATOR_TYPE_DIVISION;
                break;
            case "sin":
                operatorType = TermOperatorType.TERM_OPERATOR_TYPE_SIN;
                break;
            case "cos":
                operatorType = TermOperatorType.TERM_OPERATOR_TYPE_COS;
                break;
            case "tan":
                operatorType = TermOperatorType.TERM_OPERATOR_TYPE_TAN;
                break;
            case "log":
                operatorType = TermOperatorType.TERM_OPERATOR_TYPE_LOG;
                break;
            case "^":
                operatorType = TermOperatorType.TERM_OPERATOR_TYPE_POWER;
                break;
        }
    }

    @Override
    public TermElementType getType() {
        return TermElementType.TERM_ELEMENT_OPERATOR;
    }

    @Override
    public String toString() {
        switch (operatorType) {
            case TERM_OPERATOR_TYPE_PLUS:
                return " + ";
            case TERM_OPERATOR_TYPE_MINUS:
                return " - ";
            case TERM_OPERATOR_TYPE_MULTIPLICATION:
                return " * ";
            case TERM_OPERATOR_TYPE_DIVISION:
                return " / ";
            case TERM_OPERATOR_TYPE_SIN:
                return " sin ";
            case TERM_OPERATOR_TYPE_COS:
                return " cos ";
            case TERM_OPERATOR_TYPE_TAN:
                return " tan ";
            case TERM_OPERATOR_TYPE_LOG:
                return " log ";
            case TERM_OPERATOR_TYPE_POWER:
                return " ^ ";
        }
        return "OPERATOR ERROR";
    }

    public TermOperatorType getOperatorType() {
        return operatorType;
    }
}
