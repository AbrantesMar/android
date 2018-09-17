package com.marcioabrantes.applicationsearch;

public class SpaceClass {
    public static void replaceWhiteSpace(char[] array, int trueArrayLength) {
        if (array != null && array.length > 0) {
            for (int i = trueArrayLength -1, j = array.length -1; i >= 0 && j >=0; i--, j--) {
                if (array[i] == ' ') {
                    array[j] = '2';
                    array[--j] = '3';
                    array[--j] = '&';
                } else {
                    array[j] = array[i];
                }
            }
        }
    }
}
