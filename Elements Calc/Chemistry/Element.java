package Chemistry;
import java.awt.*;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

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

    private Color activeColor = Color.WHITE;
    private boolean clicked = false;

    private int mouseOffsetX = -7;
    private int mouseOffsetY = -30;

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
        g.setColor(activeColor);
        g.fillRect(posX, posY, width, height);

        g.setColor(Color.BLACK);
        g.drawRect(posX, posY, width, height);


        // TODO add variables here to easily change this
        g.setColor(Color.BLUE);
        g.drawString(name, posX+(30-(4*(name.length()-3))), posY+15);
        g.drawString(weight+"", posX+((width/2)-3*((weight+"").length()-1)), posY+90);

        g.setColor(Color.RED);
        g.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, 16));
        g.drawString(atomicNum+"", posX+((width/2)-4*((atomicNum+"").length()-1)), posY+32);

        g.setColor(Color.BLACK);
        g.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, 32));
        g.drawString(symbol, posX+((width/2-10)-(10*((symbol+"").length()-1))), posY+65);

        g.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, 12)); // Reset font back to normal

    }

    public void tick(){
        if(clicked){
            activeColor = Color.GRAY;
        }else{
            activeColor = Color.WHITE;
        }
    }

    public void click(){
        clicked = true;

        // OPEN POP-UP WINDOW
        //JOptionPane.showInputDialog(null, "This is the message", "This is the default text");

        JOptionPane.showMessageDialog(null, "\t"+name+"\nAtomic Number: " + atomicNum + "\nSymbol: " + symbol + "\nAtomic Weight: " + weight + "\nMelting Point: " + meltingPt + "\nBoiling Point: " + boilingPt);
        

        clicked = false;
    }

    public void scroll(double amount){
        // TODO MAX AND MIN SCROLLING
        posY += amount;
    }

    public boolean checkWithinButton(Point point){
        if(point.getX()+mouseOffsetX >= posX && point.getX()+mouseOffsetX <= posX+width-1 && point.getY()+mouseOffsetY >= posY && point.getY()+mouseOffsetY <= posY+height-1){
            return true;
        }else{
            return false;
        }
    }
}
