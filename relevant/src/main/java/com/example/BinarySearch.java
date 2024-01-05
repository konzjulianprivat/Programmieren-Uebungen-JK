package com.example;

import java.util.ArrayList;

public class BinarySearch {
    public static int binarySearch(ArrayList<Integer> input, int search){
        return binarySearchRecursive(input, search, 0, input.size());
    }
    public static int binarySearchRecursive (ArrayList<Integer> input, int search, int iStart, int iEnd){
        if(iEnd-iStart<=1){
            return -1;
        } else {
            if(input.get((iStart+iEnd)/2)==search){
                return (iStart+iEnd)/2;
            } else if(search>input.get((iStart+iEnd)/2)){
                return binarySearchRecursive(input, search, (iStart+iEnd)/2, iEnd);
            } else if (search<input.get((iStart+iEnd)/2)){
                return binarySearchRecursive(input, search, iStart, (iStart+iEnd)/2);
            } else {
                return -1;
            }
        }
    }
    public static ArrayList<Integer> collatz (int zahl){
        ArrayList<Integer> input = new ArrayList<>();
        return collatzRecursive(input, zahl);
    }

    private static ArrayList<Integer> collatzRecursive(ArrayList<Integer> input, int zahl){
        int temp = 0;
        input.add(zahl);
        if(zahl ==1){
            return input;
        }
        if(zahl%2 == 0){
             temp = zahl/2;
        }
        if(zahl%2 !=0){
             temp =3*zahl+1;
        }
        return collatzRecursive(input, temp);
    }
    
}