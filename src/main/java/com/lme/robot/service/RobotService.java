package com.lme.robot.service;

import com.lme.robot.model.Position;

/**
 * A service of different operations, can be performed on robot.
 */
public interface RobotService {

    /**
     * Move robot around rectangular grid as per given instructions
     * @param position The current position of the robot
     * @param instructions The instructions to move the robot
     * @return The new position after robot moved
     */
    Position moveRobot(Position position, String instructions);
}