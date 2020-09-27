package com.lme.robot.service.impl;

import com.lme.robot.model.Position;
import com.lme.robot.model.enums.Orientation;
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
        for (char c : instructions.toCharArray()) {
            switch (c) {
                case 'L':
                    position.setOrientation(turnLeft(position.getOrientation()));
                    break;

                case 'R':
                    position.setOrientation(turnRight(position.getOrientation()));
                    break;

                case 'F':
                    moveForward(position);
                    break;
                default:
                    break;
            }
            if (position.isLost()) {
                break;
            }
        }
        return position;
    }

    /**
     * The robot turns left 90 degrees and remains on the current grid point.
     *
     * @param orientation The current orientation of the robot.
     * @return The new orientation of the robot after turning left.
     */
    private Orientation turnLeft(Orientation orientation) {
        switch (orientation) {
            case N:
                orientation = Orientation.W;
                break;

            case S:
                orientation = Orientation.E;
                break;

            case E:
                orientation = Orientation.N;
                break;

            case W:
                orientation = Orientation.S;
                break;
        }
        return orientation;
    }

    /**
     * The robot turns right 90 degrees and remains on the current grid point.
     *
     * @param orientation The current orientation of the robot.
     * @return The new orientation of the robot after turning right.
     */
    private Orientation turnRight(Orientation orientation) {
        switch (orientation) {
            case N:
                orientation = Orientation.E;
                break;

            case S:
                orientation = Orientation.W;
                break;

            case E:
                orientation = Orientation.S;
                break;

            case W:
                orientation = Orientation.N;
                break;
        }
        return orientation;
    }

    /**
     * The robot moves forward one grid point in the direction of the current
     * orientation and maintains the same orientation
     *
     * @param position The current position of the robot.
     */
    private void moveForward(Position position) {
        byte currentXCoordinate = position.getXCoordinate();
        byte currentYCoordinate = position.getYCoordinate();
        boolean lost = true;
        switch (position.getOrientation()) {
            case N:
                if (currentYCoordinate < maxYCoordinate) {
                    lost = false;
                    position.setYCoordinate(++currentYCoordinate);
                }
                break;

            case S:
                if (currentYCoordinate > 0) {
                    lost = false;
                    position.setYCoordinate(--currentYCoordinate);
                }
                break;

            case E:
                if (currentXCoordinate < maxXCoordinate) {
                    lost = false;
                    position.setXCoordinate(++currentXCoordinate);
                }
                break;

            case W:
                if (currentXCoordinate > 0) {
                    lost = false;
                    position.setXCoordinate(--currentXCoordinate);
                }
                break;
        }

        if (lost && !scentedPosition[currentXCoordinate][currentYCoordinate]) {
            position.setLost(true);
            scentedPosition[currentXCoordinate][currentYCoordinate] = true;
        }
    }
}