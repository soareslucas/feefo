package com.feefo.exercise.utils;

import java.util.*;

public class Normaliser {
    

    
    public String normalise(String s1, List<String> listStrings) {

        Map<String , Double> hm = new HashMap<String, Double>();


        for(String s2 : listStrings){
            Double qualityScore = this.similarity(s1, s2);
            hm.put(s2, qualityScore);
        }

        Double max = hm.values().stream().max(Comparator.naturalOrder()).get();

        Optional<String> normalised =  hm.entrySet().stream()
            .filter(e -> e.getValue().equals(max))
            .map(Map.Entry::getKey).findFirst();

        return normalised.get();

    }


    /**
     * Calculates the similarity (a number within 0 and 1) between two strings.
    */
    public Double similarity(String s1, String s2) {
        String longer = s1, shorter = s2;
        if (s1.length() < s2.length()) { // longer should always have greater length
            longer = s2; shorter = s1;
        }
        int longerLength = longer.length();
        if (longerLength == 0) { return 1.0; /* both strings are zero length */ }
        /* // If you have StringUtils, you can use it to calculate the edit distance:
        return (longerLength - StringUtils.getLevenshteinDistance(longer, shorter)) /
                                                             (double) longerLength; */
        return Double.valueOf((longerLength - editDistance(longer, shorter)) / (double) longerLength);
 
    }
 
    // Example implementation of the Levenshtein Edit Distance
    public static int editDistance(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
 
        int[] costs = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int lastValue = i;
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0)
                    costs[j] = j;
                else {
                    if (j > 0) {
                        int newValue = costs[j - 1];
                        if (s1.charAt(i - 1) != s2.charAt(j - 1))
                            newValue = Math.min(Math.min(newValue, lastValue),
                                    costs[j]) + 1;
                        costs[j - 1] = lastValue;
                        lastValue = newValue;
                    }
                }
            }
            if (i > 0)
                costs[s2.length()] = lastValue;
        }
        return costs[s2.length()];
    }





}
