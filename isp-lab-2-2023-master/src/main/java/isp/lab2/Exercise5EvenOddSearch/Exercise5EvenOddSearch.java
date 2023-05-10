package isp.lab2.Exercise5EvenOddSearch;

public class Exercise5EvenOddSearch {

    public static int[] findEvenOdd(String input) {
        int[] vect=new int[4];
        vect[0]=-3;vect[1]=-3;vect[2]=99;vect[3]=-3;
        //check if there are correct characters in input
        for (int i=0;i<input.length();i++){
            if(!( (input.charAt(i)>='0' && input.charAt(i)<='9') || input.charAt(i)==',') ){
                return vect;}
        }
        String[] string_input=input.split(",");
        //convert from string array to int array
        int[] int_input=new int[input.length()/2+1];
        int k=0;
        for(int i=0;i<string_input.length;i++){
                int_input[i]=Integer.parseInt(string_input[i]);
        }

        //search for even/odd +index
        for(int i=0;i<int_input.length;i++){
            if(int_input[i]%2==0 && int_input[i]>vect[0]){
                vect[0]=int_input[i];
                vect[1]=i;
            }
            if(int_input[i]%2!=0 && int_input[i]<vect[2]){
                vect[2]=int_input[i];
                vect[3]=i;
            }
        }


        return vect;
    }

    public static void main(String[] args) {
        String input = "1,2,9,5,2,10,8";
        int[] result = findEvenOdd(input);
        if(result[0]==-3) System.out.println("Input content is not good!");
        else for (int i : result) {
                System.out.println(i);
                }
    }
}
