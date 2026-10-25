package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Race {
    Car leader = null;
    public void calculation(ArrayList<Car> cars, int time) {
        Iterator<Car> carsIt = cars.iterator();
        int distance = 0;
        while(carsIt.hasNext()) {
            Car car = carsIt.next();
            int carDistance = car.speed * time;
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
