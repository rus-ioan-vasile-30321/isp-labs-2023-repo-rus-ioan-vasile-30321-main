package isp.lab2.Exercise6WordGuess;

import java.util.Random;
import java.util.Scanner;
public class Exercise6WordGuess {

    /**
     * This method will return the number of occurrences of a character in a word
     * @param c
     * @param word
     * @return
     */
    public static int countOccurence(char c, char[] word) {
        int guess=0;
        for (int i=0;i<word.length;i++)
            if(c==word[i])guess++;
        return guess;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int size = random.nextInt(7) + 4;
        //creating a random word,
        char[] word=new char[size];
        for (int i=0;i<word.length;i++) {
            int value = random.nextInt(26) + 97;
            word[i] = ( char)value;
        }
        //the game
        // k is the number of letters in the word
        int k=0;
        //vect have data about guessed letters
        int[] vect=new int[word.length];
        Scanner reader = new Scanner(System.in);
        boolean exist=false;
        int number_of_wrong_guesses=0;

        System.out.println(word);
        while(k<=word.length) {
            System.out.print("The word: ");
            for (int i = 0; i < vect.length; i++){
                if (vect[i] == 0) System.out.print("_");
                else System.out.print(word[i]);
            }
            if(k==word.length)break;
            System.out.println("k="+k);
            System.out.print("\nGuess a letter:");
            char c = reader.next().charAt(0);

            exist=false;
            for(int i=0;i<word.length;i++)
                if(c==word[i] && vect[i]!=1){
                    if(vect[i]==0)exist=true;
                    vect[i]=1;
                    k++;
                }
            if(exist==false)number_of_wrong_guesses++;
            System.out.println(number_of_wrong_guesses);
            if(number_of_wrong_guesses==3){
                int letter = random.nextInt(vect.length) + 0;
                while(vect[letter]!=0){
                    letter = random.nextInt(vect.length) + 0;
                }
                vect[letter]=1;
                number_of_wrong_guesses=0;
                k++;

            }




        }

    }

}
