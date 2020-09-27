package com.lme.robot.model;

import com.lme.robot.model.enums.Orientation;

/**
 * This class defines the position of the robot.
 */
public class Position {
    private byte xCoordinate;
    private byte yCoordinate;
    private Orientation orientation;
    private boolean lost;

    public Position(byte x, byte y, Orientation orientation) {
        this.setXCoordinate(x);
        this.setYCoordinate(y);
        this.setOrientation(orientation);
    }

    public byte getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(byte xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public byte getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(byte yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }
}