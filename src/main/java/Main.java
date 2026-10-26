import java.util.ArrayList;
import java.util.Scanner;
import model.Car;
import model.Race;

public class Main {
    static ArrayList<Car> cars = new ArrayList<>();
    static int time = 24;
    static int maxCars = 3;
    static String errTemplate = "Не правильное здначение скорости %s (целое число от 1 до 250)\n";

    public static void main(String[] args) {
        addCars();
        Race race = new Race();
        race.calculation(cars, time);
        System.out.printf("Самая быстрая машина: %s", race.getLeader().getName());
    }

    static void addCars() {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        while (cars.size() < maxCars) {
            if (name.isEmpty()) {
                System.out.printf("Введите название %d машины\n", cars.size() + 1);
                name = scanner.nextLine();
                if (name.isEmpty()) {
                    System.out.println("Название машины не может быть пустым");
                }
                continue;
            }
            System.out.printf("Введите скорость %d машины\n", cars.size() + 1);
            String input = scanner.nextLine();
            try {
                int speedInput = Integer.parseInt(input);
                if (speedInput > 0 && speedInput <= 250) {
                    cars.add(new Car(name, speedInput));
                } else {
                    System.out.printf(errTemplate, input);
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