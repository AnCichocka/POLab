package agh.ics.oop;

import java.util.Arrays;
import java.util.Objects;

public class World {

    public static void run_string(String[] directions){
//        System.out.println("animal goes forward");

//        String textToPrint = String.join(", ", directions);
//        System.out.println(textToPrint);

        for (String direction: directions){

            String message = switch(direction){
                case "f" -> "Zwierzak idzie do przodu";
                case "b" -> "Zwierzak idzie do przodu";
                case "l" -> "Zwierzak skręca w lewo";
                case "r" -> "Zwierzak skręca w prawo";
                default -> "";
            };

            //ignorowanie błędnych instrukcji
            if (message.length() != 0) {
                System.out.println(message);
            }
        }
    }

    public static void run(Direction[] directions){

        for (Direction direction: directions){

            String message = switch(direction){
                case f -> "Zwierzak idzie do przodu";
                case b -> "Zwierzak idzie do przodu";
                case l -> "Zwierzak skręca w lewo";
                case r -> "Zwierzak skręca w prawo";
            };

            System.out.println(message);
        }
    }

    public static Direction[] convert(String[] directions){

        Direction[] argsToRun = new Direction[directions.length];
        int counter = 0;

        for (String direction: directions){
            if (Objects.equals(direction, "f") || Objects.equals(direction, "b") || Objects.equals(direction, "l") || Objects.equals(direction, "r")){
                switch (direction){
                    case "f" -> argsToRun[counter] = Direction.f;
                    case "b" -> argsToRun[counter] = Direction.b;
                    case "l" -> argsToRun[counter] = Direction.l;
                    case "r" -> argsToRun[counter] = Direction.r;
                }
                counter++;
            }
        }
        argsToRun = Arrays.copyOfRange(argsToRun, 0, counter);
        return argsToRun;
    }

    public static void main(String[] args){

        //System.out.println("system wystartował");
        //run1(args);
        //System.out.println("system zakończył działanie");
        //System.out.println();

        Direction[] argsToRun = convert(args);
        run(argsToRun);

    }
}
