package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpotionsParserTest {

    @Test
    void IsParsingCorrectWithCorrectInput1(){
        OpotionsParser parser = new OpotionsParser();
        String[] beforeParsing = {"f", "f", "l", "r"};

        MoveDirection[] afterParsing = parser.parse(beforeParsing);
        MoveDirection[] expectedResult = {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT,};
        assertArrayEquals(afterParsing, expectedResult);

    }

    @Test
    void IsParsingCorrectWithCorrectInput(){
        OpotionsParser parser = new OpotionsParser();
        String[] beforeParsing = {"b", "r", "f", "left", "forward", "backward", "l", "right"};

        MoveDirection[] afterParsing = parser.parse(beforeParsing);
        MoveDirection[] expectedResult = {MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT};
        assertArrayEquals(afterParsing, expectedResult);

    }

    @Test
    void IsParsingCorrectWithIncorrectInputs(){
        OpotionsParser parser = new OpotionsParser();
        String[] beforeParsing = {"b", "ab", "r", "f", "tomato", "left"};

        MoveDirection[] afterParsing = parser.parse(beforeParsing);
        MoveDirection[] expectedResult = {MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT};
        assertArrayEquals(afterParsing, expectedResult);

    }

}