package main.java.com.example;

import java.util.ArrayList;
import java.util.Random;

public class SortingAlgorithm {
    public static ArrayList<Integer> createRandomArrayList (int length){
        Random random = new Random();
        ArrayList<Integer> output = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            output.add(random.nextInt(100));
        }
        return output;
    }
    protected static void clearList(ArrayList<Integer> input){
        while(input.size()>0){
            input.remove(0);
        }
    }
    protected static void swapPositions(ArrayList<Integer> input, int i){
        int carry = input.get(i);
        input.set(i,input.get(i+1));
        input.set(i+1,carry);
    }
    public static ArrayList<Integer> bubbleSortArrayList (ArrayList<Integer> input){
        ArrayList<Integer> output = new ArrayList<>();
        
        while(input.size()>1){
            for (int i = 0; i < input.size()-1; i++) {
                if(input.get(i)>input.get(i+1)){
                    swapPositions(input, i);
                }
            }
            output.add(0,input.get(input.size()-1));
            input.remove(input.size()-1);
        }
        output.add(0,input.get(0));
        for (int i = 0; i < output.size(); i++) {
            input.add(i,output.get(i));
        }
        input.remove(input.size()-1);
        return input;
    }
    public static ArrayList<Integer> insertionSortArrayList (ArrayList<Integer> input){
        for (int i = 0; i < input.size()-1; i++) {
            if(input.get(i)>input.get(i+1)){
                swapPositions(input, i);
                for (int j = i; j > 0; j--) {
                    if(input.get(j-1)>input.get(j)){
                        swapPositions(input, j-1);
                    }
                }
            }
        }
        return input;
    }
    public static ArrayList<Integer> mergeSortArrayList (ArrayList<Integer> input){
        ArrayList<Integer> split1 = new ArrayList<>();
        ArrayList<Integer> split2 = new ArrayList<>();
        if(input.size()<=1){
            return input;
        } else {
            for (int i = 0; i < input.size(); i++) {
                if(i<(int)input.size()/2){
                    split1.add(input.get(i));
                } else {
                    split2.add(input.get(i));
                }
            }
            split1 = mergeSortArrayList(split1);
            split2 = mergeSortArrayList(split2);
        }
        int i=0;
        int j=0;
        ArrayList<Integer> output = new ArrayList<>();
        while(i<split1.size() && j<split2.size()){
            if(split1.get(i)<split2.get(j)){
                output.add(split1.get(i));
                i++;
            } else {
                output.add(split2.get(j));
                j++;
            }
        }
        if(i<split1.size()||j<split2.size()){
            for (int k = i; k < split1.size(); k++) {
                output.add(split1.get(k));
            }
            for (int k = j; k < split2.size(); k++){
                output.add(split2.get(k));
            }
        }
        return output;
    }
    public static ArrayList<Integer> quickSortArrayList(ArrayList<Integer> input){
        ArrayList<Integer> split1 = new ArrayList<>();
        ArrayList<Integer> split2 = new ArrayList<>();
        if(input.size()<=1){
            return input;
        }
        int pivot=input.get(0);
        for (int i = 0; i < input.size(); i++) {
            if(input.get(i)<pivot){
                split1.add(input.get(i));
            } else if (input.get(i)>pivot){
                split2.add(input.get(i));
            }
        }
        split1 = quickSortArrayList(split1);
        split2 = quickSortArrayList(split2);
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < split1.size(); i++) {
            output.add(split1.get(i));
        }
        output.add(pivot);
        for (int i = 0; i < split2.size(); i++) {
            output.add(split2.get(i));
        }
        return output;
    }
}
