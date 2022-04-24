public class Main {
    
    public static void Test1(){
        Pipeline paradigmsPipeline = new Pipeline();
        paradigmsPipeline.createPipeLine("example1.txt");
    }
    public static void Test2(){
        Pipeline paradigmsPipeline = new Pipeline();
        paradigmsPipeline.createPipeLine("example2.txt");
    }
    public static void main(String[] args){
        System.out.println("************************************************");
        System.out.println("Informal test 1: example1.txt");
        Test1();
        System.out.println("************************************************");
        System.out.println("Informal test 2: example2.txt");
        Test2();
    }
}
