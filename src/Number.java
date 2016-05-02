import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dylan on 02/05/2016.
 */

public class Number {
    //Every digit has a unique letter
    public static String digits[] = {"ZERO", "SIX", "EIGHT", "THREE", "FOUR", "FIVE", "SEVEN", "TWO", "ONE", "NINE"};
    //The unique of each letter
    public static char letters[] = {'Z', 'X', 'G', 'H', 'R', 'F', 'V', 'W', 'O', 'N'};

    public static void main(String args[]) {
        int test_case, array[] = new int[10];
        String temp;
        try {
            Scanner scanner = new Scanner(new File("A-large-practice.in"));
            PrintWriter out = new PrintWriter("output.txt");
            test_case = scanner.nextInt();
            scanner.useDelimiter("\n");
            //Loop
            for (int i = 1; i <= test_case; i++) {
                //Fill array with 0
                Arrays.fill(array, 0);
                //Storing the string until new line
                temp = scanner.next();
                //Create a boolean size of string
                boolean check[] = new boolean[temp.length()];
                //Fill an array with value of each number encounter
                for (int j = 0; j < 10; j++) {
                    array[j] = numbersize(temp, check, j);
                }
                //Arrange array to array from 0 to 9
                arrange_arr(array);
                //Output
                out.print("Case #" + i + ": ");
                for (int p = 0; p < 10; p++) {
                    for (int q = 0; q < array[p]; q++) {
                        out.print(p);
                    }
                }
                out.print("\n");
            }
            out.close ();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static int numbersize(String s, boolean a[], int j){
        int total = 0;
        //Total unique letter using the boolean array
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == letters[j] && !a[i]) {
                total++;
                }
            }
        //N mentioned twice
        if(j == 9)
            total = total / 2;
        //Feeling the boolean with the letters used
        for(int z = 0; z < digits[j].length(); z++) {
            int temp = 0;
            //SEVEN AND THREE have repeated E
            if((j == 3 || j == 6) && digits[j].charAt(z) == 'E')
                temp += total / 2;
            for (int i = 0; i < s.length(); i++) {
                //Fill the boolean with the encountered
                if(digits[j].charAt(z) == s.charAt(i) && temp < total && !a[i]) {
                    a[i] = true;
                    temp++;
                }
            }
        }
    return total;
    }

    public static void arrange_arr(int array[]){
        int swap;
        //Swapping the array to make it from 0 to 10
        swap = array[1];
        array[1] = array[8];
        array[8] = swap;

        swap = array[2];
        array[2] = array[7];
        array[7] = swap;

        swap = array[6];
        array[6] = array[8];
        array[8] = swap;

        swap = array[7];
        array[7] = array[8];
        array[8] = swap;
    }
}
