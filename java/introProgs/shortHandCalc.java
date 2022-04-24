public class shortHandCalc {
    private String str;

    public shortHandCalc( String str){
        this.str = str;
    }

    public String toShortHand(){
        String outputstr = "";

        int i = 0; int j = 0;
        char c = this.str.charAt(0);
        while (i < this.str.length()  ){
            j = i + 1;
            if ( j == this.str.length() ){
                outputstr = outputstr + this.str.charAt(i);
                break;
            }
            while ( ( Character.compare(this.str.charAt(i), this.str.charAt(j)) ) == 0 ){  // check for right equals
                j += 1;
                if ( j == this.str.length() ){
                    break;
                }
            }
            outputstr = outputstr + this.str.charAt(i);
            if (j > i + 1){
                outputstr = outputstr + "*" + Integer.toString(j - i);
            }
            i = j;
        }
        return outputstr;
    }
}

