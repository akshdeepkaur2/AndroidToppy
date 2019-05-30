package com.akshdeep.tappyproject2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Player {
    int xPosition;
    int yPosition;
    int direction = -1;              // -1 = not moving, 0 = down, 1 = up
    Bitmap playerImage;

    private Rect hitBox;

    public Player(Context context, int x, int y) {
        this.playerImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.player_ship);
        this.xPosition = x;
        this.yPosition = y;
        this.hitBox = new Rect(this.xPosition, this.yPosition, this.xPosition + this.playerImage.getWidth(), this.yPosition + this.playerImage.getHeight());

    }

    public void updatePlayerPosition() {
        if (this.direction == 0) {
            // move down
            this.yPosition = this.yPosition - 15;
        }
        else if (this.direction == 1) {
            // move up
            this.yPosition = this.yPosition + 15;
        }

        // update the position of the hitbox
        this.updateHitbox();
    }

    public void updateHitbox() {
        // update the position of the hitbox
        this.hitBox.top = this.yPosition;
        this.hitBox.left = this.xPosition;
        this.hitBox.right = this.xPosition + this.playerImage.getWidth();
        this.hitBox.bottom = this.yPosition + this.playerImage.getHeight();
    }

    public Rect getHitbox() {
        return this.hitBox;
    }

    public void setXPosition(int x) {
        this.xPosition = x;
        this.updateHitbox();
    }
    public void setYPosition(int y) {
        this.yPosition = y;
        this.updateHitbox();
    }
    public int getXPosition() {
        return this.xPosition;
    }
    public int getYPosition() {
        return this.yPosition;
    }

    /**
     * Sets the direction of the player
     * @param i     0 = down, 1 = up
     */
    public void setDirection(int i) {
        this.direction = i;
    }
    public Bitmap getBitmap() {
        return this.playerImage;
    }

}
