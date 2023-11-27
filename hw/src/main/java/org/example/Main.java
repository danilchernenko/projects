// Черненко Данило Олександрович
// Об'єктно-орієнтоване програмування на мові Java
// Домашнє завдання 5
// ІН-06-2/1
// Часу витрачено : 300хв
// Це моя власна робота

// Ця програма зчитує інфорамцію про машини та двигуни з файлів, далі працює у вигляді меню з цими даними а потім
// зберігає вихідні дані у ті ж файли

package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        boolean menu = true;
        Scanner in = new Scanner(System.in);
        // оголошуємо наш паром
        Ferry ferry = new Ferry("Ferry", "cargo", "IN062", "Ukrainian", vehicleArrayList());

        // головне меню
        while (menu) {
            System.out.println("""
                    Оберіть пункт меню:\s
                    1.Додати новий транспортний засіб
                    2.Видалити транспортний засіб
                    3.Видалити всі транспортні засоби
                    4.Вивести інформацію про транспортний засіб на екран
                    5.Вивести інформацію про транспортні засоби на екран у вигляді таблиці
                    6.Завершити виконання""");

            switch (in.nextInt()) {

                case 1 -> addVehicle(ferry);
                case 2 -> deleteVehicle(ferry);
                case 3 -> clearVehicles(ferry);
                case 4 -> displayVehicle(ferry);
                case 5 -> displayVehicleInfo(ferry);
                default -> {
                    fileWrite(ferry);
                    System.out.println("Виконання завершено ");
                    menu = false;
                }
            }
        }
    }

    public static ArrayList<Vehicle> vehicleArrayList() throws FileNotFoundException {

        File inputVehicles = new File("inputVehicles.txt");
        File inputEngines = new File("inputEngines.txt");
        Scanner vehicles = new Scanner(inputVehicles);
        Scanner engines = new Scanner(inputEngines);
        ArrayList<Vehicle> vehicleArrayList = new ArrayList<>();

        String make, model, yearOfManufacture, engineName;
        double cost, engineCapacity, capacity;
        int numOfPas;

        try {

            // зчитуємо дані з файлів
            while (vehicles.hasNextLine()) {
                make = vehicles.nextLine();
                model = vehicles.nextLine();
                yearOfManufacture = vehicles.nextLine();
                cost = Double.parseDouble(vehicles.nextLine());
                numOfPas = Integer.parseInt(vehicles.nextLine());

                engineName = engines.nextLine();
                engineCapacity = Double.parseDouble(engines.nextLine());
                //         якщо файл має наступну лінію та вона не порожня тоді
                //         дані у файлу не у відповідному форматі
                if (engines.hasNextLine() && !engines.nextLine().isEmpty()) {
                    System.out.println("Дата у файлі з двигунами не корректна");
                }

                capacity = Double.parseDouble(vehicles.nextLine());
                if (numOfPas == 0) vehicleArrayList.add(new Truck(make, model, yearOfManufacture, cost, capacity));
                else vehicleArrayList.add(new Car(make, model, yearOfManufacture, cost, numOfPas,
                        new Engine(engineName, engineCapacity)));
                if (vehicles.hasNextLine() && !vehicles.nextLine().isEmpty()) {
                    System.out.println("Дата у файлі з авто не корректна");
                }
            }

            return vehicleArrayList;
        } catch (Exception e) {
            System.out.println("Дата у файлі не корректна");
        }
        vehicles.close();
        engines.close();
        return vehicleArrayList;
    }

    // запис у файл при завершенні програми
    public static void fileWrite(Ferry ferry) throws IOException {
        FileWriter vehiclesWrite = new FileWriter("inputVehicles.txt");
        FileWriter enginesWrite = new FileWriter("inputEngines.txt");
        ArrayList<Vehicle> vehicles = ferry.getVehicles();
        for (Vehicle vehicle : vehicles) {
            vehiclesWrite.append(vehicle.getMake());
            vehiclesWrite.append("\n").append(vehicle.getModel());
            vehiclesWrite.append("\n").append(vehicle.getYearOfManufacture());
            vehiclesWrite.append("\n").append(Double.toString(vehicle.getCost()));
            vehiclesWrite.append("\n").append(Integer.toString(vehicle.getNumberOfPassangers()));

            vehiclesWrite.append("\n").append(Double.toString(vehicle.getCapacity()));
            vehiclesWrite.append("\n\n");

            enginesWrite.append(vehicle.getEngineName()).append("\n");
            enginesWrite.append(Double.toString(vehicle.getEngineCapacity())).append("\n");
            enginesWrite.append("\n");
        }

        vehiclesWrite.close();
        enginesWrite.close();

    }

    public static void addVehicle(Ferry ferry) {

        boolean menu = true;
        Scanner in = new Scanner(System.in);

        // додавання нової машини
        while (menu) {
            System.out.println("""
                    Оберіть пункт меню:\s
                    1.Додати нову легкову машину
                    2.Додати нову вантажівку
                    3.Вийти
                    """);

            switch (in.nextInt()) {

                case 1 -> ferry.newVehicle(addCar());
                case 2 -> ferry.newVehicle(addTruck());
                default -> menu = false;

            }
        }

    }

    // додавання легкової машини
    public static Car addCar() {

        Scanner in = new Scanner(System.in);
        String make, model, yearOfManufacture, engineName;
        double cost, engineCapacity;
        int numOfPas;
        System.out.print("Введіть марку авто\n ");
        make = in.nextLine();

        System.out.print("Введіть модель\n ");
        model = in.nextLine();

        System.out.print("Введіть рік випуску\n ");
        yearOfManufacture = in.nextLine();

        System.out.print("Введіть вартість\n ");
        cost = in.nextDouble();
        while (cost < 100) {
            System.out.println("Ціна не може бути менше 100\n");
            System.out.print("Введіть вартість\n ");
            cost = in.nextDouble();
        }

        in.nextLine();

        System.out.print("Введіть кількість пасажирів\n ");
        numOfPas = in.nextInt();
        while (numOfPas < 2) {
            System.out.println("Кількість пасажирів не може бути менше 2\n");
            System.out.print("Введіть кількість пасажирів\n ");
            numOfPas = in.nextInt();
        }
        in.nextLine();

        System.out.print("Введіть назву двигуна\n ");
        engineName = in.nextLine();

        System.out.print("Введіть об’єм двигуна\n ");
        engineCapacity = in.nextDouble();
        while (engineCapacity < 0.8) {
            System.out.println("Об’єм двигуна не може бути менше 0.8\n");
            System.out.print("Введіть об’єм двигуна\n ");
            engineCapacity = in.nextDouble();
        }
        in.nextLine();

        return new Car(make, model, yearOfManufacture, cost, numOfPas, new Engine(engineName, engineCapacity));

    }

    // додавання вантажівки
    public static Truck addTruck() {

        Scanner in = new Scanner(System.in);
        String make, model, yearOfManufacture;
        double cost, capacity;

        System.out.print("Введіть марку авто\n ");
        make = in.nextLine();

        System.out.print("Введіть модель\n ");
        model = in.nextLine();

        System.out.print("Введіть рік випуску\n ");
        yearOfManufacture = in.nextLine();

        System.out.print("Введіть вартість\n ");
        cost = in.nextDouble();
        while (cost < 100) {
            System.out.println("Ціна не може бути менше 100\n");
            System.out.print("Введіть вартість\n ");
            cost = in.nextDouble();
        }

        in.nextLine();

        System.out.print("Введіть місткість вантажівки в тонах\n ");
        capacity = in.nextDouble();
        while (capacity < 2.5) {
            System.out.println("Місткість вантажівки не може бути менше 2.5 т\n");
            System.out.print("Введіть місткість вантажівки в тонах\n ");
            capacity = in.nextDouble();
        }
        in.nextLine();

        return new Truck(make, model, yearOfManufacture, cost, capacity);
    }

    public static void deleteVehicle(Ferry ferry) {

        // користувач вводить номер машини яку хоче видалити і якщо цей індекс не більший розміру ArrayList
        // тоді видаляємо машину з таким номером
        ArrayList<Vehicle> vehicles = ferry.getVehicles();
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < vehicles.size(); i++) {

            System.out.println((i + 1) + ") Марка: " + vehicles.get(i).getMake());

        }

        System.out.println("Введіть номер машини яку хочете видалити: ");
        int carToFind = in.nextInt();
        in.nextLine();
        while (carToFind < 1) {
            System.out.println("Номера починаються з одного!");
            carToFind = in.nextInt();
        }
        if (carToFind <= vehicles.size()) {
            vehicles.remove(carToFind - 1);
            System.out.println("Машина видалена!");
        } else System.out.println("Такої машини нема");

    }

    // очищаємо весь наш ArrayList якщо коричтувач підтвердить свою дію
    public static void clearVehicles(Ferry ferry) {

        ArrayList<Vehicle> vehicles = ferry.getVehicles();
        Scanner in = new Scanner(System.in);

        System.out.println("Ви впевнені, що хочете видалити всі транспортні засоби? ");
        System.out.println(" 1 - Так\n 2 - Ні");
        int answer = in.nextInt();
        while (answer != 1 && answer != 2) {
            System.out.println("Введіть лише 1 якщо видалити все або 2 якщо ні");
            answer = in.nextInt();
        }
        in.nextLine();

        if (answer == 1) {
            vehicles.clear();
            System.out.println("Усі транспортні засоби видалено");
        } else System.out.println("Повертаємось");
    }

    // пошук інформації про машину за її моделлю
    public static void displayVehicle(Ferry ferry) {
        ArrayList<Vehicle> vehicles = ferry.getVehicles();
        Scanner in = new Scanner(System.in);
        boolean n = false;

        System.out.println("Введіть модель машини яку хочете вивести: ");
        String modelToFind = in.nextLine();
        while (modelToFind.isEmpty()) {
            System.out.println("Ви нічого не ввели");
            modelToFind = in.nextLine();
        }
        for (Vehicle vehicle : vehicles) {

            String model = vehicle.getModel();

            if (modelToFind.equalsIgnoreCase(model)) {
                System.out.println("Марка: " + vehicle.getMake());
                System.out.println("Модель: " + vehicle.getModel());
                System.out.println("Рік випуску: " + vehicle.getYearOfManufacture());
                System.out.println("Ціна: " + vehicle.getCost());
                System.out.println("К-ть пасажирів: " + vehicle.getNumberOfPassangers());
                System.out.println("Назва двигуна: " + vehicle.getEngineName());
                System.out.println("Об’єм двигуна: " + vehicle.getEngineCapacity());
                System.out.println("Об’єм(якщо вантажівка) " + vehicle.getCapacity());
                n = true;
            }
        }

        if (!n) System.out.println("Такої машини нема");

    }

    // вивід інформації про всі машини на паромі у вигляді таблиці
    public static void displayVehicleInfo(Ferry ferry) {

        ArrayList<Vehicle> vehicles = ferry.getVehicles();

//        Виводимо дані у вигляді таблиці
        String border = "+" + "-".repeat(3) + ("+" + "-".repeat(16)).repeat(7) + "+";

        System.out.println(border);
        System.out.printf("|%2s ", "№");
        System.out.printf("|%-15s ", "Марка");
        System.out.printf("|%-15s ", "Модель");
        System.out.printf("|%-15s ", "Рік випуску");
        System.out.printf("|%-15s ", "Вартість");
        System.out.printf("|%-15s ", "К-ть пасажирів");
        System.out.printf("|%-15s ", "Двигун");
        System.out.printf("|%-15s |\n", "Місткість(тон)");

        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println(border);
            System.out.printf("|%2d ", i + 1);
            System.out.printf("|%-15s ", vehicles.get(i).getMake());
            System.out.printf("|%-15s ", vehicles.get(i).getModel());
            System.out.printf("|%15s ", vehicles.get(i).getYearOfManufacture());
            System.out.printf("|%15.2f ", vehicles.get(i).getCost());
            System.out.printf("|%15d ", vehicles.get(i).getNumberOfPassangers());
            System.out.printf("|%-8s %-4s л ", vehicles.get(i).getEngineName(), vehicles.get(i).getEngineCapacity());
            System.out.printf("|%15.2f |", vehicles.get(i).getCapacity());

            System.out.println();
        }

        System.out.println(border);
    }


}