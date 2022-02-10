package com.company;

public class WordPuzzle {

    private Box [][] puzzle;

    public boolean toBeLabeled(int r, int c, boolean [][] blackBoxes){
        if (blackBoxes[r][c]) return false;
        if (r == 0 || c == 0) return true;
        return blackBoxes[r - 1][c] || blackBoxes[r][c - 1];
    }

    public WordPuzzle(boolean [][] blackBoxes) {
        int num = 1;
        puzzle = new Box[blackBoxes.length][blackBoxes[0].length];
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[0].length; j++) {
                if (toBeLabeled(i, j, blackBoxes)) {
                    puzzle[i][j] = new Box(false, num);
                    num++;
                }
                else if (!blackBoxes[i][j]){
                    puzzle[i][j] = new Box(false,0);
                }
                else{
                    puzzle[i][j] = new Box(true,0);
                }
            }
        }
    }


    public String toString(){
        String s = "";
        for(int r =0; r < puzzle.length; r++){
            for(int c = 0; c < puzzle[0].length; c++){
                s += puzzle[r][c].toString();
            }
            s += "\n";
        }
        return s;
    }


    public static void main(String[] args){
        boolean[][]blackBoxes = {
                {true,false,false,true,true,true,false,false,false},
                {false,false,false,false,true,false,false,false,false},
                {false,false,false,false,false,false,true,true,true},
                {false,false,true,false,false,false,true,false,false},
                {true,true,true,false,false,false,false,false,false},
                {false,false,false,false,true,false,false,false,false},
                {false,false,false,true,true,true,false,false,true}};

        WordPuzzle wp = new WordPuzzle(blackBoxes);
        System.out.println(wp);
    }
}