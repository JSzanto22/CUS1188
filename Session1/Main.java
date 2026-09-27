package Session1;

import java.util.Arrays;

class Main{

public static void main(String[] args){
int[] input = CodingExercise.generateArray(10);

System.out.println("Testing Insertion Sort:\tInput: " + Arrays.toString(input));
System.out.println("\tOutput: " + Arrays.toString(CodingExercise.insertionSort(input, input.length)));
System.out.println("\tFunction worked? " + CodingExercise.isAscendingOrder(input));

System.out.println("Testing Selection Sort:\tInput: " + Arrays.toString(input));
System.out.println("\tOutput: " + Arrays.toString(CodingExercise.selectionSort(input, input.length)));
System.out.println("\tFunction worked? " + CodingExercise.isAscendingOrder(input));

}
    
}