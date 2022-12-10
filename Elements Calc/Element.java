public class Element {
    public int atomicNum;
    public String symbol;
    public String name;
    public double weight;
    public int neutrons;
    public int protons;
    public double electronegetivity;
    public double meltingPt;
    public double boilingPt;

    public Element(int atomicNum, String symbol, String name, double weight, int neutrons, int protons, double electronegetivity, double meltingPt, double boilingPt){
        this.atomicNum = atomicNum;
        this.symbol = symbol;
        this.name = name;
        this.weight = weight;
        this.neutrons = neutrons;
        this.protons = protons;
        this.electronegetivity = electronegetivity;
        this.meltingPt = meltingPt;
        this.boilingPt = boilingPt;
    }
}
