package leetcode49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // clean version with declarative style
        return new ArrayList<>(
                Arrays.stream(strs)
                        .map(Anagrams::new)
                        .collect(
                                groupingBy(
                                        Anagrams::id,
                                        Collectors.mapping(Anagrams::value, toList()))
                        )
                        .values()
        );

        // non-clean version with imperative style
//      List<Anagrams> anagramsList = toAnagramsList(strs);
//      Map<String, List<String>> anagramsMap = toAnagramsIdAndValueMap(anagramsList);
//      return new ArrayList<>(anagramsMap.values());
    }

    private Map<String, List<String>> toAnagramsIdAndValueMap(List<Anagrams> anagramsList) {
        Map<String, List<String>> anagramsMap = new HashMap<>();
        for (Anagrams anagrams: anagramsList) {
            var id = anagrams.id();
            if (anagramsMap.containsKey(id)) {
                anagramsMap.get(id).add(anagrams.value());
            } else {
                List<String> value = new ArrayList<>();
                value.add(anagrams.value());
                anagramsMap.put(id, value);
            }
        }
        return anagramsMap;
    }

    private List<Anagrams> toAnagramsList(String[] strs) {
        return Arrays.stream(strs)
                .map(Anagrams::new)
                .collect(Collectors.toList());
    }

    public static class Anagrams {
        private final String value;
        // index: 0~25 -> a~Z, value: occurrence of each char
        private final int[] charCodeCountMap;
        public Anagrams(String value) {
            this.value = value;
            this.charCodeCountMap = parse(value);
        }

        public String value() {
            return this.value;
        }

        public String id() {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < charCodeCountMap.length; i++) {
                int code = charCodeCountMap[i];
                for (int j = 0; j < code; j++) {
                    int charCode = i + 'a';
                    result.append((char)charCode);
                }
            }
            return result.toString();
        }

        private int[] parse(String value) {
            int[] result = new int[26];
            for (char c: value.toCharArray()) {
                int position = c - 'a';
                result[position] += 1;
            }
            return result;
        }
    }
}
