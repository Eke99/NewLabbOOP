/**
 * Interface used for classes which can be moved and turned.
 */

public interface IMovable {

    void move();

    void turnLeft();

    void turnRight();

    double speedFactor();

    double getCurrentSpeed();

    void setCurrentSpeed(double speed);

    void setDirection(Car.Direction direction);

    boolean isMoving();

    double getEnginePower();

    void gas(double amount);

    void brake(double amount);
}
