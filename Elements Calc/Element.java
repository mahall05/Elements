import java.awt.*;

import javax.swing.JLabel;

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

    public int row;
    public int column;

    public int posX;
    public int posY;

    public int width = 76;
    public int height = 95;

    public Element(int row, int column, int atomicNum, String symbol, String name, double weight, int neutrons, int protons, double electronegetivity, double meltingPt, double boilingPt){
        this.atomicNum = atomicNum;
        this.symbol = symbol;
        this.name = name;
        this.weight = weight;
        this.neutrons = neutrons;
        this.protons = protons;
        this.electronegetivity = electronegetivity;
        this.meltingPt = meltingPt;
        this.boilingPt = boilingPt;

        this.column = column;
        this.row = row;

        posX = 20+width*(this.column-1);
        posY = 50+height*(this.row-1);
    }

    public void render(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(posX, posY, width, height);

        g.setColor(Color.black);
        g.drawRect(posX, posY, width, height);

        g.setColor(Color.BLACK);
        g.drawString(name, posX+(30-(4*(name.length()-3))), posY+15);
        g.drawString(weight+"", posX+((width/2)-3*((weight+"").length()-1)), posY+90);

        g.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, 16));
        g.drawString(atomicNum+"", posX+((width/2)-4*((atomicNum+"").length()-1)), posY+32);

        g.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, 32));
        g.drawString(symbol, posX+((width/2)-(12*((symbol+"").length()-1))), posY+65);

        g.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, 12)); // Reset font back to normal

    }

    public void tick(double movement){
        posY -= movement*50;
    }

    public void move(int x, int y){
        // TODO MAX AND MIN SCROLLING
        posX += x;
        posY += y;
    }
}
