import java.awt.*;
import java.util.List;

/**
 * Class for a ferry which can transport a number of cars. First car in is also first car out.
 */
public class CarFerry implements IMovable, ILoadable {

    private final CarTransport parent;



    public CarFerry(Color color, int enginePower, String modelName, Car.Direction dir, int x, int y, int maxCars) {
        parent = new CarTransport(color, enginePower, 0, modelName, dir, x, y, maxCars);
    }

    public CarFerry() {
        this(Color.YELLOW, 50, "CarFerry", Car.Direction.NORTH, 100, 100, 20);
    }


    @Override
    public void extendFlak() {
        parent.extendFlak();
    }

    @Override
    public void retractFlak() {
        parent.retractFlak();
    }

    /**
     * Loads a car onto the ferry if the flak is extended while stationary, and the car is close enough
     * and have room.
     * @param c Car to load.
     * @return True if car was loaded, otherwise false.
     */
    @Override
    public boolean loadCar(Car c) {
        if (!parent.isMoving() && parent.isFlakExtended() && parent.isClose(c) && parent.isRoomForCar() && c.getSize() == Car.Size.SMALL) {
            parent.getLoadedCars().add(c);
            c.setX(parent.getX());
            c.setY(parent.getY());
            return true;
        }
        return false;
    }

    /**
     * Unloads car according to first in - first out principle.
     *
     * @return The unloaded car.
     */
    @Override
    public Car unloadCar() {
        if (!parent.isMoving() && parent.isFlakExtended()) {
            Car c = parent.getLoadedCars().get(0);
            c.setX(parent.getX() + 10);
            c.setY(parent.getY() + 10);
            parent.getLoadedCars().remove(0);
            return c;
        }
        return null;
    }

    /**
     * Unloads all cars from the ferry.
     */
    public void unloadAll() {
        parent.unloadAll();

    }

    /**
     *
     * @return A list of all the loaded cars.
     */
    public List<Car> getLoadedCars() {
        return parent.getLoadedCars();
    }

    @Override
    public void move() {
        parent.move();

    }

    @Override
    public void turnLeft() {
        parent.move();

    }


    @Override
    public void turnRight() {

        parent.move();
    }

    @Override
    public double speedFactor() {
        return parent.speedFactor();
    }

    @Override
    public double getCurrentSpeed() {
        return parent.getCurrentSpeed();
    }

    @Override
    public void setCurrentSpeed(double speed) {
        parent.setCurrentSpeed(speed);

    }

    @Override
    public void setDirection(Car.Direction direction) {
        parent.setDirection(direction);

    }

    @Override
    public boolean isMoving() {
        return parent.isMoving();
    }

    @Override
    public double getEnginePower() {
        return parent.getEnginePower();
    }

    @Override
    public void gas(double amount) {
        parent.gas(amount);
    }

    @Override
    public void brake(double amount) {
        parent.brake(amount);
    }


}
