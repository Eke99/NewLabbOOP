import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CarFerryTest {

    CarFerry carFerry = new CarFerry(Color.YELLOW, 50, "CarFerry", Car.Direction.NORTH, 100, 100, 2);

    Car c1 = new Car();
    Car c2 = new Car();
    Car c3 = new Car();

    @Test
    void loadCar() {
        carFerry.extendFlak();

        carFerry.loadCar(c1);
        carFerry.loadCar(c2);

        assertEquals(false, carFerry.loadCar(c3));

        assertEquals(c1, carFerry.getLoadedCars().get(0));
        assertEquals(c2, carFerry.getLoadedCars().get(1));


        carFerry.unloadAll();
    }

    @Test
    void unloadCar() {

        carFerry.extendFlak();

        carFerry.loadCar(c1);
        carFerry.loadCar(c2);

        assertEquals(c1, carFerry.unloadCar());
        assertEquals(c2, carFerry.unloadCar());
    }
}