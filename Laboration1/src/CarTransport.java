import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A car transport that can transport a number of car on it's bed.
 */
public class CarTransport extends Truck implements ILoadable{

    private List<Car> loadedCars = new ArrayList<Car>();

    private final int maxCars;



    public CarTransport(Color color, double enginePower, int nrDoors, String modelName, Car.Direction dir, double x, double y, int maxCars) {
        super(color, enginePower, nrDoors, modelName, dir, x, y);
        this.maxCars = maxCars;
    }




    /**
     *
     * @return A list of the loaded cars.
     */
    public List<Car> getLoadedCars() {
        return loadedCars;
    }

    /**
     * Extends the ramp so it can load cars.
     */
    public void extendFlak() {
        if(!this.isMoving()){
        this.setFlakExtended(true);}
    }

    /**
     * Retracts the ramp so it can move again.
     */
    public void retractFlak() {
        this.setFlakExtended(false);
    }


    /**
     * Loads car to the truck if possible
     *
     * @param c A car to load
     */
    public boolean loadCar(Car c) {
        if (!this.isMoving() && this.isFlakExtended() && isClose(c) && isRoomForCar() && c.getSize() == Car.Size.SMALL) {
            loadedCars.add(0,c);
            c.setLoaded(true);
            c.setEngineOn(false);
            c.setX(this.getX());
            c.setY(this.getY());
            return true;
        }
        return false;
    }


    /**
     * "Unloads" the last loaded car and puts it on a nearby coordinate
     * @return The unloaded car
     */
    public Car unloadCar() {
        if (!this.isMoving() && this.isFlakExtended() && loadedCars.size() > 0) {
            Car c = loadedCars.remove(0);
            c.setX(this.getX() - 10);
            c.setY(this.getY() - 10);
            c.setLoaded(false);
            return c;
        }
        return null;
    }

    /**
     * Unloades all car on the bed.
     */
    public void unloadAll(){
        if (!this.isMoving() && this.isFlakExtended() && loadedCars.size() > 0) {
            for(Car c : getLoadedCars()){
                this.unloadCar();
            }
        }

    }


    /** Check if there is room for a car on the bed.
     * @return True if there is room.
     */
    public boolean isRoomForCar() {
        return maxCars - loadedCars.size() > 0;
    }

    /** Checks if a car is close enough for loading.
     * @param c Car to check.
     * @return True if close enough.
     */
    public boolean isClose(Car c) {
        return (c.getX() - this.getX() < 20 || c.getX() - this.getX() > -20) && (c.getY() - this.getY() < 20 || c.getY() - this.getY() > -20);
    }


    /**
     * In addition to updating position, it also moves all cars which are loaded.
     */
    @Override
    public void move() {
        this.updatePosition();
        for (Car c : loadedCars) {
            c.setX(this.getX());
            c.setY(this.getY());
        }
    }

    /**
     * Turns both the transport and all loaded cars.
     */
    public void turnRight(){
        this.changeDirRight();
        for(Car c : loadedCars){
            c.setDirection(this.getDir());
        }
    }

    /**
     * Turns both the transport and the loaded cars.
     */
    public void turnLeft(){
        this.changeDirLeft();
        for(Car c : loadedCars){
            c.setDirection(this.getDir());
        }
    }


}

