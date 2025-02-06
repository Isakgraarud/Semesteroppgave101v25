package uib.inf101.Player;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
    public int x;
    private int y;
    private final int size;
    private int yVelocity;
    private boolean isJumping;
    public boolean isMovingLeft;
    public boolean isMovingRight;

    private static final int GRAVITY = 1;
    private static final int JUMP_STRENGTH = -15;

    public Player(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.yVelocity = 0;
        this.isJumping = false;
    }

    public void update() {
        if (isJumping) {
            yVelocity += GRAVITY;
            y += yVelocity;
            if (y >= 300) { // Ground level
                y = 300;
                yVelocity = 0;
                isJumping = false;
            }
        }
        if (isMovingLeft) {
            x -= 5;
        }
        if (isMovingRight) {
            x += 5;
        }
    }

    public void jump() {
        if (!isJumping) {
            isJumping = true;
            yVelocity = JUMP_STRENGTH;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, size, size);
    }
}