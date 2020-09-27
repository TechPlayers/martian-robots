package com.lme.robot.service.impl;

import com.lme.robot.model.Position;
import com.lme.robot.service.RobotService;

public class RobotServiceImpl implements RobotService {
    private final byte maxXCoordinate;
    private final byte maxYCoordinate;
    private final boolean[][] scentedPosition;

    public RobotServiceImpl(byte x, byte y) {
        this.maxXCoordinate = x;
        this.maxYCoordinate = y;
        scentedPosition = new boolean[x + 1][y + 1];
    }

    @Override
    public Position moveRobot(Position position, String instructions) {
        return position;
    }
}