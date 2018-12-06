import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController extends JFrame{
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    protected CarView frame;
    // A list of cars, modify if needed
    private List<Car> cars  = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240(0, 100));
        cc.cars.add(new Saab95(0, 0));
        cc.cars.add(new Scania(0, 200));

        // Start a new view and send a reference of self
        cc.frame = new CarView("NeedForSpeed", cc);


        // Start the timer
        cc.timer.start();

    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                intersect(car);
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(x, y, car);
            }
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();
        }
    }

    protected void turboOff() {
        for (Car car : cars) {
            if (car.getClass() == Saab95.class) {
                Saab95 saab95 = (Saab95) car;
                saab95.setTurboOff();
            }
        }

    }

    protected void turboOn() {
        for (Car car : cars) {
            if (car.getClass() == Saab95.class) {
                Saab95 saab95 = (Saab95) car;
                saab95.setTurboOn();
            }
        }
    }

    protected void liftBed(){
        for (Car car : cars) {
            if (car.getClass() == Scania.class) {
                Scania s = (Scania) car;
                s.extendFlak();
            }
        }
    }

    protected void lowerBed(){
        for (Car car : cars) {
            if (car.getClass() == Scania.class) {
                Scania s = (Scania) car;
                s.retractFlak();
            }
        }
    }

    private void intersect(Car car) {
        if (car.getX() + 117 > frame.drawPanel.getPreferredSize().getWidth() || car.getX() < 0
                || car.getY() > frame.drawPanel.getPreferredSize().getHeight() || car.getY() < 0) {
            car.invertDirection();
        }
    }

    protected void start() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    protected void stop() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    // Calls the gas method for each car once
    protected void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.gas(gas);
        }
    }

    protected void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(brake);
        }
    }



}
