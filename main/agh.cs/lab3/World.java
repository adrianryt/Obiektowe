package agh.cs.lab3;

import agh.cs.lab2.MoveDirector;

import java.util.List;

public class World {
    public static void main(String[] args){
        String[] arguments = {"f","dupa"};
        Animal nutka = new Animal();
        List<MoveDirector> list = OptionsParser.parser(arguments);
        for(MoveDirector move : list){
            nutka.move(move);
        }
        System.out.println(nutka.toString());
    }

}
