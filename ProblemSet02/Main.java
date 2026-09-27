import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Main{

    
    public static void main(String[] args) throws IOException{
    File file = new File("ProblemSet02\\Output\\results.csv");
    
    List<Integer> listOfInputSizes = new ArrayList<>(List.of(100, 1000, 10000, 25000));

    EmpiricalEvaluator.evaluateSortingAlgorithms(listOfInputSizes, 1000, file);
    }

}