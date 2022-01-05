package leetcode20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
// 技術: 透過stack first in last out的特定來驗證parentheses的正確性
// 實作細節: 遇到close token放到stack, 遇到open token將stack第一個值pop出來
//          將這對pair進行驗證
//          尋訪字串節結束後，如果stack還有值 (代表剩下的parentheses沒有對應正確的parentheses去與他結合，因此不正確)。

class Solution {
    private final Stack stack = new Stack();

    public boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            if (Parentheses.isOpenParentheses(currentChar)) {
                stack.add(currentChar);
            } else if (Parentheses.isCloseParentheses(currentChar)) {
                boolean hasNoCorrespondingOpenParentheses = stack.isEmpty();
                if (hasNoCorrespondingOpenParentheses) {
                    return false;
                }

                Character potentialOpenParentheses = stack.pop();
                if (!Parentheses.create(potentialOpenParentheses, currentChar).isPresent()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static class Parentheses {
        private static final Map<Character, Character> parenthesesMap = createParenthesesMap();

        private static boolean isOpenParentheses(Character c) {
            return parenthesesMap.containsKey(c);
        }

        private static boolean isCloseParentheses(Character c) {
            return parenthesesMap
                    .values()
                    .stream()
                    .anyMatch(closed -> closed.equals(c))
                    ;
        }

        private static Map<Character, Character> createParenthesesMap() {
            Map<Character, Character> result = new HashMap<>();
            result.put('(', ')');
            result.put('{', '}');
            result.put('[', ']');
            return result;
        }

        static Optional<Parentheses> create(Character left, Character right) {
            try {
                return Optional.of(new Parentheses(left, right));
            } catch (IllegalArgumentException e) {
                return Optional.empty();
            }
        }

        private Parentheses(Character left, Character right) {
            if (parenthesesMap.get(left) != right) {
                throw new IllegalArgumentException("Given Parentheses is Invalid");
            }

        }
    }

    private static class Stack {
        private final List<Character> characterList = new ArrayList<>();

        public void add(Character character) {
            this.characterList.add(character);
        }

        public Character pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack has no element to pop, please check the stack has elements");
            }
            var result = characterList.get(characterList.size() - 1);
            characterList.remove(characterList.size() - 1);
            return result;
        }

        public boolean isEmpty() {
            return this.characterList.isEmpty();
        }
    }
}