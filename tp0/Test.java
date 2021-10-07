public class Test {
    public static void main(String[] args) {
        System.out.println("My first program in Java !");

       // for(int i = 0 ; i < args.length ; i++){
       //     System.out.print(args[i]+ "\n");
       // }
       for(String arg : args){
           System.out.print(arg+ "\n");
       }

    }
}