package com.akshdeep.tappyproject2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Enemy {
    int xPosition;
    int yPosition;
    int direction;
    Bitmap image;

    private Rect hitBox;

    public Enemy(Context context, int x, int y) {
        this.image = BitmapFactory.decodeResource(context.getResources(), R.drawable.alien_ship2);
        this.xPosition = x;
        this.yPosition = y;

        this.hitBox = new Rect(this.xPosition, this.yPosition, this.xPosition + this.image.getWidth(), this.yPosition + this.image.getHeight());
    }

    public void updateEnemyPosition() {
        this.xPosition = this.xPosition - 15;

        // update the position of the hitbox
        this.hitBox.left = this.xPosition;
        this.hitBox.right = this.xPosition + this.image.getWidth();
        this.updateHitbox();
    }

    public void updateHitbox() {
        // update the position of the hitbox
        this.hitBox.top = this.yPosition;
        this.hitBox.left = this.xPosition;
        this.hitBox.right = this.xPosition + this.image.getWidth();
        this.hitBox.bottom = this.yPosition + this.image.getHeight();
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

    public Bitmap getBitmap() {
        return this.image;
    }

}
