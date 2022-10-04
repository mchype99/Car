package q3;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @invariant Car object is immutable.
 */
public class Car {
    private final String make;
    private final String model;
    private final Date built;

    /**
     * Constructor for Car class.
     * @param make the make of the car
     * @param model the model of the car
     * @param built the date the care was built
     * @precondition none
     * @postcondition none
     */
    Car(String make, String model, Date built) {
        this.make = make;
        this.model = model;
        this.built = built;
    }

    /**
     * Gets the make of the car.
     * @return - String representation of the car's make.
     * @precondition none
     * @postcondition none
     */
    public String getMake() {
        return make;
    }

    /**
     * Gets the model of the car.
     * @return - String representation of the car's make.
     * @precondition none
     * @postcondition none
     */
    public String getModel() {
        return model;
    }

    /**
     * Gets the date the car was built.
     * @return built date.
     * @precondition none
     * @postcondition returned date is immutable.
     */
    public Date getBuilt() {
        return new Date(this.built.getTime());
    }

    /**
     * String representation of the car object.
     * @return String representation of the car object.
     * @precondition none
     * @postcondition none
     */
    @Override
    public String toString() {
        return this.make + " " + this.model + " built " + this.built.toString();
    }

    public static Comparator<Car> getCompByMakeModel = new Comparator<Car>(){
        public int compare(Car car1, Car car2) {
            if (car1.getMake().compareTo(car2.getMake()) < 0)
                return -1;
            else if (car1.getMake().compareTo(car2.getMake()) > 0)
                return 1;
            else {
                if (car1.getModel().compareTo(car2.getModel()) < 1)
                    return -1;
                else if (car1.getModel().compareTo(car2.getModel()) > 1)
                    return 1;
                else
                    return 0;
            }
        }
    };

    public static Comparator<Car> getCompByDate = new Comparator<Car>() {
        public int compare(Car car1, Car car2) {
            if(car1.getBuilt().compareTo(car2.getBuilt()) < 0)
                return -1;
            else if(car1.getBuilt().compareTo(car2.getBuilt()) > 0)
                return 1;
            else
                return 0;
            }
    };

    public static void main(String args[]) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car("Toyota", "Corolla", formatter.parse("02/23/2018")));
        cars.add(new Car("Nissan", "Maxima", formatter.parse("02/23/2017")));
        cars.add(new Car("Honda", "Civic", formatter.parse("05/23/2019")));
        cars.add(new Car("Ford", "Fusion", formatter.parse("02/20/2020")));

        Collections.sort(cars, Car.getCompByMakeModel);
        System.out.println("Sorted by make and model:");
        System.out.println(cars);
        System.out.println("");

        Collections.sort(cars, Car.getCompByDate);
        System.out.println("Sorted by built date:");
        System.out.println(cars);
    }
}