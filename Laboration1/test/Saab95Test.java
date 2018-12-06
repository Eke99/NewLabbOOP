import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    Saab95 saab = new Saab95( Color.RED, 20, 4, "Saab95", Car.Direction.NORTH, 100, 100, false);

    @Test
    void setTurboOn() {
        saab.setTurboOn();
        assertEquals(true, saab.isTurboOn());
    }

    @Test
    void setTurboOff() {
        saab.setTurboOff();
        assertEquals(false, saab.isTurboOn());
    }

    @Test
    void speedFactor() {
        saab.setTurboOn();

        assertEquals(0.26, saab.speedFactor());
    }
}