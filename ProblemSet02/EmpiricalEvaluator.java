import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import Session1.*;

class EmpiricalEvaluator {


/*
 Evaluates and compares the execution time of Insertion Sort and Selection Sort.
 For each specified input size, this method generates a set number of random arrays,
 sorts them using both algorithms, and appends the execution times (in nanoseconds) 
 to a specified output file.

 @param n                A list of integers representing the different array sizes to test.
 @param problemInstances The number of random arrays to generate and sort for each input size.
 @param file             The destination file where the benchmark results will be written.
 @throws IOException     If an error occurs while opening or writing to the output file.
*/
    public static void evaluateSortingAlgorithms(List<Integer> n, int problemInstances, File file) throws IOException {
        FileWriter fw = new FileWriter(file);
        List<Long> insertionSortResults;
        List<Long> selectionSortResults;
        fw.write("Algorithm,	InputSize,	RunNumber, ExecutionTime\n");

        for(int i=0; i<n.size(); i++){
            int currentInputSize = n.get(i);

            insertionSortResults = new ArrayList<>();
            selectionSortResults = new ArrayList<>();

            for(int j=0; j<problemInstances; j++){
            int[] arr1 = CodingExercise.generateArray(currentInputSize);
            int[] arr2 = arr1.clone();
            insertionSortResults.add(calculateInsertionSortTime(currentInputSize, arr1));
            selectionSortResults.add(calculateSelectionSortTime(currentInputSize, arr2));
            }
            
            for(int j=0; j<problemInstances; j++){
                int iteration = j+1;
            fw.write("InsertionSort, " + n.get(i) + ", " + iteration +  ", " + insertionSortResults.get(j) + "\n");
            }
            for(int j=0; j<problemInstances; j++){
                int iteration = j+1;
            fw.write("SelectionSort, " + n.get(i) + ", " + iteration +  ", " + selectionSortResults.get(j) + "\n");
            }
        
        }
        fw.close();
    }

    private static Long calculateInsertionSortTime(int n, int[] arr){
        long startTime;
        long resultingTime;   

        startTime = System.nanoTime();
        CodingExercise.insertionSort(arr, n);
        resultingTime = System.nanoTime() - startTime;
        
        return resultingTime;
    }

    private static Long calculateSelectionSortTime(int n, int[] arr){
        long startTime;
        long resultingTime;   

        startTime = System.nanoTime();
        CodingExercise.selectionSort(arr, n);
        resultingTime = System.nanoTime() - startTime;
        
        return resultingTime;
    }    
    

}