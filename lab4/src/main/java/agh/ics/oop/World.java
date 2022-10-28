package agh.ics.oop;

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

        Animal animalCat = new Animal();
        System.out.println(animalCat);
//
//        animalCat.move(MoveDirection.RIGHT);
//        animalCat.move(MoveDirection.FORWARD);
//        animalCat.move(MoveDirection.FORWARD);
//        animalCat.move(MoveDirection.FORWARD);
//        System.out.println(animalCat);

        OptionsParser parser = new OptionsParser();
        MoveDirection[] parsedArgs = parser.parse(args);

        for(MoveDirection direction : parsedArgs){
            animalCat.move(direction);
        }

        System.out.println(animalCat);

        // 10.
        // Wystarczy stworzyć tablicę dwuwymiarową 5*5, w polach tablicy trzymać False jeśli nie ma na nim zwierzaka, a True jeśli jest.
        // Przed move sprawdzać czy pole jest wolne (False).

    }


}
