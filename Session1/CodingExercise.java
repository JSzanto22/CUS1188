package Session1;

public class CodingExercise {

    public static boolean isAscendingOrder(int[] s){
        if(s.length == 0) return true;
        int prev = Integer.MIN_VALUE;
        for(int current : s){
            if(current < prev){
                return false;
            }
            prev = current;
        }
        return true;
    }

    public static int[] generateArray(int size){
        if(size < 0) System.out.println("Input a positive size");
        int[] result = new int[size];
        for(int i=0; i<size; i++){
            result[i] = (int) (Math.random()*100);
        }
        return result;
    }

    public static int[] insertionSort(int[] s, int n){
        for(int i=1; i<n; i++){
            int j = i-1;
            int key = s[i];
            while(j >= 0 && key < s[j]){
                s[j+1] = s[j];
                j--;
            }
            s[j+1] = key;
        }

        return s;
    }


    public static int[] selectionSort(int[] s, int n){
        int temp = 0;
        

        for(int i=0; i<n; i++){
            int SmallestElementByIndex = i;
            for(int j=i+1; j<n; j++){

                if(s[j] < s[SmallestElementByIndex]){
                    SmallestElementByIndex = j;
                }
            }
            if(s[i] > s[SmallestElementByIndex]){
            temp = s[i];
            s[i] = s[SmallestElementByIndex];
            s[SmallestElementByIndex] = temp;
            }
        }

        return s;
    }

}