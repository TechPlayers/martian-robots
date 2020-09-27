package com.lme.robot;

import com.lme.robot.model.Position;
import com.lme.robot.model.enums.Orientation;
import com.lme.robot.model.exceptions.CoordinateException;
import com.lme.robot.model.exceptions.InstructionException;
import com.lme.robot.service.RobotService;
import com.lme.robot.service.impl.RobotServiceImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            byte maxXCoordinate = sc.nextByte();
            byte maxYCoordinate = sc.nextByte();

            if (maxXCoordinate > 50 || maxYCoordinate > 50) {
                throw new CoordinateException("Please enter valid upper-right coordinate.The coordinate's value should be less than 50.");
            }

            RobotService robotService = new RobotServiceImpl(maxXCoordinate, maxYCoordinate);
            Position position;
            List<Position> positionList = new LinkedList<>();

            do {
                byte x = sc.nextByte();
                byte y = sc.nextByte();
                if ((x > 50 || x >maxXCoordinate) || (y > 50 || y>maxYCoordinate)) {
                    throw new CoordinateException("Please enter valid coordinate.The coordinate's value should be less than 50 and less than top right coordinate.");
                }
                String orientation = sc.next();
                sc.nextLine();
                String instruction = sc.nextLine();
                if (instruction.length() > 100) {
                    throw new InstructionException("Please enter valid Instruction.The instruction's length should be less than 100.");
                }
                position = new Position(x, y, Orientation.valueOf(orientation));
                positionList.add(robotService.moveRobot(position, instruction));
            } while (!sc.nextLine().equals("STOP"));

            printPosition(positionList);
        } catch (Exception e) {
            out.printf("Please enter valid input. %s %n",e.getMessage());
        }
    }

    /**
     *  Print the result.
     * @param positionList  The list of Robot's position
     */
    private static void printPosition(List<Position> positionList) {
        positionList.forEach(position -> out.printf("%d %d %s %s %n", position.getXCoordinate(), position.getYCoordinate(), position.getOrientation(), position.isLost() ? "LOST" : "")
        );
    }
}