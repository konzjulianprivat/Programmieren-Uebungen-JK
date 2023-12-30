package main.java.com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
        int checkedState = checkForDuplicatesRows(spielfeld, crossing);
        //System.out.println(checkedState);
        if(checkedState==-1){
            return generateSudokuRecursive(crossing+1, spielfeld);
        } else {
            return generateSudokuRecursive(checkedState, spielfeld);
        }
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
    private static int checkForDuplicatesRows(int[][]spielfeld, int crossing){
        Set<Integer> duplicates = new HashSet<>();
        for (int i = 0; i < crossing; i++) {
            for (int j = 0; j < crossing; j++) {
                if(duplicates.contains(spielfeld[i][j]) && spielfeld[i][j] != 0){
                    if(i <= j){
                        return i;
                    }
                    return j;
                }
                if(spielfeld[i][j] != 0){
                    duplicates.add(spielfeld[i][j]);
                }
            }
            duplicates.clear();
        }
        return checkForDuplicatesColumns(spielfeld, crossing);
    }
    private static int checkForDuplicatesColumns(int[][]spielfeld, int crossing){
        Set<Integer> duplicates = new HashSet<>();
        for (int i = 0; i < crossing; i++) {
            for (int j = 0; j < crossing; j++) {
                if (duplicates.contains(spielfeld[j][i]) && spielfeld[j][i] != 0) {
                    if(i <= j){
                        return i;
                    }
                    return j;
                }
                if(spielfeld[j][i] != 0){
                    duplicates.add(spielfeld[j][i]);
                }
            }
            duplicates.clear();
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
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            numbers.add(i+1);
        }

        for (int i = 0; i < input.length; i++) {
            numbers.remove(Integer.valueOf(input[i]));
        }

        int[] numbersLeft = new int[9];

        for (int i = input.length; i < 9; i++) {
            boolean isSet = false;

            while (!isSet) {
                if (numbers.isEmpty()) {
                    break;
                }

                int randIndex = random.nextInt(numbers.size());
                int randNum = numbers.get(randIndex);

                numbersLeft[i] = randNum;
                numbers.remove(randIndex);
                isSet = true;
            }
        }

        return numbersLeft;
    }
}
