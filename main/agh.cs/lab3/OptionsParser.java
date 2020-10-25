package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirector;

import java.util.LinkedList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirector> parser(String[] args){
        List<MoveDirector> list = new LinkedList<>();
        for (String arg : args){
            switch (arg){
                case "f" -> list.add(MoveDirector.FORWARD);
                case "FORWARD" -> list.add(MoveDirector.FORWARD);
                case "b" -> list.add(MoveDirector.BACKWARD);
                case "BACKWARD" -> list.add(MoveDirector.BACKWARD);
                case "l" -> list.add(MoveDirector.LEFT);
                case "LEFT" -> list.add(MoveDirector.LEFT);
                case "r" -> list.add(MoveDirector.RIGHT);
                case "RIGHT" -> list.add(MoveDirector.RIGHT);
            }
        }
        return list;
    }
}
