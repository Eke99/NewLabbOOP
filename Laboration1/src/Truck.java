import java.awt.*;

public class Truck extends Car {

    private boolean flakExtended;


    public Truck(Color color, double enginePower, int nrDoors, String modelName, Car.Direction dir, double x, double y) {
        super(color, enginePower, nrDoors, modelName, dir, x, y, Car.Size.LARGE);
        this.setFlakExtended(false);
    }

    public void extendFlak() {
        flakExtended = true;
    }

    public void retractFlak() {
        flakExtended = false;
    }

    public boolean isFlakExtended() {

        return flakExtended;
    }

    public void setFlakExtended(boolean flakExtended) {

        this.flakExtended = flakExtended;
    }

    /**
     * Increments the speed if the flak is retracted.
     *
     * @param amount An amount with which to increase the speed
     */
    public void incrementSpeed(double amount) {
        if (!this.flakExtended && isEngineOn()) {
            this.setCurrentSpeed(this.getCurrentSpeed() + speedFactor() * amount);
            if (this.getCurrentSpeed() > this.getEnginePower()) {
                this.setCurrentSpeed(this.getEnginePower());
            }
        }
    }


    /**
     * Starts the engine if the flak is retracted.
     */
    public void startEngine() {
        if (!isFlakExtended()) {
            setCurrentSpeed(0.1);
            setEngineOn(true);
        }

    }
}
