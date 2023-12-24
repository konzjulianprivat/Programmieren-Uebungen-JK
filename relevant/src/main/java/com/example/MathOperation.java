package main.java.com.example;

import java.util.ArrayList;

public class MathOperation {
    public static ArrayList<Integer> fibonacci (int input){
        ArrayList<Integer> output = new ArrayList<>();
        if(input>0){
            switch(input){
                case 1:
                output.add(0);
                return output;

                case 2:
                output.add(0);
                output.add(1);
                return output;

                default:
                output.add(0);
                output.add(1);
            }
        }
        return fibonacciRecursive(output, input-2);
    }
    private static ArrayList<Integer> fibonacciRecursive (ArrayList<Integer> inputAL, int input){
        if(input>0){
            inputAL.add(inputAL.get(inputAL.size()-1)+inputAL.get(inputAL.size()-2));
            return fibonacciRecursive(inputAL, input-1);
        } else {
            return inputAL;
        }
    }
    public static ArrayList<Integer> primeNumbers (int limit){
        ArrayList<Integer> prime = new ArrayList<>();
        if(limit>1){
            for (int i = 2; i <= limit; i++) {
                boolean b=true;
                for (int j = 0; j < prime.size(); j++) {
                    if(i%prime.get(j)==0){
                        b=false;
                    }
                }
                if(b){
                    prime.add(i);
                }
            } 
        }
        return prime; 
    }
    public static boolean isPrime (int input){
        ArrayList<Integer> prime = primeNumbers((int)Math.sqrt(input));
        boolean output;
        if(input>1){
            output=true;
        } else {
            output=false;
        }
        for (int i = 0; i < prime.size(); i++) {
            if(input%prime.get(i)==0){
                output=false;
            }
        }
        return output;
    }
}