import java.awt.*;

/**
 * a subclass of car that has a trimFactor method that differs it from Car
 */
public class Volvo240 extends Car {
    /**
     * Is used to determine the speedFactor
     */
    public final double trimFactor = 1.25;

    public Volvo240(Color color, double enginePower, int nrDoors, String modelName, Direction dir, double x, double y) {
        super(color, enginePower, nrDoors, modelName, dir, x, y, Size.SMALL);
    }

    public Volvo240(double x, double y){
        this(Color.BLUE, 10, 4, "Volvo240", Direction.EAST, x, y);
    }


    /*
     * @return The cars speedFactor, how fast it accelerates
     */
    public double speedFactor() {

        return getEnginePower() * 0.01 * trimFactor;
    }


}
