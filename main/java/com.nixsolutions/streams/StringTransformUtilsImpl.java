package com.nixsolutions.streams;

import com.nixsolutions.ppp.streamoptional.StringTransformUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StringTransformUtilsImpl implements StringTransformUtils {

    public List<String> findDistinctToUpperCase(String[] arrayOfStrings) {
        return Arrays.stream(arrayOfStrings)
                .distinct()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public long countNegativeIntegers(List<Integer> listOfIntegers) {
        return listOfIntegers.stream()
                .filter(i -> i < 0)
                .count();
    }

    public long countWordsInList(List<String> listOfWords, String wordToCount) {
        return listOfWords.stream()
                .filter(w -> w.contains(wordToCount))
                .count();
    }

    public List<String> toDistinctList(List<String[]> listOfStringArrays) {
        return listOfStringArrays.stream()
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    public boolean isAllStringsLongerThen(List<String> listOfStrings,
                long numberOfCharacters) {
        if (numberOfCharacters < 0) {
            throw new IllegalArgumentException();
        }
        return listOfStrings.stream()
                .allMatch((s -> numberOfCharacters < s.length()));
    }

    public List<Integer> getMaxFiveNumbers(int[] arrayOfNumbers) {
        if (arrayOfNumbers.length < 5) {
            throw new IllegalArgumentException();
        }
        return (Arrays.stream(arrayOfNumbers)
                .boxed()
                .sorted(Collections.reverseOrder())
                .limit(5)
                .sorted()
                .collect(Collectors.toList()));
    }

    public String getStringOfNumbers(int[] arrayOfNumbers) {
        return (Arrays.stream(arrayOfNumbers)
                .boxed()
                .map(Object::toString)
                .collect(Collectors.joining(",")));
    }

    public String getFirstCharactersAsString(List<String> listOfStrings) {
        return listOfStrings.stream()
                .map(x -> x.charAt(0))
                .map(Object::toString)
                .reduce("", String::concat);
    }

    public Map<Integer, List<String>> groupByLength(List<String> listOfStrings) {
        return listOfStrings.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.toList()));
    }
}
