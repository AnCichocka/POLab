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

        //lab1
//        System.out.println("system wystartował");
//        run1(args);
//        System.out.println("system zakończył działanie");
//        System.out.println();

//        Direction[] convertedArgs = convert(args);
//        run(convertedArgs);


        //lab2
//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));

        //lab3
        Animal a = new Animal();
        Vector2d v1 = new Vector2d(2,2);
        System.out.println(a.isAt(v1));
        Vector2d v2 = new Vector2d(3,2);
        System.out.println(a.isAt(v2));
    }
}
