public class FizzBuzz {
    
    protected int range;

    public void fizzbuzz( int range){

        for (int i = 1; i < range; i++){
            System.out.printf("%d : ", i);
            if ( (i%5) == 0 && i%3 == 0){
                System.out.println("FizzBuzz");
            }else if (i%5 == 0){
                System.out.println("Buzz");
            }else if (i % 3 == 0){
                System.out.println("Fizz");
            }else{
                System.out.println();
            }
        }
    }
    public static void main(String [] args){
        FizzBuzz fizzbuzz1 = new FizzBuzz( );
        fizzbuzz1.fizzbuzz( 100);

    }
}
