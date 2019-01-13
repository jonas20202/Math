package math.general;

public class HelperClass {
    public static boolean isNumber(String check){
        int termLen = check.length();
        boolean hasSeperator = false;
        for(int i = 0; i < termLen; i++) {
            char cur = check.charAt(i);
            switch (cur) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    break;
                case '.': {
                    if (i + 1 < termLen && i > 0 && !hasSeperator) {
                        hasSeperator = true;
                        break;
                    } else
                        return false;
                }
                default:
                    return false;
            }
        }
        if(termLen > 0)
            return true;
        else
            return false;
    }

    public static boolean isSimpleOperator(char check){
        switch (check) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
                break;
            default:
                return false;
        }
        return true;
    }

    public static int findClosingOperator(String term, int startOperator){
        int length = term.length();
        int openCount = 0;
        for(int i = startOperator + 1; i < length; i++){
            char cur = term.charAt(i);
            if(cur == '(')
                openCount++;
            else if(cur == ')')
                openCount--;
            if(openCount == -1)
                return i;
        }
        return -1;
    }
}
