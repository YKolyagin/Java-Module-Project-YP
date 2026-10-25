import java.util.ArrayList;
import java.util.Scanner;
import model.Car;
import model.Race;

public class Main {
    static ArrayList<Car> cars = new ArrayList<>();
    static int time = 24;
    static int maxCars = 3;
    static String errTemplate = "Не правильное здначение скорости %d (целое число от 1 до 250)\n";

    public static void main(String[] args) {
        addCars();
        Race race = new Race();
        race.calculation(cars, time);
        System.out.printf("Самая быстрая машина: %s", race.getLeader().name);
    }

    static void addCars() {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        while (cars.size() < maxCars) {
            if (name.isEmpty()) {
                System.out.printf("Введите название %d машины\n", cars.size() + 1);
                name = scanner.nextLine();
                continue;
            }
            System.out.printf("Введите скорость %d машины\n", cars.size() + 1);
            String input = scanner.nextLine();
            try {
                int speedInput = Integer.parseInt(input);
                if (speedInput > 0 && speedInput <= 250) {
                    cars.add(new Car(name, speedInput));
                } else {
                    System.out.printf(errTemplate, speedInput);
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.printf(errTemplate, input);
                continue;
            }
            name = "";
        }
        scanner.close();
    }
}