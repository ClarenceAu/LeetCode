package me.zhencong.leetcode;

/**
 * @author <a href="zhencong.ouzc@taobao.com">遣怀</a>
 * @date 14/10/26.
 */
public class ValidNumber {

    private boolean[] states = {false, true, false, false, true, false, true, false};

    private static final int NUM_CHAR = 0;
    private static final int DOT_CHAR = 1;
    private static final int E_CHAR = 2;
    private static final int MINUS_CHAR = 3;

    private static final int DEAD_CHAR = -1;
    private static final int DEAD_STATE = -1;

    private static final int[][] stateTransTable = {
            {1, 2, -1, 3},
            {1, 4, 5, -1},
            {4, -1, -1, -1},
            {1, 2, -1, -1},
            {4, -1, 5, -1},
            {6, -1, -1, 7},
            {6, -1, -1, -1},
            {6, -1, -1, -1}
    };

    public boolean isNumber(String s) {

        s = s.trim();
        char[] chars = s.toCharArray();

        int currentState = 0;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            int charType = getCharType(ch);
            if (charType == DEAD_CHAR) {
                return false;
            }

            int nextState = stateTransTable[currentState][charType];
            if (nextState == DEAD_STATE) {
                return false;
            }
            currentState = nextState;
        }

        return states[currentState];
    }

    private int getCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return NUM_CHAR;
        } else if (ch == '.') {
            return DOT_CHAR;
        } else if (ch == 'e' || ch == 'E') {
            return E_CHAR;
        } else if (ch == '-' || ch == '+') {
            return MINUS_CHAR;
        }

        return DEAD_CHAR;
    }

    public static void main(String[] args) {
        ValidNumber validNumber = new ValidNumber();


        System.out.println(validNumber.isNumber("0"));
        System.out.println(validNumber.isNumber(" 0.1 "));
        System.out.println(validNumber.isNumber("abc") == false);
        System.out.println(validNumber.isNumber("1 a") == false);
        System.out.println(validNumber.isNumber("2e10"));
        System.out.println(validNumber.isNumber(".3"));
        System.out.println(validNumber.isNumber(".3e2"));
        System.out.println(validNumber.isNumber(".") == false);
        System.out.println(validNumber.isNumber("2131"));
        System.out.println(validNumber.isNumber("8."));
        System.out.println(validNumber.isNumber("-2"));
        System.out.println(validNumber.isNumber("-2."));
        System.out.println(validNumber.isNumber("-") == false);
        System.out.println(validNumber.isNumber("9..") == false);
        System.out.println(validNumber.isNumber("+.3"));
        System.out.println(validNumber.isNumber("-.3e3"));
        System.out.println(validNumber.isNumber("-.") == false);
        System.out.println(validNumber.isNumber("005047e+6"));

        double d = 005047e-3;
    }

}
