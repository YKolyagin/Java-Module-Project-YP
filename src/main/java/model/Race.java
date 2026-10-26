package model;

import java.util.Iterator;
import java.util.List;

public class Race {
    Car leader = null;
    public void calculation(List<Car> cars, int time) {
        Iterator<Car> carsIt = cars.iterator();
        int distance = 0;
        while(carsIt.hasNext()) {
            Car car = carsIt.next();
            int carDistance = car.getSpeed() * time;
            if (carDistance > distance) {
                distance = carDistance;
                leader = car;
            }
        }
    }

    public Car getLeader() {
        return leader;
    }
}
