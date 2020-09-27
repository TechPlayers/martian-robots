package com.lme.robot.service.impl

import com.lme.robot.model.Position
import com.lme.robot.model.enums.Orientation
import com.lme.robot.service.RobotService
import spock.lang.Specification

/**
 * The aim of this class is to test the method of the Robot Service.
 */
class RobotServiceImplTest extends Specification {

    final RobotService robotService = new RobotServiceImpl(5 as byte, 3 as byte)

    def "Should_Not_Lost_When_At_The_Corner"() {
        given:
        Position p = new Position(5 as byte, 3 as byte, Orientation.N)

        when:
        def result = robotService.moveRobot(p, "FRRFLLFFRRFLL")

        then:
        result.getXCoordinate() == 5 as byte
        result.getYCoordinate() == 3 as byte
        result.getOrientation() == Orientation.N
        result.isLost()

        when:
        p = new Position(4 as byte, 3 as byte, Orientation.E)
        result = robotService.moveRobot(p, "FFLFLFFLF")

        then:
        result.getXCoordinate() == 3 as byte
        result.getYCoordinate() == 2 as byte
        result.getOrientation() == Orientation.S
        !result.isLost()
    }
}