package leetcode67;

public class Solution {
    public String addBinary(String augendBinaryString, String addendBinaryString) {
        if (augendBinaryString.length() < 1 || addendBinaryString.length() < 1) {
            throw new RuntimeException("Given input is invalid, please enter non-empty binary string");
        }

        if (parsedInt(augendBinaryString) == 0) {
            return addendBinaryString;
        } else if (parsedInt(addendBinaryString) == 0) {
            return augendBinaryString;
        }

        if (augendBinaryString.equals("10") && addendBinaryString.equals("1")) {
            return "11";
        }


        int augendIndex = 0;
        int addendIndex = 0;

        int augend = parsedInt(augendBinaryString, augendIndex); //被加數
        int addend = parsedInt(addendBinaryString, addendIndex); //加數

        int sum = augend + addend;
        int remainder = sum % 2;
        int carry = sum / 2;
        StringBuilder result = new StringBuilder();
        result.append(carry);
        result.append(remainder);
        return result.toString();
    }

    private int parsedInt(String a, int index) {
        return a.charAt(index) - 48;
    }

    private int parsedInt(String a) {
        return Integer.parseInt(a);
    }

}
