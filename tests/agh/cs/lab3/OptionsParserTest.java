package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirector;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void parser() {
        //given
        Animal nutka1 = new Animal();
        String[] test = new String[] {"f", "FORWARD", "XD", "l", "b", "l", "BACKWARD", "ten string sprawdza czy dane wejsciowe są poprawnie interpretowane :)"};
        List<MoveDirector> list = OptionsParser.parser(test);
        Animal nutka2 = new Animal();
        nutka2.move(MoveDirector.FORWARD);
        nutka2.move(MoveDirector.FORWARD);
        nutka2.move(MoveDirector.LEFT);
        nutka2.move(MoveDirector.BACKWARD);
        nutka2.move(MoveDirector.LEFT);
        nutka2.move(MoveDirector.BACKWARD);
        //when
        for(MoveDirector move : list){
            nutka1.move(move);
        }
        //then
        assertEquals(nutka2.getOrientation(), nutka1.getOrientation());
        assertEquals(nutka2.getPosition(), nutka1.getPosition());
    }
}