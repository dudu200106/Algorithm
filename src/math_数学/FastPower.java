package math_数学;

public class FastPower {
    public static int fastPower(int base, int power){
        int answer=1;
        while(power>1){
            if(power%2==1){
                answer=answer*base;
                power-=1;
            }
            power*=0.5;
            base*=base;
            answer=(int)(Math.pow(base,power));
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(fastPower(9,5));
    }
}
