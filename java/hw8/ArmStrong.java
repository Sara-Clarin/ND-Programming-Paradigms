
import java.lang.Math;

public class ArmStrong{

    protected int digits;
    protected String digitString;
    protected int tempSum;

    public void calculate(double range){
        for (int num = 0; num < range; num++){
            digitString = String.valueOf(num);

            digits = digitString.length();
            tempSum = 0;
            for (int i = 0; i < digits; i++){
                try{
                    tempSum += Math.pow(Character.getNumericValue(digitString.charAt(i)),digits);
                } catch(NumberFormatException nfe){
                    System.out.print("Number format error");
                }

            }
        if (tempSum == num){
            System.out.printf("%d ", num);
            }
        }
    }
    public static void main(String args[]){

        ArmStrong armstrongCalc = new ArmStrong();
        armstrongCalc.calculate(2000); 
    }
}