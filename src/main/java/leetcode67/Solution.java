package leetcode67;
// 技術: 針對兩個binary字串進行尋訪並且逐步相加，相加兩個bit時需考慮前一次相加的carry。
// 注意細節:
//    1. carry是為了記憶上一次相加的進位值，好讓下一個iteration使用。
//    2. 將字串反轉會比較好處理，因為不需要從後面處理到前面。
//    3. 由於相加時是使用反轉過後的字串並且string builder會append較高位元到後面，
//       這與數字系統剛剛好相反，在數字系統中較高位元在較低位元前面，因此最後要反轉。
//    4. 我們需要考慮當兩個binary string相加到最後一位還有carry時的情況，因此最後需要判斷使否還有carry可以使用，如果有的話，需要一起考慮進去。

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
