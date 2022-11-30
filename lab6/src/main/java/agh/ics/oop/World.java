package agh.ics.oop;

import java.util.*;

public class World {

    public static final Vector2d UPPER_BOUND = new Vector2d(4,4);
    public static final Vector2d LOWER_BOUND = new Vector2d(0,0);
    public static void run1(String[] directions){
//        System.out.println("Zwierzę idzie do przodu");

//        String textToPrint = String.join(", ", directions);
//        System.out.println(textToPrint);

        for (String direction: directions){

            String message = switch(direction){
                case "f" -> "Zwierzak idzie do przodu";
                case "b" -> "Zwierzak idzie do przodu";
                case "l" -> "Zwierzak skreca w lewo";
                case "r" -> "Zwierzak skreca w prawo";
                default -> "";
            };

            //ignorowanie błędnych instrukcji
            if (message.length() != 0) {
                System.out.println(message);
            }
        }
    }

    public static void run(MoveDirection[] directions){

        for (MoveDirection direction: directions){

            String message = switch(direction){
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do przodu";
                case LEFT -> "Zwierzak skreca w lewo";
                case RIGHT -> "Zwierzak skreca w prawo";
            };

            System.out.println(message);
        }
    }

    public static MoveDirection[] convert(String[] directions){

        MoveDirection[] argsToRun = new MoveDirection[directions.length];
        int counter = 0;

        for (String direction: directions){
            if (Objects.equals(direction, "f") || Objects.equals(direction, "b") || Objects.equals(direction, "l") || Objects.equals(direction, "r")){
                switch (direction){
                    case "f" -> argsToRun[counter] = MoveDirection.FORWARD;
                    case "b" -> argsToRun[counter] = MoveDirection.BACKWARD;
                    case "l" -> argsToRun[counter] = MoveDirection.LEFT;
                    case "r" -> argsToRun[counter] = MoveDirection.RIGHT;
                }
                counter++;
            }
        }

        argsToRun = Arrays.copyOfRange(argsToRun, 0, counter);
        return argsToRun;
    }

    public static void main(String[] args){


    }
}
