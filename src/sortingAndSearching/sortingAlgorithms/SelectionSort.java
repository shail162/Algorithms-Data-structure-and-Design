package sortingAndSearching.sortingAlgorithms;

/**
 * O(n2)
 */
public class SelectionSort {

    public static void main(String args[]){
        int input[] = {6,-1,10,4,11,14,19,12,18};
        SelectionSort bs = new SelectionSort();
        bs.selectionSort(input);
        bs.printArray(input);
    }

    public void selectionSort(int arr[]){

        for (int i = 0; i < arr.length ; i ++){
            for (int j = i+1; j < arr.length; j++){
                if (arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public void printArray(int input[]){
        for(int i : input){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
