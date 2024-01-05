package com.example;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.Uebungen.KlammernGueltig;

public class Testing {
    public static void main(String[] args) {
        //testSortingAlgorithmTimeMeasure(1000);
        //testMathOperation(5);
        Sudoku.printSpielfeld(Sudoku.generateSudoku());
        System.out.println(KlammernGueltig.checkForKlammernAdvanced("())"));
    }
    public static void testMathOperation(int j){
        System.out.println("Input: " + j);
        System.out.println("Fibonacci: " + MathOperation.fibonacci(j));
        System.out.println("PrimeNumbers: " + MathOperation.primeNumbers(j));
        System.out.println("isPrimeNumber: " + MathOperation.isPrime(j));
        System.out.println("Collatz: " + MathOperation.collatz(j));
        System.out.println("Faculty: " + MathOperation.faculty(j));
        System.out.println("FacultyRecursive: " + MathOperation.facultyRecursive(j));
    }
    public static void testSortingAlgorithm(int j){
        ArrayList<Integer> test = SortingAlgorithm.createRandomArrayList(j);
            System.out.println(test);
            System.out.println(SortingAlgorithm.quickSortArrayList(test));
            System.out.println(SortingAlgorithm.mergeSortArrayList(test));
            System.out.println(SortingAlgorithm.insertionSortArrayList(test));
            System.out.println(SortingAlgorithm.bubbleSortArrayList(test));
    }
    public static void testSortingAlgorithmTimeMeasure(int maximum){
        long a=0;
        long b=0;

        ArrayList<Long> messungen1 = new ArrayList<>();
        ArrayList<Long> messungen2 = new ArrayList<>();
        ArrayList<Long> messungen3 = new ArrayList<>();
        ArrayList<Long> messungen4 = new ArrayList<>();
        
        for (int j = 5; j <= maximum; j=j+5) {
            a = System.currentTimeMillis();
            SortingAlgorithm.quickSortArrayList(SortingAlgorithm.createRandomArrayList(j));
            b = System.currentTimeMillis()-a;
            messungen1.add(b);

            a = System.currentTimeMillis();
            SortingAlgorithm.mergeSortArrayList(SortingAlgorithm.createRandomArrayList(j));
            b = System.currentTimeMillis()-a;
            messungen2.add(b);

            a = System.currentTimeMillis();
            SortingAlgorithm.insertionSortArrayList(SortingAlgorithm.createRandomArrayList(j));
            b = System.currentTimeMillis()-a;
            messungen3.add(b);

            a = System.currentTimeMillis();
            SortingAlgorithm.bubbleSortArrayList(SortingAlgorithm.createRandomArrayList(j));
            b = System.currentTimeMillis()-a;
            messungen4.add(b);  
        }
        HashMap<Integer, Integer> winner = new HashMap<>();
        for (int i = 0; i < messungen1.size(); i++) {
            long max=0;
            int maxi=0;
            long[] comp = {messungen1.get(i), messungen2.get(i), messungen3.get(i), messungen4.get(i)};
            for (int j = 0; j < comp.length; j++) {
                if(comp[j]>max){
                    max = comp[j];
                    maxi = j;
                }
            }
            winner.put(i,maxi);
        }
        int[] punkte = new int[4];
        for (int i = 0; i < messungen1.size(); i++) {
            punkte[winner.get(i)] += 1;
        }
        System.out.println("QS: " + punkte[0]);
        System.out.println("MS: " + punkte[1]);
        System.out.println("IS: " + punkte[2]);
        System.out.println("BS: " + punkte[3]);
    }
}
