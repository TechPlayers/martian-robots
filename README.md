
## Service Overview
The surface of Mars can be modelled by a rectangular grid around which robots are able to
move according to instructions provided from Earth. The program that
determines each sequence of robot positions and reports the final position of the robot.

## Diagrams - Sequence diagram of the system
diagram/sequence.png

## Installation / Local Development
The app relies on the following to run:

- Maven
- Java8
- Spock
- Groovy

setup:
- Install and mange locally on your machine

## Notes
1. Enter STOP when you want to stop execution(Example provided in ##Usage overview).
2. Enter next line before next robot's input.(As given in test.)
2. As the challenge limited to few hours, I tried to build required things from challenge else The More validation/Exception
 should be implemented with relevant test case like validation of Orientation and instruction etc. 
 Also, separate validation class with test case could have been implemented.

## Usage overview
1. Martin-robot can be instructed via standard input and output. OR
2. You can also run  java -jar target/martian-robots-1.0-SNAPSHOT.jar 
3. Below are some examples.

Example 1:(As per given in challenge) <br/>
An example of position and instructions might look like this:<br/>

Sample Input:
5 3<br/>
1 1 E<br/>
RFRFRFRF<br/>
    
3 2 N<br/>
FRRFLLFFRRFLL<br/>

0 3 W<br/>
LLFFFLFLFL<br/>
STOP<br/>

Sample Output:<br/>
1 1 E<br/>
3 3 N LOST<br/>
2 3 S<br/>

Example 2.<br/>
Sample Input:<br/>
54 6<br/>

Sample Output:<br/>
Please enter valid input. Please enter valid upper-right coordinate.The coordinate's value should be less than 50. <br/>


Example 3.<br/>
Sample Input:<br/>
5 4<br/>
2 3 N<br/>
FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF<br/>

Sample Output:<br/>
Please enter valid input. Please enter valid Instruction.The instruction's length should be less than 100. 
