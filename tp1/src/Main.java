public class Main {
        /*
        1 questions
                - valeur par defaut dans les methodes possible
         */
        public static final String OPTION_DELIMITER = "-";
        public static final String SYMBOL_OPTION = "s";
        public static final String VALUES_OPTION = "v";
        public static final String ORIENTATION_OPTION = "o";

        public static void main(String[] args){

                int vIndex = getOptionIndex(args, VALUES_OPTION);

                if( vIndex < 0){
                        System.err.println(OPTION_DELIMITER+VALUES_OPTION+" not found");
                        System.exit(1);
                }else{
                        int size = 0;
                        int vIndex_temp = vIndex;
                        while(vIndex_temp < args.length && !(args[vIndex_temp].equals(OPTION_DELIMITER+SYMBOL_OPTION)) && !(args[vIndex_temp].equals(OPTION_DELIMITER+ORIENTATION_OPTION))){
                                vIndex_temp++;
                                size++;
                        }
                        if(size == 0){
                                System.err.println("no values");
                                System.exit(2);
                        }
                        String[] tab = new String[size];
                        for(int i = 0 ; i < size ; i++){
                                tab[i] = args[vIndex+i];
                        }

                        int[] values = getIntegerValues(tab);
                        String param_symbole = "*";
                        String param_affichage = "";

                        if(getOptionIndex(args,SYMBOL_OPTION)!=-1){
                                param_symbole = args[getOptionIndex(args,SYMBOL_OPTION)];
                        }

                        int iParam_Orientation = getOptionIndex(args,ORIENTATION_OPTION);
                        if(iParam_Orientation != -1){
                                switch (args[iParam_Orientation]){
                                        case "v":
                                                printVerticalHistogram(values,param_symbole);
                                                break;
                                        case "h":
                                                printHorizontalHistogram(values,param_symbole);
                                                break;
                                }
                        }else{
                                printHorizontalHistogram(values,param_symbole);
                        }
                }
        }

        static int getOptionIndex(String[] args, String option){
                for(int i = 0 ; i < args.length ; i ++){
                        if(args[i].endsWith(OPTION_DELIMITER+option)){
                                return i+1;
                        }
                }
                return -1;
        }

        static int getMin(int[] tab){
                int min = Integer.MAX_VALUE;
                for(int val : tab){
                        if(val < min){
                                min = val;
                        }
                }
                return min;
        }
        static int getMax(int[] tab){
                int max = -Integer.MAX_VALUE;  // CORRIGER
                for(int val : tab){
                        if(val > max){
                                max = val;
                        }
                }
                return max;
        }
        public static void printHorizontalHistogram(int[] values, String param){
                int[] occurences = getOccurences(values);
                int min = getMin(values);
                int max = getMax(values);
                for(int i = min ; i <= max ; i++){
                        System.out.print(i+" ");
                        for(int j = 0 ; j < occurences[i] ; j++){
                                System.out.print(param);
                        }
                        System.out.print("\n");
                }
        }
        public static void printVerticalHistogram(int[] values, String param){
                int[] occurences = getOccurences(values);
                int max_occ = getMax(occurences);
                int min = getMin(values);
                int max = getMax(values);

                for(int i = max_occ ; i > 0 ; i --){
                        for(int j = min ; j <= max ; j++){
                                if(occurences[j] < i){
                                        System.out.print("  ");
                                }else{
                                        System.out.print(" "+param);
                                }
                        }
                        System.out.print("\n");
                }
                System.out.print(" ");
                for(int i = min ; i <= max ; i++){
                        System.out.print(i+" ");
                }

        }
        public static int[] getOccurences(int[] values){
                int[] occ = new int[getMax(values)+1];
                for(int value : values){
                        occ[value]++;
                }
                return occ;
        }
        public static int[] getIntegerValues(String[] args){
                int[] tab = new int[args.length];
                for(int i = 0; i < args.length ; i++){
                     tab[i] = Integer.parseInt(args[i]);
                }
                return tab;
        }
}
