package Session1;

import java.util.Arrays;

class Main{

public static void main(String[] args){
int[] input = CodingExercise.generateArray(10);

System.out.println("Input: " + Arrays.toString(input));
System.out.println("Output: " + Arrays.toString(CodingExercise.insertionSort(input)));

}
    
}