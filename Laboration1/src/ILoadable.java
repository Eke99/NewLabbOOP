import java.util.List;

/**
 * Interface for vehicles with the ability to load cars.
 */

public interface ILoadable {

    void extendFlak();

    void retractFlak();

    boolean loadCar(Car c);

    Car unloadCar();

    List<Car> getLoadedCars();

}
