import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    Scania scania = new Scania(Color.YELLOW, 30, 4, "Scania", Car.Direction.NORTH, 100, 100);


    @Test
    void extendFlak() {
        scania.startEngine();
        scania.extendFlak();
        assertEquals(0, scania.getFlakAngle());
        scania.stopEngine();
    }

    @Test
    void extendFlak1() {
        scania.extendFlak();
        assertEquals(70,scania.getFlakAngle());
    }

    @Test
    void retractFlak() {
        scania.setFlakAngle(20);
        scania.retractFlak(10);
        assertEquals(10,scania.getFlakAngle());
    }

    @Test
    void retractFlak1() {
        scania.setFlakAngle(50);
        scania.startEngine();
        assertEquals(0,scania.getCurrentSpeed());
        scania.stopEngine();
        scania.retractFlak();
        assertEquals(0,scania.getFlakAngle());
    }

}