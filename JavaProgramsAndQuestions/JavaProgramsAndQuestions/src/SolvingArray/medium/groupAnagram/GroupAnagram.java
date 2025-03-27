package SolvingArray.medium.groupAnagram;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] strs = {"act","pots","tops","cat","stop","hat"};

        ArrayList<ArrayList<String>> output =  setAnagram(strs);

        System.out.println(output);
    }

    private static ArrayList<ArrayList<String>> setAnagram(String[] strs) {
        ArrayList<ArrayList<String>> newList = new ArrayList<>();

        for (int i = 0; i < strs.length-1; i++) {
            Boolean value = findAnagram(strs[i], strs[i+1]);

            if (value == true){
                ArrayList<String> anagramList = new ArrayList<>();

                anagramList.add(strs[i]);
                anagramList.add(strs[i+1]);

                newList.add(anagramList);
            }
        }

        return newList;
    }

    private static Boolean findAnagram(String str, String str1) {
        if (str.length() != str1.length()){
            return false;
        }

        HashMap<Character, Integer> strMap = new HashMap<>();
        HashMap<Character, Integer> str1Map = new HashMap<>();

        for (int i = 0; i < str.length()-1; i++) {
            strMap.put(str.charAt(i), strMap.getOrDefault(str.charAt(i),0)+1);
            str1Map.put(str1.charAt(i), str1Map.getOrDefault(str1.charAt(i),0)+1);
        }

        return strMap.equals(str1Map);
    }
}


// Time Complexity O(m*n)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String s : strs){
            int[] count = new int[26];

            for (char c : s.toCharArray()){
                count[c - 'a'] ++;
            }

            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }

        return new ArrayList<>(res.values());
    }
}
