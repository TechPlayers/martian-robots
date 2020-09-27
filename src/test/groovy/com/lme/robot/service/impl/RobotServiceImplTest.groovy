package com.lme.robot.service.impl

import com.lme.robot.model.Position
import com.lme.robot.model.enums.Orientation
import com.lme.robot.service.RobotService
import spock.lang.Specification

/**
 * The aim of this class is to test the method of the Robot Service.
 * 100% Test coverage of the service class has been implemented.
 */
class RobotServiceImplTest extends Specification {

    final RobotService robotService = new RobotServiceImpl(5 as byte, 3 as byte)

    def "Should_Not_Lost_When_At_The_Corner"() {
        given:
        Position p = new Position(5 as byte, 3 as byte, Orientation.N)

        when:
        def result = robotService.moveRobot(p,"FRRFLLFFRRFLL")

        then:
        result.getXCoordinate() == 5 as byte
        result.getYCoordinate() == 3 as byte
        result.getOrientation() == Orientation.N
        result.isLost()

        when:
        p = new Position(4 as byte, 3 as byte, Orientation.E)
        result = robotService.moveRobot(p,"FFLFLFFLF")

        then:
        result.getXCoordinate() == 3 as byte
        result.getYCoordinate() == 2 as byte
        result.getOrientation() == Orientation.S
        !result.isLost()
    }


    def "Should_11E_When_11E_RFRFRFRF"() {
        given:
        Position p = new Position(1 as byte, 1 as byte, Orientation.E)

        when:
        final result = robotService.moveRobot(p,"RFRFRFRF")

        then:
        result.getXCoordinate() == 1 as byte
        result.getYCoordinate() == 1 as byte
        result.getOrientation() == Orientation.E
        !result.isLost()
    }

    def "Should_33NLost_When_32N_FRRFLLFFRRFLL"() {
        given:
        Position p = new Position(3 as byte, 2 as byte, Orientation.N)

        when:
        final result = robotService.moveRobot(p,"FRRFLLFFRRFLL")

        then:
        result.getXCoordinate() == 3 as byte
        result.getYCoordinate() == 3 as byte
        result.getOrientation() == Orientation.N
        result.isLost()
    }

    def "Should_23S_When_32N_FRRFLLFFRRFLL_before_03W_LLFFFLFLFL"() {
        given:
        Position p = new Position(3 as byte, 2 as byte, Orientation.N)
        robotService.moveRobot(p,"FRRFLLFFRRFLL")
        p = new Position(0 as byte, 3 as byte, Orientation.W)

        when:
        final result = robotService.moveRobot(p,"LLFFFLFLFL")

        then:
        result.getXCoordinate() == 2 as byte
        result.getYCoordinate() == 3 as byte
        result.getOrientation() == Orientation.S
        !result.isLost()
    }

    def "Should_Lost_When_yCoordinateIs0_orientationIsS"() {
        given:
        Position p = new Position(3 as byte, 0 as byte, Orientation.S)

        when:
        final result = robotService.moveRobot(p,"FRRFLLFFRRFLL")

        then:
        result.getXCoordinate() == 3 as byte
        result.getYCoordinate() == 0 as byte
        result.getOrientation() == Orientation.S
        result.isLost()
    }

    def "Should_Lost_When_xCoordinateIs5_orientationIsE"() {
        given:
        Position p = new Position(5 as byte, 3 as byte, Orientation.E)

        when:
        final result = robotService.moveRobot(p,"FRRFLLFFRRFLL")

        then:
        result.getXCoordinate() == 5 as byte
        result.getYCoordinate() == 3 as byte
        result.getOrientation() == Orientation.E
        result.isLost()
    }

    def "Should_Lost_When_xCoordinateIs0_orientationIsW"() {
        given:
        Position p = new Position(0 as byte, 3 as byte, Orientation.W)

        when:
        final result = robotService.moveRobot(p,"FRRFLLFFRRFLL")

        then:
        result.getXCoordinate() == 0 as byte
        result.getYCoordinate() == 3 as byte
        result.getOrientation() == Orientation.W
        result.isLost()
    }
}