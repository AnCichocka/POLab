package agh.ics.oop;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Objects;

public class World {

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

    public static void run(Direction[] directions){

        for (Direction direction: directions){

            String message = switch(direction){
                case f -> "Zwierzak idzie do przodu";
                case b -> "Zwierzak idzie do przodu";
                case l -> "Zwierzak skreca w lewo";
                case r -> "Zwierzak skreca w prawo";
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

//        Direction[] convertedArgs = convert(args);
//        run(convertedArgs);

//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));

        MapDirection m1 = MapDirection.SOUTH;
        System.out.println(m1.toUnitVector());
        System.out.println(m1.previous());
        System.out.println(m1.next());

        Vector2d v = new Vector2d(1,2);
        Vector2d v1 = new Vector2d(1,2);
        System.out.println(Objects.equals(v,v1));

        System.out.println(v.follows(v));


    }
}
