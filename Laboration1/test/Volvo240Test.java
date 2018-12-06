import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;


class Volvo240Test {
    Volvo240 volvo = new Volvo240(Color.BLUE, 20, 4, "240", Car.Direction.NORTH, 100, 100);

    @Test
    public void settersGetters() {
        volvo.setColor(Color.YELLOW);
        assertEquals(Color.YELLOW, volvo.getColor());
        assertEquals(20, volvo.getEnginePower());
        assertEquals(4, volvo.getNrDoors());
        assertEquals("240", volvo.getModelName());
        assertEquals(100, volvo.getX());
        assertEquals(100, volvo.getY());

    }

    @Test
    public void movement() {
        volvo.startEngine();
        volvo.turnLeft();
        assertEquals(Car.Direction.WEST, volvo.getDir());

        volvo.turnRight();
        assertEquals(Car.Direction.NORTH, volvo.getDir());

        volvo.move();
        assertEquals(99, volvo.getY());

    }

    @Test
    public void speed() {
        volvo.startEngine();
        assertEquals(0.1, volvo.getCurrentSpeed());

        volvo.gas(0.5);
        assertEquals(0.225, volvo.getCurrentSpeed());

        volvo.brake(0.5);
        assertEquals(0.1, volvo.getCurrentSpeed());

        volvo.stopEngine();
        assertEquals(0, volvo.getCurrentSpeed());
    }
}