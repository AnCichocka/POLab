package agh.ics.oop;
import java.util.Arrays;

public class OptionsParser {

    public MoveDirection[] parse(String[] directions) {

        MoveDirection[] parsed = new MoveDirection[directions.length];
        int counter = -1;

        for (String direction : directions) {

            counter++;
            switch (direction) {
                case "f", "forward" -> parsed[counter] = MoveDirection.FORWARD;
                case "b", "backward" -> parsed[counter] = MoveDirection.BACKWARD;
                case "l", "left" -> parsed[counter] = MoveDirection.LEFT;
                case "r", "right" -> parsed[counter] = MoveDirection.RIGHT;
                default -> counter--;
            }

        }

        parsed = Arrays.copyOfRange(parsed, 0, counter+1);
        return parsed;

    }
}