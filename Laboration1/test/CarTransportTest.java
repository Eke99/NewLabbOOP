import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CarTransportTest {

    CarTransport cTran = new CarTransport(Color.black, 50, 2, "CarTransport", Car.Direction.NORTH, 100, 100, 2);

    double origX = cTran.getX();
    double origY = cTran.getY();

    Car c1 = new Car();
    Car c2 = new Car();
    Car c3 = new Car();

    @Test
    void extendFlak() {

        cTran.extendFlak();

        assertEquals(true, cTran.isFlakExtended());

        cTran.move();

        assertEquals(origY, cTran.getY());
    }

    @Test
    void loadCar() {
        cTran.extendFlak();
        cTran.loadCar(c1);
        cTran.loadCar(c2);

        assertEquals(c2, cTran.unloadCar());



        cTran.loadCar(c2);
        cTran.loadCar(c3);

        assertEquals(2, cTran.getLoadedCars().size());

        cTran.unloadAll();

    }

    @Test
    void retractFlak() {
        cTran.retractFlak();
        assertEquals(false, cTran.isFlakExtended());


    }

    @Test
    void getLoadedCars() {

        cTran.extendFlak();

        cTran.loadCar(c1);
        cTran.loadCar(c2);

        Car[] cArr = {c1,c2};


        assertEquals(c2, cTran.getLoadedCars().get(0));
        assertEquals(c1, cTran.getLoadedCars().get(1));

    }


}