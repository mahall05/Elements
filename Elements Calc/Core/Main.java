package Core;
import java.util.Scanner;

import Chemistry.Element;
import Chemistry.ImageLoader;
import Chemistry.PeriodicTable;
import InputOutput.Window;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main extends Canvas implements Runnable{
    public PeriodicTable table = new PeriodicTable();
    private Scanner in = new Scanner(System.in);

    private static Window window;

    private Thread thread;
    private boolean running = false;

    private void tick(){
        table.tick();
    }

    private void render(int frames){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        /* RENDERING */
        g.setColor(new Color(255, 229, 180));
        g.fillRect(0, 0, Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT-200);

        for(int i = 0; i < table.table.length; i++){
            table.render(g);
        }

        g.setColor(Color.BLACK);
        g.fillRect(0, Window.WINDOW_WIDTH-200, Window.WINDOW_HEIGHT, 300);

        g.drawString(frames+"", 10, 10);

        /* END RENDERING */

        g.dispose();
        bs.show();
    }

    public Main(){
        ImageLoader.loadImages();
        window = new Window("Chemistry", this);
        //welcomeMenu();
    }

    public void moveTable(double scroll){
        table.scrolling -= scroll;
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running){
                render(frames);
            }
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                frames = 0;
            }
        }
    }

    public static void main(String[] args){
        new Main();
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