package baseball;

public class Validator {

    public boolean isLengthThree(String input) {
        return input.length() == 3;
    }

    public boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    public boolean isAllDifferentNumber(String input) {
        boolean[] isUsedNumber = new boolean[9];

        for (int i = 0; i < input.length(); i++) {
            int number = input.charAt(i) - '0';
            if (isUsedNumber[number]) {
                return false;
            }
            isUsedNumber[number] = true;
        }
        return true;
    }

    public boolean isRightRangeNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            int number = input.charAt(i) - '0';
            if (number < 1 || number > 9) {
                return false;
            }
        }
        return true;
    }
}
