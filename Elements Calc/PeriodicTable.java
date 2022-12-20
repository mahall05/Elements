import java.awt.*;

public class PeriodicTable {
    public Element[] table = new Element[118];
    public double scrolling = 0;

    private static String[] elementNames = {"Hydrogen", "Helium", "Lithium", "Beryllium", "Boron", "Carbon", "Nitrogen", "Oxygen", "Fluorine", "Neon", "Sodium", "Magnesium", "Aluminium", "Silicon", "Phosphorus", "Sulfur", "Chlorine", "Argon", "Potassium", "Calcium", "Scandium", "Titanium", "Vanadium", "Chromium", "Manganese", "Iron", "Cobalt", "Nickel", "Copper", "Zinc", "Gallium", "Germanium", "Arsenic", "Selenium", "Bromine", "Krypton", "Rubidium", "Strontium", "Yttrium", "Zirconium", "Niobium", "Molybdenum", "Technetlum", "Ruthenium", "Rhodium", "Palladium", "Silver", "Cadmium", "Indium", "Tin", "Antimony", "Tellurium", "Iodine", "Xenon", "Causium", "Barium", "Lanthanum", "Cerium", "Praseodymium", "Neodymium", "Promethium", "Samarium", "Europium", "Gadolinium", "Terbium", "Dysprosium", "Holmium", "Erbium", "Thulium", "Ytterbium", "Lutetium", "Hafnium", "Tantalum", "Tungsten", "Rhenium", "Osmium", "Iridum", "Platinum", "Gold", "Mercury", "Thallium", "Lead", "Bismuth", "Polonium", "Astatine", "Radon", "Francium", "Radium", "Actinium", "Throium", "Protactinium", "Uranium", "Neptunium", "Plutonium", "Americium", "Curium", "Berkelium", "Californium", "Einsteinium", "Fermium", "Mendelevium", "Nobelium", "Lawrencium", "Rutherfordium", "Dubnium", "Seaborgium", "Bohrium", "Hassium", "Meitnerium", "Darmstadtium", "Roentgenium", "Copernicium", "Nihonium", "Flerovium", "Mscovium", "Livermorium", "Tennessine", "Oganesson"};
    private static String[] symbols = {"H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al", "Si", "P", "S", "Cl", "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb", "Te", "I", "Xe", "Cs", "Ba", "La", "Ce", "Pr", "Nd", "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn", "Fr", "Ra", "Ac", "Th", "Pa", "U", "Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md", "No", "Lr", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg", "Uub", "Uut", "Uuq", "Uup", "Uuh", "Uus", "Uuo"};
    private static double[] atomMass = {1.007, 4.0026, 6.941, 9.0122, 10.811, 12.011, 14.007, 15.999, 18.998, 20.180, 22.990, 24.305, 26.982, 28.086, 30.974, 32.065, 35.453, 39.948, 39.098, 40.078, 44.956, 47.867, 50.942, 51.996, 54.938, 55.845, 58.933, 58.693, 63.546, 65.39, 69.723, 72.61, 74.922, 78.96, 79.904, 83.80, 85.468, 87.62, 88.906, 91.224, 92.906, 95.94, 98, 101.07, 102.91, 106.42, 107.87, 112.41, 114.82, 118.71, 121.76, 127.60, 126.90, 131.29, 132.91, 137.33, 138.91, 140.12, 140.91, 144.24, 145, 150.36, 151.96, 157.25, 158.93, 162.50, 164.93, 167.26, 168.93, 173.04, 174.97, 178.49, 180.95, 183.84, 186.21, 190.23, 192.22, 195.08, 196.97, 200.59, 204.38, 207.2, 208.98, 209, 210, 222, 223, 226, 227, 232.04, 231.04, 238.03, 237, 244, 243, 247, 247, 251, 252, 257, 258, 259, 262, 261, 262, 266, 264, 269, 268, 271, 272, 277, 284, 289, 288, 292, 291, 294};
    private static int[] neutrons = {0, 2, 4, 5, 6, 6, 7, 8, 10, 10, 12, 12, 14, 14, 16, 16, 18, 22, 20, 20, 24, 26, 28, 28, 30, 30, 32, 31, 35, 35, 39, 41, 42, 45, 45, 48, 48, 50, 50, 51, 52, 54, 55, 57, 58, 60, 61, 64, 66, 69, 71, 76, 74, 77, 78, 81, 82, 82, 82, 84, 84, 88, 89, 93, 94, 97, 98, 99, 100, 103, 104, 106, 108, 110, 111, 114, 115, 117, 118, 121, 123, 125, 126, 125, 125, 136, 136, 138, 138, 142, 140, 146, 144, 150, 148, 151, 150, 153, 153, 157, 157, 157, 159, 157, 157, 157, 157, 157, 159, 171, 162, 165, 173, 175, 174, 177, 177, 176};
    private static double[] electronegetivity = {2.2, 9999, 0.98, 1.57, 2.04, 2.55, 3.04, 3.44, 3.98, 9999, 0.93, 1.31, 1.61, 1.9, 2.19, 2.58, 3.16, 9999, 0.82, 1, 1.36, 1.54, 1.63, 1.66, 1.55, 1.83, 1.88, 1.91, 1.9, 1.65, 1.81, 2.01, 2.18, 2.55, 2.92, 9999, 0.82, 0.95, 1.22, 1.33, 1.6, 2.16, 2.10, 2.2, 2.28, 2.20, 1.93, 1.69, 1.78, 1.96, 2.05, 2.1, 2.66, 2.60, 0.79, 0.89, 1.10, 1.12, 1.13, 1.14, 9999, 1.17, 9999, 1.20, 9999, 1.22, 1.23, 1.24, 1.25, 9999, 1.0, 1.3, 1.5, 1.7, 1.9, 2.2, 2.2, 2.2, 2.4, 1.9, 1.8, 1.8, 1.9, 2.0, 2.2, 9999, 0.7, 0.9, 1.1, 1.3, 1.5, 1.7, 1.3, 1.3, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999};
    private static double[] meltingPts = {-259.16, 9999, 180.5, 1287, 2077, 9999, -210.0, -218.79, -219.67, -248.59, 97.794, 650, 660.323, 1414, 44.15, 95.2, -101.5, -189.34, 63.5, 842, 1541, 1670, 1910, 1907, 1246, 1538, 1495, 1455, 1084.62, 419.527, 29.7646, 938.25, 817, 220.8, -7.2, -157.37, 39.30, 777, 1522, 1854, 2477, 2622, 2157, 2333, 1963, 1554.8, 961.78, 321.069, 156.6, 231.928, 630.628, 449.51, 113.7, -111.75, 28.5, 727, 920, 799, 931, 1016, 1042, 1072, 822, 1313, 1359, 1412, 1472, 1529, 1545, 824, 1663, 2233, 3017, 3414, 3185, 3033, 2446, 1768.2, 1064.18, -38.829, 304, 327.462, 271.406, 254, 302, -71, 21, 696, 1050, 1750, 1572, 1135, 644, 640, 1176, 1345, 986, 900, 860, 1527, 827, 827, 1627, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999};
    public static double[] boilingPts = {-252.819, -268.928, 1342, 2468, 4000, 3825, -195.795, -182.962, -188.12, -246.046, 882.940, 1090, 2519, 3265, 280.5, 444.61, -34.04, -185.848, 759, 1484, 2836, 3287, 3407, 2671, 2061, 2861, 2927, 2913, 2560, 907, 2229, 2833, 616, 685, 58.8, -153.415, 688, 1377, 3345, 4406, 4741, 4639, 4262, 4147, 3695, 2963, 2162, 767, 2072, 2586, 1587, 988, 184.4,-108.099, 671, 1845, 3464, 3443, 3520, 3074, 3000, 1794, 1529, 3273, 3230, 2567, 2700, 2868, 1950, 1196, 3402, 4600, 5455, 5555, 5590, 5008, 4428, 3825, 2836, 356.619, 1473, 1749, 1564, 962, 9999, -61.47, 9999, 9999, 3200, 4785, 9999, 4131, 3902, 3228, 2011, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999}; // Got through Oxygen
    private static int[] rows = {1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
    private static int[] columns = {1, 19, 1, 2, 14, 15, 16, 17, 18, 19, 1, 2, 14, 15, 16, 17, 18, 19, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
    
    public PeriodicTable(){
        buildTable();
    }

    public void render(Graphics g){
        for(int i = 0; i < table.length; i++){
            table[i].render(g);
        }
    }

    public void tick(){
        for(int i = 0; i < table.length; i++){
            table[i].tick(scrolling);
        }
        scrolling = 0;
    }
    
    public void buildTable(){
        for(int i = 0; i < table.length; i++){
            table[i] = new Element(rows[i], columns[i], (i+1), symbols[i], elementNames[i], atomMass[i], neutrons[i], (i+1), electronegetivity[i], meltingPts[i], boilingPts[i]);
        }
    }

    public void printTable(){
        for(int i = 0; i < table.length; i++){
            System.out.println((i+1) + ": ");
            System.out.println("\tElement: " + table[i].name);
            System.out.println("\tSymbol: " + table[i].symbol);
            System.out.println("\tAtomic Mass: " + table[i].weight);
            System.out.println("\tProtons: " + table[i].protons);
            System.out.println("\tNeutrons: " + table[i].neutrons);
            System.out.println("\tElectronegetivity: " + table[i].electronegetivity);
            System.out.println("\tMelting Point: " + table[i].meltingPt);
            System.out.println("\tBoiling Point: " + table[i].boilingPt);
        }
    }
}
