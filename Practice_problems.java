/**
 * Created by geordie on 11/2/18.
 */
 import java.util.Arrays;
public class Practice_problems {
  public void findInverse(int x, int y){
       int c =1;
       int d=1;
       int a= y;
       int b= x;
       while( (b-a)!= 1){
           a = y *c;
           while(b<a){
               d++;
               b = x *d;
               if(d>y){
                   System.out.println("DNE");
                   return;}
           }
           c++;
       }

       System.out.println(" inverse of " +x + " in "+ y+ " is "+ d );
   }
    public void giveMePowerSet(int [] a){// returns the power set of an array of unique integers//

        String sttr = "";
        int k =0;
         powerSet(sttr,a,k);
        System.out.print("{} \n");
    }
    public String powerSet(String s, int[] a,int k){//creates the power set//
        if(k==a.length) {
            return s;
        }
        String sub = s +a[k];
        System.out.print("{"+ sub + "}");
        powerSet(s,a,k+1);

        return powerSet(sub+",",a,k+1);

    }
    public int num_of_ways(String s,int count){// this is the number of ways a integer
      //can represent a string of letters 1=a,2=b,12=l so "12" can has "ab" or "l" so two ways it can be represented//
        if(s.equals(""))
            return 1;
        if(s.charAt(0)=='0')
            return 0;
        if(is_pair(s))
            count += num_of_ways(s.substring(2,s.length()),count) + num_of_ways(s.substring(1,s.length()),count);
        else
            count += num_of_ways(s.substring(1,s.length()),count);

        return count ;

    }
    public boolean is_pair(String s){
        if(s.length()>1){
            int a = Integer.parseInt(s.substring(0,2));
            return a>10 && a<27;}
        return false;

    }

    public String convertRoman(int num){

        String ans = "";
        while(num >0){
            if(num >= 1000){
                ans += "M";
                num-=1000;
            }
            else if(num>=900) {
                ans += "CM";
                num-=900;
            }
            else if(num>=500) {
                ans += "D";
                num-=500;
            }else if(num>=400) {
                ans += "CD";
                num-=400;
            }else if(num>=100) {
                ans += "C";
                num-=100;
            }else if(num>=90) {
                ans += "XC";
                num-=90;
            }else if(num>=50) {
                ans += "L";
                num-=50;
            }else if(num>=40) {
                ans += "XL";
                num-=40;
            }else if(num>=10) {
                ans += "X";
                num-=10;
            }else if(num>=9) {
                ans += "IX";
                num-=9;
            }else if(num>=5) {
                ans += "V";
                num-=5;
            }else if(num>=4) {
                ans += "IV";
                num-=4;
            }else if(num>=1) {
                ans += "I";
                num-=1;
            }

        }


        return ans;
    }
    /*Given an array of integers, return a new array
      such that each element at index i of the new array is the
       product of all the numbers in the original array except the one at i.
       */
      public int[] sumArray(int[] nums){
          int[] numsCopy=nums.clone(); // this is done so that numsCopy points to a
          // different array that is a copy, so changes arent made to both arrays.
          for(int i = 0; i<nums.length;i++){
              nums[i]=1;
              for(int j =0; j<nums.length;j++){
                  if(i!=j)
                  nums[i]*=numsCopy[j];

              }

          }

          return nums;
      }

    public static void main(String[] args ){
        Practice_problems prac = new Practice_problems();
        int[] a=new int[]{1,2,3};
        prac.giveMePowerSet(a);
        String nums = "2612";
        System.out.println("num of ways = " + prac.num_of_ways(nums,0));
       System.out.println(prac.convertRoman(3));
       prac.findInverse(11,14);
      prac.findInverse(7,10);
      System.out.print(Arrays.toString(prac.sumArray(a)));
    }

}
