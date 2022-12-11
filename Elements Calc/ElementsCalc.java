import java.util.Scanner;

public class ElementsCalc{
    private static PeriodicTable table = new PeriodicTable();
    private static Scanner in = new Scanner(System.in);

    public ElementsCalc(){
        welcomeMenu();
    }

    private void welcomeMenu(){
        boolean quit = false;
        while(!quit){
            System.out.println("*********************************");
            System.out.println("Welcome - Enter desired action:");
            System.out.println("\t1: Mass Calculator");
            System.out.println("\t2: Element Information");
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