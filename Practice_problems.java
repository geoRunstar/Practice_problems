/**
 * Created by geordie on 11/2/18.
 */
public class Practice_problems {

    public void giveMePowerSet(int [] a){

        String sttr = "";
        int k =0;
         powerSet(sttr,a,k);
        System.out.print("{} \n");
    }
    public String powerSet(String s, int[] a,int k){
        if(k==a.length) {
            return s;
        }
        String sub = s +a[k];
        System.out.print("{"+ sub + "}");
        powerSet(s,a,k+1);

        return powerSet(sub+",",a,k+1);

    }
    public int num_of_ways(String s,int count){
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

    public static void main(String[] args ){
        Practice_problems prac = new Practice_problems();
        int[] a=new int[]{1,2,3};
        prac.giveMePowerSet(a);
        String nums = "2612";
        System.out.println("num of ways = " + prac.num_of_ways(nums,0));
       System.out.println(prac.convertRoman(3));

    }

}