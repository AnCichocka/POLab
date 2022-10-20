package agh.ics.oop;

import java.util.Arrays;
import java.util.Objects;

public class OpotionsParser {

    public MoveDirection[] parse(String[] directions) {

        MoveDirection[] parsed = new MoveDirection[directions.length];
        String[] correctDirections = {"f", "forward", "b", "backward", "r", "right", "l", "left"};
        int counter = 0;

        for (String direction : directions) {
            for (String correctDirection : correctDirections) {
                if (direction.equals(correctDirection)) {
                    switch (direction) {
                        case "f":
                        case "forward":
                            parsed[counter] = MoveDirection.FORWARD;
                            break;
                        case "b":
                        case "backward":
                            parsed[counter] = MoveDirection.BACKWARD;
                            break;
                        case "l":
                        case "left":
                            parsed[counter] = MoveDirection.LEFT;
                            break;
                        case "r":
                        case "right":
                            parsed[counter] = MoveDirection.RIGHT;
                            break;
                    }
                    counter++;
                    break;
                }
            }
        }
        parsed = Arrays.copyOfRange(parsed, 0, counter);
        return parsed;

    }
}