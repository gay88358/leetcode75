package leetcode67;
//
public class Solution {
    public String addBinary(String augendBinaryString, String addendBinaryString) {
        if (augendBinaryString.length() < 1 || addendBinaryString.length() < 1) {
            throw new RuntimeException("Given input is invalid, please enter non-empty binary string");
        }
        augendBinaryString = reversed(augendBinaryString);
        addendBinaryString = reversed(addendBinaryString);

        StringBuilder addedBinary = new StringBuilder();
        int maxLength = Math.max(augendBinaryString.length(), addendBinaryString.length());
        int carry = 0;
        for (int index = 0; index < maxLength; index++) {
            int augend = parsedInt(augendBinaryString, index); //被加數
            int addend = parsedInt(addendBinaryString, index); //加數
            int sum = augend + addend + carry;
            int remainder = sum % 2;
            carry = sum / 2;
            addedBinary.append(remainder);
        }
        if (hasUnused(carry)) {
            addedBinary.append(carry);
        }
        return addedBinary.reverse().toString();
    }

    private boolean hasUnused(int carry) {
        return carry == 1;
    }

    private String reversed(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    private int parsedInt(String a, int index) {
        if (index >= a.length()) {
            return 0;
        }
        return a.charAt(index) - 48;
    }
}
