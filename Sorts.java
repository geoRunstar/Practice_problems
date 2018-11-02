import java.util.AbstractCollection;

/**
 * Created by geordie on 12/13/17.
 */
public class Sorts {
//class contains various sort methods I have wrote and used in projects.
    public int[] mergeA, temp;
    public void SelectionSort(int[] array ){
          int a =1;
        while(a!=array.length) {
            int smallest = array[a];
            int index =a;
            for (int i = a; i<array.length; i++){

                if(smallest>array[i]){
                    index=i;
                smallest = array[i];}
            }
            int b= a-1;
                    if(array[b]>array[index])
                swap(b,index,array);
            a++;
        }
    }
    public void bubbleSort(int[] arrar){

        for(int i=0; i<arrar.length; i++){
            for(int j =i; j< arrar.length;j++){
                if(arrar[i]>arrar[j])
                    swap(i,j,arrar);
            }
        }

    }
    public void insertionSort(int[] array){
for(int i=1; i< array.length; i++){
    int j, v = array[i];
    for(j = i-1; j>=0; j--){

        if(array[j]<=v)break;

        array[j+1] = array[j];

    }
    array[j+1] = v;
}


    }
    public void swap(int from, int to, int[] array){

        int temp = array[from];
        array[from]= array[to];
        array[to] = temp;

    }
    public void Display(int[] array){
        for(int i=0; i< array.length; i++){
            System.out.println(array[i]);
        }
    }

    public void MergeSort(int[] mergeA){
        this.mergeA=mergeA;
        temp = new int[mergeA.length];
        split(0, mergeA.length-1);
    }
    private void split(int low, int high){
        if(low == high)return;
        int mid = (high+low)/2;
        split(low, mid);
        split(mid+1,high);
        merge(low, mid,high);

    }
    private void merge(int low, int mid, int high){

        int i = low; int j = mid+1; int temppos = low;
        while(i<=mid && j<=high) {

            if (mergeA[i] <= mergeA[j])
                temp[temppos++] = mergeA[i++];
            else
                temp[temppos++] = mergeA[j++];
        }
         while(i<= mid)
             temp[temppos++]= mergeA[i++];
                while(j<= high)
                    temp[temppos++]= mergeA[j++];
        for(temppos=low; temppos<=high; temppos++){
            mergeA[temppos]= temp[temppos];
        }

    }

    public static void main(String[] args ){
        Sorts s = new Sorts();



    }
}
