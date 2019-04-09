package sortingAndSearching.sortingAlgorithms;

/**
 * complexity O(n2)
 */
public class BubbleSort {

    public static void main(String args[]){
        //int input[] = {6,-1,10,4,11,14,19,12,18};
        int input[] = {-1,4,11,12,14,15,18};
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(input);
        bs.printArray(input);
    }

    public void bubbleSort(int arr[]){

        for (int i = arr.length-1; i >=0 ; i--){
            Boolean swapped = Boolean.FALSE;
            for (int j = 0 ;j < i; j++){
                //swap
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]= temp;
                    swapped = Boolean.TRUE;
                }
            }

            if (!swapped){
                System.out.println("Array is sorted now..breaking loop");
                break;
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
