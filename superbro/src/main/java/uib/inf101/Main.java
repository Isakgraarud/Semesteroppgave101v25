package uib.inf101;

import javax.swing.JFrame;

public class Main {

    static String title = "SuperBro";

    public static void main(String[] args) {  
        JFrame frame = new JFrame(title);
        CustomCanvas canvas = new CustomCanvas();
        
        frame.setSize(800, 600);
        frame.add(canvas);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}