import java.lang.Math;
import java.util.HashMap;

public class BookSales {
    

    public float calculateBest(int numbooks){
        
        int startval = 5;
        HashMap <Integer, Double> BoxPrices = new HashMap<Integer, Double>();
        HashMap <Integer, String> SetPrices = new HashMap<Integer, String>();

        BoxPrices.put( 0,(Double)0.0);BoxPrices.put(1, 8.0);BoxPrices.put(2, 15.8); BoxPrices.put(3, 21.6); BoxPrices.put(4, 25.6); BoxPrices.put(5, 30.0);
        Float bestPrice = (float) 10000;
        int largestOfSet = 0;
        String tempStr = "";
        // find largest book set we could organize
        for (int i = 5; i > 0; i--){
            if ((Math.floor( numbooks/i ) > 0)){
                startval = i;
                break;
            }
        }

        float tempPrice = 0; int nbooks = numbooks;
        int quantity; int currentSetSize;
        for (int i = startval; i > 0; i--){
            // do greedy alg from here
            tempPrice = 0; nbooks = numbooks;  quantity = 0;
            currentSetSize = i; tempStr = "";
            while(nbooks > 0 ){
                quantity = nbooks / currentSetSize;  // number of size currentSetSize sets to buy
                nbooks  -= quantity * currentSetSize;
                tempPrice += quantity * BoxPrices.get(currentSetSize);
                tempStr += " " + String.valueOf(quantity) + " * " + String.valueOf(currentSetSize) + " books ,";
                currentSetSize--;
            }
        
            SetPrices.put(i, tempStr);   // we could also store a set of the values here
            if (tempPrice < bestPrice ){
                bestPrice = tempPrice;
                largestOfSet = i;
            }
        }
        System.out.printf("The total price is %f for a shopping cart composed of: %s\n", bestPrice, SetPrices.get(largestOfSet));
        return bestPrice;
    }

    public static void main(String[] args){
        int test1 = 8;
        int test2 = 16;
        int test3 = 12;
        int test4 = 34;

        BookSales bs = new BookSales();
        System.out.printf("Buying %d books\n", test1); bs.calculateBest(test1); System.out.println("");
        System.out.printf("Buying %d books\n", test2);bs.calculateBest(test2); System.out.println("");
        System.out.printf("Buying %d books\n", test3);bs.calculateBest(test3); System.out.println("");
        System.out.printf("Buying %d books\n", test4);bs.calculateBest(test4); System.out.println("");
    }
}
