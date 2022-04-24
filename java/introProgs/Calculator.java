import java.io.*;
class Calculator{

    private double a;
    private double b;
    private String operator;

    public Calculator( String a, String b, String op){
        this.a = Double.parseDouble( a);
        this.b = Double.parseDouble( b);
        this.operator = op;

    }
    public double calculate(){

        if (this.operator.equals("+")){
            return a + b;
        }else if (this.operator.equals("-")){
            return a - b;
        } else if (this.operator.equals("*")){
            return a * b;
        } else if (this.operator.equals("/")){
            return a / b;
        }
        else{
            System.out.println("Operator does not equal anything in list");
        }
        return -1;
    }

}
