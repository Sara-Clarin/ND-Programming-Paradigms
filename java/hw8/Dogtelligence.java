
import java.net.*;  
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Dogtelligence {
    protected String dogBreed;
    protected String category;
    protected String description;
    protected double intelligence;
    protected int LB_obey;
    protected int HB_obey;

    // No-arg constructor
    public Dogtelligence(){

    }
    public  Dogtelligence(String Doglist){    // create a dog --> parameterized constructor
       
            String []token = Doglist.split(",");
            this.dogBreed = token[0];         
            this.category = token[1];
            this.description = token[2];          
            this.intelligence = Double.parseDouble( token[3].substring(1, token[3].length() - 1));
            this.LB_obey     = Integer.parseInt(token[4].substring(1, token[4].length() - 1) );
            this.HB_obey     = Integer.parseInt(token[5].substring(1, token[5].length() -1) );
    };

    // Equals function
    @Override
    public boolean equals( Object other){
        if (this == other) return true;
        if (other == null) return false;
        if (getClass() != other.getClass()) return false;

        Dogtelligence dt = (Dogtelligence) other;
            return (dt.dogBreed == this.dogBreed 
                && dt.category == this.category
                && dt.intelligence == this.intelligence
                && dt.HB_obey == this.HB_obey
                && dt.LB_obey == this.LB_obey );
    }
    // HashCode function
    @Override
    public int hashCode(){
        return (this.dogBreed + this.category + this.description).hashCode();
    }

    // String function
    @Override
    public String toString(){
        String rtStr = this.dogBreed + " " + this.category + " " + this.description + " " + String.valueOf(this.intelligence ) + " " + String.valueOf(this.LB_obey) + " " + String.valueOf(this.HB_obey);
    
        return rtStr;
    }  
}
