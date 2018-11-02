
import java.util.*;

/**
 * RadixSort driver demonstrates the use of queues in the execution of a radix sort.
 *
 * @author Lewis and Chase
 * @version 4.0
 * 
 * uses the queue developed in class rather than Queue<generic>
 */
public class RadixSort     
{
    public RadixSort(){

    }
    public String[] radixSorting(String [] list, int width){
       // width= width;
        String temp;
        LinkedQueue[] ques = new LinkedQueue[width];
        for(int h = 0; h< ques.length;h++){
            ques[h] = new LinkedQueue();
        }
        for(int i =0; i< width; i ++){
            for(int j =0; j< list.length; j ++){
                temp = list[j].substring(i,i+1);
                int tempint = Integer.parseInt(temp);

                ques[tempint].enQueue(""+list[j]);
            }
            int incre=0;
            for (int k = 0; k < width; k++){

                while(!ques[k].isEmpty()){
                    list[incre]=""+ ques[k].deQueue();
                    incre++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args){
        RadixSort r = new RadixSort();
        String[] test = {"1111", "1132", "1234", "2001"};
       String[] result = r.radixSorting(test, 4);
    }
    /**
     *Performs a radix sort on a set of numeric values.
	 */
   /* public static void main(String[] args)
    { 
        int[] list = {7843, 4568, 8765, 6543, 7865, 4532, 9987, 3241,
                         6589, 6622, 1211};

        String temp;
        Integer numObj;
        int digit, num;




      //  Queue<Integer>[] digitQueues = (LinkedList<Integer>[])(new LinkedList[10]);
        LinkedQueue[] digitQueues = new LinkedQueue[10];
        
        
        for (int digitVal = 0; digitVal <= 9; digitVal++)
          //  digitQueues[digitVal] = (Queue<Integer>)(new LinkedList<Integer>());
        	     digitQueues[digitVal] = new LinkedQueue();

        // sort the list
        for (int position=0; position <= 3; position++)
        {
            for (int scan=0; scan < list.length; scan++)
            {
                temp = String.valueOf(list[scan]);
                digit = Character.digit(temp.charAt(3-position), 10);
                digitQueues[digit].enQueue("" +new Integer(list[scan]));
            }

            // gather numbers back into list
            num = 0;
            for (int digitVal = 0; digitVal <= 9; digitVal++)
            {
                while (!(digitQueues[digitVal].isEmpty()))
                {
                    numObj = Integer.parseInt(digitQueues[digitVal].deQueue());
                    list[num] = numObj.intValue();
                    num++;
                }
            }
        }

        // output the sorted list
        for (int scan=0; scan < list.length; scan++)
            System.out.println(list[scan]);
    }*/

}

