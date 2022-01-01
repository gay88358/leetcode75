package leetcode20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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