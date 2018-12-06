import java.awt.*;
import java.awt.geom.Point2D;

/**
 * an abstract class of of cars. Contains necessary and common data for cars.
 */

public class Car implements IMovable {
    //variables
    private Color color;
    private double enginePower;
    private int nrDoors;
    private double currentSpeed;
    private String modelName;
    private Direction dir;
    private final Size size;
    private double x;
    private double y;
    private boolean isLoaded = false;
    private boolean engineOn = false;

    /**
     * The speedfactor determines the acceleration of a car.
     *
     * @return speedFactor
     */
    public double speedFactor() {
        return enginePower * 0.01;
    }

    // direction is an enum that determines what values shoud go into x,y
    public enum Direction {
        NORTH, WEST, SOUTH, EAST
    }

    public enum Size {
        SMALL, LARGE
    }

    public String getModelName() {
        return modelName;
    }


    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setLoaded(boolean loaded) {
        isLoaded = loaded;
    }

    public void setEngineOn(boolean engineOn) {
        this.engineOn = engineOn;
    }

    public Direction getDir() {
        return dir;
    }

    //constructor
    public Car(Color color, double enginePower, int nrDoors, String modelName, Direction dir, double x, double y, Size size) {
        this.color = color;
        this.enginePower = enginePower;
        this.nrDoors = nrDoors;
        this.currentSpeed = 0;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.size = size;
    }
    public Car(){ this(Color.BLUE, 10, 4, "FinBil", Direction.EAST, 100, 100, Size.SMALL);}

    public Car(double x, double y){
        this(Color.BLUE, 10, 4, "FinBil", Direction.NORTH, x, y, Size.SMALL);
    }


    /**
     * Starts the engine and sets a speed, as long as the car isn't loaded.
     */
    public void startEngine() {
        if (!isLoaded && !isEngineOn()) {
            engineOn = true;
            currentSpeed = 0.1;
        }
    }

    // stop engine
    public void stopEngine() {
        currentSpeed = 0;
        engineOn = false;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    //  gets getcolor
    public Color getColor() {
        return color;
    }

    //  sets color
    public void setColor(Color clr) {
        color = clr;
    }

    // gets enginePower
    public double getEnginePower() {
        return enginePower;
    }

    //  gets nrDoors
    public int getNrDoors() {
        return nrDoors;
    }

    //  gets Currentspeed
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    // sets Currentspeed
    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Size getSize() {
        return size;
    }

    public void setDirection(Direction dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return currentSpeed != 0;
    }

    public boolean isEngineOn() {
        return engineOn;
    }

    /*
     * Increases currentsSpeed based on the objects currentSpeed, speedfactor and input.
     *
     * @param amount
     */
    public void incrementSpeed(double amount) {
        if (engineOn) {
            currentSpeed = getCurrentSpeed() + speedFactor() * amount;
            if (currentSpeed > enginePower) {
                currentSpeed = enginePower;
            }
        }
    }

    /*
     * Decreases currentsSpeed based on the objects currentSpeed and speedfactor.
     *
     * @param amount
     */
    private void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
    }
    //  how the car change speed

    /**
     * Increases the speed based on an amount.
     *
     * @param amount between 0 and 1.
     */
    public void gas(double amount) {
        if (amount <= 1 && amount >= 0) {
            incrementSpeed(amount);
        }
    }

    /**
     * Decreases the speed based on an amount.
     *
     * @param amount between 0 and 1.
     */
    public void brake(double amount) {
        if (amount <= 1 && amount >= 0) {
            decrementSpeed(amount);
        }
    }


    /**
     * Updates the cars position based on direction and currentSpeed.
     */
    public void move() {
        if(isEngineOn()){
            updatePosition();
        }
    }

     void updatePosition() {
        if (dir == Direction.NORTH) {
            this.y -= currentSpeed * 10;
        } else if (dir == Direction.WEST) {
            this.x -= currentSpeed * 10;
        } else if (dir == Direction.SOUTH) {
            this.y += currentSpeed * 10;
        } else if (dir == Direction.EAST) {
            this.x += currentSpeed * 10;
        }
    }


    public void turnLeft() {
        this.changeDirLeft();

    }

     void changeDirLeft() {
        if (dir == Direction.NORTH) {
            dir = Direction.WEST;
        } else if (dir == Direction.WEST) {
            dir = Direction.SOUTH;
        } else if (dir == Direction.SOUTH) {
            dir = Direction.EAST;
        } else if (dir == Direction.EAST) {
            dir = Direction.NORTH;
        }
    }

    public void turnRight() {
        this.changeDirRight();
    }

     void changeDirRight() {
        if (dir == Direction.NORTH) {
            dir = Direction.EAST;
        } else if (dir == Direction.EAST) {
            dir = Direction.SOUTH;
        } else if (dir == Direction.SOUTH) {
            dir = Direction.WEST;
        } else if (dir == Direction.WEST) {
            dir = Direction.NORTH;
        }
    }

    public void invertDirection(){
        this.turnLeft();
        this.turnLeft();
    }


}
