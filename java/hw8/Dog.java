
import java.net.*;  
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Dog {
    
    public String url = "https://raw.githubusercontent.com/JaneClelandHuang/Paradigms2022/main/data/dogs.txt";
    public List<String> dogList = new ArrayList<>();

     private List<String> getUrlData(){
        try{
        URL myurl = new URL(this.url);
        URLConnection urlConnection = myurl.openConnection(); // creating a urlconnection object  
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));  
        String line;  
        
        while ((line = bufferedReader.readLine()) != null){
            this.dogList.add(line);
        }

        }catch(Exception e){
            System.out.print("Error reading from github URL");
        }
        return this.dogList;
    }

    public List<Dogtelligence> buildDogDataset( List<String> dList){
            List<Dogtelligence> dtelligentList = new ArrayList<>();
            for (int i = 0; i < dList.size(); i++){
                String tempstr = dList.get(i);
                Dogtelligence newDog = new Dogtelligence(tempstr);
                dtelligentList.add(newDog);
            }
            return dtelligentList;
    }
    // Unit tests
    public static boolean test1(Dogtelligence d1, Dogtelligence d2){ // test equality
        return ( d1 == d2);
    }

    // test hashcode
    public static boolean test2(Dogtelligence d1, Dogtelligence d2){ // test equality
        return ( d1.hashCode() == d2.hashCode()); 
    }
    public static boolean test3(Dogtelligence d1, Dogtelligence d2){ // test equality
        return ( d1.toString() .equals(d2.toString() )); 
    }
   

    public static void main(String[] args){

        List<String> dList = new ArrayList<>();
        List<Dogtelligence> testDogs = new ArrayList<>();
        Dog myDog = new Dog();
        dList = myDog.getUrlData();
        testDogs = myDog.buildDogDataset( dList);

        Dogtelligence d1 = testDogs.get(0);
        Dogtelligence d2 = testDogs.get(0);
        Dogtelligence d3 = testDogs.get(1);

        if (test1( d1, d2)){
            System.out.println("Dogtelligence 1 is equal to dogtelligence 2");
        } else{
            System.out.println("Dogtelligence 1 is not equal to dogtelligence 2");
        }if (test2(d1, d2)){
            System.out.println("Dogtelligence 1 and 2 have the same hashcode");
        }else{
            System.out.println("Dogtelligence 1 and 2 do not have the same hashcode");
        }if (test3(d1, d2)){
            System.out.println("Dogtelligence 1 and 2 have equal string values");
        }else{
            System.out.println("Dogtelligence 1 and 2 do not have equal string values");
        }
        System.out.println("**********************************************");

        if (test1( d3, d2)){
            System.out.println("Dogtelligence 3 is equal to dogtelligence 2");
        } else{
            System.out.println("Dogtelligence 3 is not equal to dogtelligence 2");
        }if (test2(d3, d2)){
            System.out.println("Dogtelligence 3 and 2 have the same hashcode");
        }else{
            System.out.println("Dogtelligence 3 and 2 do not have the same hashcode");
        }if (test3(d3, d2)){
            System.out.println("Dogtelligence 3 and 2 have equal string values");
        }else{
            System.out.println("Dogtelligence 3 and 2 do not have equal string values");
        }       
    }
}
