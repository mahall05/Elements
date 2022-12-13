import java.util.Scanner;

public class ElementsCalc{
    private static PeriodicTable table = new PeriodicTable();
    private static Scanner in = new Scanner(System.in);

    public ElementsCalc(){
        welcomeMenu();
    }

    
    private double findNumber(String in){
        StringBuilder number = new StringBuilder();
        for(int i = 0; i < in.length(); i++){
            if(Character.isDigit(in.charAt(i)) || in.charAt(i) == '-' || in.charAt(i) == '.'){
                number.append(in.charAt(i));
            }
        }
        return Double.parseDouble(number.toString());
    }

    private String findSymbol(String in){
        StringBuilder symbol = new StringBuilder();
        for(int i = 0; i < in.length(); i++){
            if(Character.isAlphabetic(in.charAt(i))){
                symbol.append(in.charAt(i));
            }
        }
        return symbol.toString();
    }

    private void empiricalFormula(){
        // Given a percentage of the composition by mass
        // Enter number or symbol first, but either way need both
        // Repeat entering elements until user specifies they're done
        // Calculate
        // Given mass/molar mass = how many moles of element are present
        // Divide by smallest number to get it to 1
        // Round to nearest .75
        // If required, multiply to get a whole number

        boolean quit = false;
        while(!quit){
            System.out.print("Enter grams of first element (or 999 to quit) >> ");
            int numElements = 1;
            double[] masses = new double[1];
            String[] symbols = new String[1];
            String input = in.nextLine();

            masses[0] = findNumber(input);
            symbols[0] = findSymbol(input);

            if(masses[0] == 666){
                // Print info
            }else if(masses[0] == 999){
                quit = true;
            }else{
                boolean done = false;
                while(!done){
                    System.out.print("Enter additional element (or \"done\" if done) >> ");
                    input = in.nextLine();

                    if(input.equals("done")){
                        done = true;
                    }else{
                        numElements++;
                        double[] oldMasses = masses;
                        String[] oldSymbols = symbols;
                        masses = new double[numElements];
                        symbols = new String[numElements];
                        for(int i = 0; i < numElements-1; i++){
                            masses[i] = oldMasses[i];
                            symbols[i] = oldSymbols[i];
                        }
                        masses[numElements-1] = findNumber(input);
                        symbols[numElements-1] = findSymbol(input);
                    }
                }
                // Done entering elements, arrays contain all elements
                double sum = 0;
                for(int i = 0; i < masses.length; i++){
                    sum += masses[i];
                }
                for(int i = 0; i < masses.length; i++){
                    masses[i] = masses[i]/sum*100;
                }

                double[] moles = new double[masses.length];

                for(int i = 0; i < masses.length; i++){
                    moles[i] = masses[i]/locateElement(symbols[i]).weight;
                }

                double[] sortedArray = bubbleSortAscending(moles); // Why tf does this sort the moles array too

                for(int i = 0; i < moles.length; i++){
                    moles[i] = moles[i]/sortedArray[0];
                }

                for(int i = 0; i < moles.length; i++){
                    if(moles[i] % (int) moles[i] > 0.85){
                        moles[i] = Math.round(Float.parseFloat(moles[i]+""));
                    }else if(moles[i] % (int) moles[i] < .15){
                        moles[i] = (int) moles[i];
                    }
                }

                {
                    boolean good = false;
                    int i = 0;
                    while(!good){
                        i++;
                        for(int j = 0; j < moles.length; j++){
                            if((moles[j]*i) % 1 == 0){
                                good = true;
                            }else{
                                good = false;
                                j = moles.length+10;
                            }
                        }
                    }

                    for(int j = 0; j < moles.length; j++){
                        moles[j] = moles[j]*i;
                    }
                }

                for(int i = 0; i < moles.length; i++){
                    System.out.print(symbols[i] + ((int) moles[i] == 1 ? "" : (int) moles[i]));
                }

                System.out.println();



                // Find the smallest number (bubble sort) - done
                // Divide all by that smallest number - done
                // Round to the nearest .75
                // Multiply all numbers by one number to get all numbers to whole numbers
                // Print out empirical formula (int hill system order) with the numbers found
            }
        }
    }

    private double[] bubbleSortAscending(double[] array){
        double[] arr = new double[array.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = array[i];
        }
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    // swap arr[j+1] and arr[j]
                    double temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    private void welcomeMenu(){
        boolean quit = false;
        while(!quit){
            System.out.println("*********************************");
            System.out.println("Welcome - Enter desired action:");
            System.out.println("\t1: Mass Calculator");
            System.out.println("\t2: Element Information");
            System.out.println("\t3: Empirical Formula");
            System.out.println("\t666: Information");
            System.out.println("\t999: Quit");
            System.out.print(" >> ");
            int choice = Integer.parseInt(in.nextLine());

            switch(choice){
                case(1):
                    massCalculator();
                    break;
                case(2):
                    elementInformation();
                    break;
                case(3):
                    empiricalFormula();
                    break;
                case(666):
                    break;
                case(999):
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
        }
    }

    private void massCalculator(){
        boolean quit = false;
        while(!quit){
            System.out.println("\n**********************************");
            System.out.print("Enter chemical formula (or 999 to quit) >> ");
            String input = in.nextLine();

            if(!input.equals("999")){
                System.out.println("Molar Mass >> " + calcMass(input) + "g");
            }else{
                quit = true;
            }
        }
    }

    private void elementInformation(){
        boolean quit = false;
        while(!quit){
            System.out.println("\n**********************************");
            System.out.print("Enter element (or 999 to quit) >> ");
            String input = in.nextLine();

            if(!input.equals("999")){
                Element element;
                try{
                    element = locateElement(Integer.parseInt(input));
                }catch(NumberFormatException e){
                    element = locateElement(input);
                }

                try{
                    System.out.println("Atomic Number: " + element.atomicNum);
                    System.out.println("\tSymbol: " + element.symbol);
                    System.out.println("\tName: " + element.name);
                    System.out.println("\tAtomic Weight: " + element.weight);
                    System.out.println("\tProtons: " + element.protons);
                    System.out.println("\tNeutrons: " + element.neutrons);
                    System.out.println("\tMelting Point: " + (element.meltingPt == 9999 ? "N/A" : element.meltingPt));
                    System.out.println("\tBoiling Point: " + (element.boilingPt == 9999 ? "N/A" : element.boilingPt));
                    System.out.println("\tElectronegetivity: " + element.electronegetivity);
                    System.out.println((element.name.substring(element.name.length()-3).equals("ine") || element.name.substring(element.name.length()-3).equals("gen")) ? "\tDiatomic" : "\tMonatomic");
                }catch(NullPointerException e){
                    System.out.println("Invalid choice, try again");
                }
            }else{
                quit = true;
            }

        }
    }

    private Element locateElement(String element){
        for(int i = 0; i < table.table.length; i++){
            if(table.table[i].name.equalsIgnoreCase(element) || table.table[i].symbol.equals(element)){
                return table.table[i];
            }
        }
        return null;
    }
    private Element locateElement(int atomicNum){
        if(atomicNum < 119){
            return table.table[atomicNum-1];
        }else{
            return null;
        }
    }

    public static void main(String[] args){
        new ElementsCalc();
    }

    private double calcMass(String formula){
        double totalMass = 0;
        Element[] elements = parseElements(formula);

        for(int i = 0; i < elements.length; i++){
            totalMass += elements[i].weight;
        }

        return totalMass;
    }

    private Element[] parseElements(String formula){
        int numElements = 0;
        int[] locations = new int[100];

        for(int i = 0; i < locations.length; i++){
            locations[i] = 999;
        }

        int counter = 0;
        for(int i = 0; i < formula.length(); i++){
            if(Character.isUpperCase(formula.charAt(i))){
                locations[counter] = i;
                numElements++;
                counter++;
            }else if(Character.isDigit(formula.charAt(i))){
                numElements += (Integer.parseInt(formula.charAt(i)+"")-1);
            }
        }
        locations[counter] = formula.length();

        Element[] elements = new Element[numElements];
        int position = 0;

        for(int i = 0; locations[i] < formula.length(); i++){
            String element = "";
            int multiplier = 1;

            for(int j = locations[i]; j < locations[i+1]; j++){
                if(!Character.isDigit(formula.charAt(j))){ // Character isn't a digit
                    element += formula.charAt(j);
                }else{ // Character is a digit
                    multiplier = Integer.parseInt(formula.charAt(j)+"");
                    j = locations[i+1]+100;
                }
            }

            for(int j = 0; j < multiplier; j++){
                // Figure out what element it is and put them into the elements array
                for(int n = 0; n < table.table.length; n++){
                    if(element.equals(table.table[n].symbol)){
                        elements[position] = table.table[n];
                        position++;
                        n = table.table.length+100;
                    }
                }
            }
        }

        return elements;
    }
}