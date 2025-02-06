package uib.inf101;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import uib.inf101.Player.Player;

public class CustomCanvas extends Canvas {
    private Player player;

    public CustomCanvas() {
        setBackground(Color.BLACK); // Change the background color
        player = new Player(100, 300, 50); // Initial position and size of the player

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_SPACE -> player.jump();
                    case KeyEvent.VK_LEFT -> player.isMovingLeft = true;
                    case KeyEvent.VK_RIGHT -> player.isMovingRight = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT -> player.isMovingLeft = false;
                    case KeyEvent.VK_RIGHT -> player.isMovingRight = false;
                }
            }
        });

        setFocusable(true);

        Timer timer = new Timer(16, e -> {
            player.update();
            repaint();
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        player.draw(g);
    }
}