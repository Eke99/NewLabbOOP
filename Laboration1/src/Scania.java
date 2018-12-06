import java.awt.*;

/**
 * A truck that in addition to data in cars also has a flak which can be Extended and lowered if the scania is standind still.
 */
public class Scania extends Truck {

    /**
     * The angle of the flak, should only be between 0 and 70.
     */
    private double flakAngle = 0;


    public Scania(Color color, double enginePower, int nrDoors, String modelName, Car.Direction dir, double x, double y) {
        super(color, enginePower, nrDoors, modelName, dir, x, y);
    }
    public Scania(double x, double y){
        this(Color.BLUE, 30, 4, "Scania", Direction.EAST, x, y);
    }

    public double getFlakAngle() {
        return flakAngle;
    }

    public boolean isFlakExtended() {
        return flakAngle > 0;
    }

    public void setFlakAngle(double flakAngle) {
        if (flakAngle <= 70 && flakAngle >= 0 && !this.isMoving()) {
            this.flakAngle = flakAngle;
        }
    }

    /**
     * Raises flak to maximum angle.
     */
    public void extendFlak() {
        if (!this.isMoving()) {
            this.flakAngle = 70;
            this.setFlakExtended(true);
        }
    }

    /**
     * Raises flak with an amount.
     * @param amount
     */
    public void extendFlak(double amount) {
        if (!this.isMoving()) {
            this.flakAngle += amount;
            if (this.flakAngle > 70) this.flakAngle = 70;
            this.setFlakExtended(true);
        }
    }

    /**
     * Lowers the flak completely so the truck can move.
     */
    public void retractFlak() {
        this.flakAngle = 0;
        this.setFlakExtended(false);
    }

    public void retractFlak(double amount) {
        this.flakAngle -= amount;
        if (this.flakAngle < 0) {
            this.flakAngle = 0;
        }
        this.setFlakExtended(false);
    }


}
