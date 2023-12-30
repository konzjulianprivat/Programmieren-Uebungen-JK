package main.java.com.example;

import java.util.ArrayList;
import java.util.Random;

public class Sudoku {
    public static int[][] generateSudoku(){
        
        return generateSudokuRecursive(0,createSpielfeld());
    }
    private static int[][] generateSudokuRecursive(int crossing, int[][]spielfeld){
        if(crossing==9){
            return spielfeld;
        }
        addRowToCrossing(spielfeld, crossing);
        addColumnToCrossing(spielfeld, crossing);
        int checkedState = checkForDuplicates(spielfeld);
        System.out.println(checkedState);
        return generateSudokuRecursive(crossing+1, spielfeld);
    }
    private static int[][]addRowToCrossing(int[][]spielfeld,int crossing){
        int[]rowOld=new int[crossing];
        for (int i = 0; i < crossing; i++) {
            rowOld[i]=spielfeld[crossing][i];
        }
        //create sublist
        int[]row = generateSubline(rowOld);
        //add row to spielfeld
        for (int i = crossing; i < 9; i++) {
            spielfeld[crossing][i]=row[i];
        }
        return spielfeld;
    }
    private static int checkForDuplicates(int[][]spielfeld){
        
        for (int i = 0; i < 9; i++) {
            ArrayList<Integer>duplicates=new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                for (int j2 = 0; j2 < duplicates.size(); j2++) {
                    if(spielfeld[i][j]==duplicates.get(j2)&&spielfeld[i][j]!=0){
                        if(i<=j){
                            System.out.println(spielfeld[i][j]+" ist doppelt");
                            return i;
                        }
                        System.out.println(spielfeld[i][j]+" ist doppelt");
                        return j;
                    }
                }
                if(spielfeld[i][j]!=0){
                    duplicates.add(spielfeld[i][j]);
                }
            }
            
        }
        return -1;
    }
    private static int[][]addColumnToCrossing(int[][]spielfeld, int crossing){
        int[]columnOld=new int[crossing+1];
        columnOld[0]=0;
        for (int i = 0; i <= crossing; i++) {
            columnOld[i]=spielfeld[i][crossing];
        }
        //create sublist
        int[]column = generateSubline(columnOld);
        //add row to spielfeld
        for (int i = crossing+1; i < 9; i++) {
            spielfeld[i][crossing]=column[i];
        }
        return spielfeld;
    }
    public static void printSpielfeld(int[][] spielfeld){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.printf(spielfeld[i][j]+ "  ");
            }
            System.out.println("");
        }
    }
    private static int[][] createSpielfeld(){
        int[][]spielfeld = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                spielfeld[i][j]=0;
            }
        }
        return spielfeld;
    }
    private static int[] generateSubline(int[] input){
        int[] numbersLeft = new int[9];
        ArrayList<Integer> numbersRandom = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            numbers.add(i+1);
        }
        for (int i = 8; i > 0; i--) {
            int m=random.nextInt(i);
            numbersRandom.add(numbers.get(m));
            numbers.remove(m);
        }
        numbersRandom.add(numbers.get(0));
        for (int i = input.length; i < 9; i++) {
            boolean isSet=false;
            while(!isSet){
                boolean notIn = true;
                for (int j = 0; j < input.length; j++) {
                    if(input[j]==numbersRandom.get(0)){
                        notIn=false;
                    }
                }
                if(notIn){
                    numbersLeft[i]=numbersRandom.get(0);
                    isSet=true;
                }
                numbersRandom.remove(0);
            }
        }
        return numbersLeft;
    }
}
