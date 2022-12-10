import java.util.Scanner;

public class ElementsCalc{
    private static PeriodicTable table = new PeriodicTable();
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("Input formula >> ");
        System.out.println(calcMass(in.nextLine()));
    }

    private static double calcMass(String formula){
        double totalMass = 0;
        Element[] elements = parseElements(formula);

        for(int i = 0; i < elements.length; i++){
            totalMass += elements[i].weight;
        }

        return totalMass;
    }

    private static Element[] parseElements(String formula){
        int numElements = 0;
        int[] positions = new int[100];
        for(int i = 0; i < formula.length(); i++){
            if(Character.isUpperCase(formula.charAt(i))){
                numElements++;
                positions[numElements-1] = i;
            }else if(Character.isDigit(formula.charAt(i))){
                numElements += (Integer.parseInt(formula.charAt(i)+"")-1);
            }
        }
        positions[numElements] = formula.length();

        Element[] elements = new Element[numElements];

        for(int i = 0; i < elements.length; i++){
            String unrefinedString = formula.substring(positions[i], positions[i+1]);
            String symbol = "";
            for(int j = 0; j < unrefinedString.length(); j++){
                if(Character.isAlphabetic(unrefinedString.charAt(j)))
                    symbol += unrefinedString.charAt(j);
            }

            for(int j = 0; j < table.table.length; j++){
                if(table.table[j].symbol.equals(symbol)){
                    int num = 1;
                    for(int n = i; n < i+1; n++){
                        if(Character.isDigit(formula.charAt(n))){
                            num = Integer.parseInt(formula.charAt(n)+"");
                        }
                    }
                    for(int n = 0; n < num; n++){
                        elements[i] = table.table[j];
                    }
                }
            }
        }

        return elements;
    }
}