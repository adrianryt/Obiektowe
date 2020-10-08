// W przypadku podania złego argumentu, program wypisuje który argument został podany źle, następnie podaje ścieżke pomijając źle podane argumenty
package pl.edu.agh.po.lab01;

import agh.cs.lab1.Direction;


public class World {

    public static void main(String[] args) {
        System.out.print("Start \n");
        run(World.changing(args));
        System.out.print("Stop");
    }

    public static void run(Direction[] args) {
       for (Direction arg : args){
           if(arg != null) {
               switch (arg) {
                   case FORWARD -> System.out.printf("Do przodu\n");
                   case BACKWARD -> System.out.printf("Do tyłu\n");
                   case LEFT -> System.out.printf("W lewo\n");
                   case RIGHT -> System.out.printf("W prawo\n");
               }
           }
       }
    }
    public static Direction[] changing (String[] args){
        Direction[] direction = new Direction[args.length];
        int i = 0;
        for (String arg : args) {
            switch (arg) {
                case "f" -> direction[i] = Direction.FORWARD;
                case "b" -> direction[i] = Direction.BACKWARD;
                case "r" -> direction[i] = Direction.RIGHT;
                case "l" -> direction[i] = Direction.LEFT;
                default -> System.out.printf("zły argument numer: " + (i+1) + "\n");
                }
             i++;
             }
        return direction;
        }
    }



