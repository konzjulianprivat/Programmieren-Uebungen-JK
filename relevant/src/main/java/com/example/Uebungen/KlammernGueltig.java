package main.java.com.example.Uebungen;

import java.util.ArrayList;

public class KlammernGueltig{
    public static boolean checkForKlammern(String input){
        String[] letters=input.split("");
        int beginCounter=0;
        int closeCounter=0;
        for (int i = 0; i < letters.length; i++) {
            if(letters[i].equals("{")||letters[i].equals("[")||letters[i].equals("(")){
                beginCounter++;
            } else if (letters[i].equals("}")||letters[i].equals("]")||letters[i].equals(")")){
                closeCounter++;
            }
        }
        if(beginCounter==closeCounter){
            return true;
        } else {
            return false;
        }
    }
    public static boolean checkForKlammernAdvanced(String input){
        String[] letters = input.split("");
        ArrayList<String> output = new ArrayList<>();
        for (int i = 0; i < letters.length; i++) {
            if(letters[i].equals("{")||letters[i].equals("[")||letters[i].equals("(")||letters[i].equals("}")||letters[i].equals("]")||letters[i].equals(")")){
                output.add(letters[i]);
            }
        }
        if(!output.isEmpty()){
            switch(output.get(0)){
                case "{": return checkForKlammernRecursive(0, output, "{");
                case "[": return checkForKlammernRecursive(0, output, "[");
                case "(": return checkForKlammernRecursive(0, output, "(");
            }
        }
        return true;
    }
    public static boolean checkForKlammernRecursive(int index, ArrayList<String> letters, String toCheck){
        boolean finished=false;
        boolean temp=false;
        if(letters.size()-index>1){
            switch(letters.get(index+1)){
                case "{": finished= checkForKlammernRecursive(index+1, letters, "{");
                case "[": finished= checkForKlammernRecursive(index+1, letters, "[");
                case "(": finished= checkForKlammernRecursive(index+1, letters, "(");
            }
            if(letters.size()-index<=1){
                return finished;
            }
            switch(toCheck){
                case "{":
                    if(letters.get(index+1).equals("}")){
                        temp=true;
                    } else {
                        return false;
                    }
                case "[":
                    if(letters.get(index+1).equals("]")){
                        temp= true;
                    } else {
                        return false;
                    }
                case "(":
                    if(letters.get(index+1).equals(")")){
                        temp= true;
                    } else {
                        return false;
                    }
            }
            if(letters.size()-index<=1){
                return true;
            } else {
                return checkForKlammernRecursive(index+1, letters, letters.get(index+2));
            }
        } else {
            return false;
        }
    }
}