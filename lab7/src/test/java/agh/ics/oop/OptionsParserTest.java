package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void IsParsingCorrectWithCorrectInput1(){
        OptionsParser parser = new OptionsParser();
        String[] beforeParsing = {"f", "f", "l", "r"};

        MoveDirection[] afterParsing = parser.parse(beforeParsing);
        MoveDirection[] expectedResult = {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT,};
        assertArrayEquals(afterParsing, expectedResult);

    }

    @Test
    void IsParsingCorrectWithCorrectInput2(){
        OptionsParser parser = new OptionsParser();
        String[] beforeParsing = {"b", "r", "f", "left", "forward", "backward", "l", "right"};

        MoveDirection[] afterParsing = parser.parse(beforeParsing);
        MoveDirection[] expectedResult = {MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT};
        assertArrayEquals(afterParsing, expectedResult);

    }

    @Test
    void IsParsingCorrectWithIncorrectInput(){
        OptionsParser parser = new OptionsParser();
        String[] beforeParsing = {"b", "tomato", "r", "f", "left"};

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { parser.parse(beforeParsing); });

        assertEquals("tomato" + " is not legal move specification", exception.getMessage());
    }

}