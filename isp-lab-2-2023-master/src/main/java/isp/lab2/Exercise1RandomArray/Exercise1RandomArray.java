package isp.lab2.Exercise1RandomArray;

import java.util.Random;
public class Exercise1RandomArray {

    public static int[] getArrayOfRandomNumbers(int n) {
        int[] array = new int[n];
        //TODO: implement the logic to fill the array with random numbers
        for(int i=0;i< array.length;i++) {
            Random random = new Random();
            int value = random.nextInt(91) + 10;
            array[i] = value;
        }

        return array;
    }

    public static int[] findMaxAndMin(int[] array) {
        int min=100;
        int max=9;
        int[] mm = new int[2];
        for(int i=0;i< array.length;i++) {
            if(array[i]>max)max=array[i];
            if(array[i]<min)min=array[i];
        }
        mm[0]=min;
        mm[1]=max;
        return mm;
    }

    public static void main(String[] args) {

        Random random = new Random();

        //genereaza numar random intre 10 si 100
        int size = random.nextInt(91) + 10;
        int[] a = getArrayOfRandomNumbers(size);
        int[] mm = findMaxAndMin(a);
        System.out.println("Min is:"+mm[0]+" Max is:"+mm[1] );
    }
}
