import travel.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<AbstractTour> tours = createSampleTours();
        Scanner scanner = new Scanner(System.in, java.nio.charset.StandardCharsets.UTF_8);

        System.out.println("Добро пожаловать в туристическое агентство!");

        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("Выберите действие:");
            System.out.println("1. Показать все путевки");
            System.out.println("2. Фильтр по типу тура");
            System.out.println("3. Фильтр по транспорту");
            System.out.println("4. Фильтр по количеству дней");
            System.out.println("5. Сортировка по цене (возрастание)");
            System.out.println("6. Сортировка по количеству дней (возрастание)");
            System.out.println("7. Забронировать тур");
            System.out.println("0. Выход");
            System.out.print("Ваш выбор: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> printTours(tours);
                case "2" -> filterByType(tours, scanner);
                case "3" -> filterByTransport(tours, scanner);
                case "4" -> filterByDays(tours, scanner);
                case "5" -> sortByPrice(tours);
                case "6" -> sortByDays(tours);
                case "7" -> bookTour(tours, scanner);
                case "0" -> running = false;
                default -> System.out.println("Неизвестная команда.");
            }
        }

        System.out.println("До свидания!");
    }

    private static List<AbstractTour> createSampleTours() {
        List<AbstractTour> tours = new ArrayList<>();
        tours.add(new RestTour("Анталия All Inclusive",
                Transport.PLANE, MealPlan.ALL_INCLUSIVE, 7, 850.0, true));
        tours.add(new ExcursionTour("Прага + Вена",
                Transport.BUS, MealPlan.BREAKFAST, 6, 520.0, 5));
        tours.add(new TreatmentTour("Минеральные воды",
                Transport.TRAIN, MealPlan.FULL_BOARD, 14, 1100.0, "Санаторий \"Источник\""));
        tours.add(new ShoppingTour("Милан Шопинг",
                Transport.PLANE, MealPlan.NONE, 4, 690.0, "Galleria Vittorio Emanuele II"));
        tours.add(new CruiseTour("Средиземноморский круиз",
                Transport.SHIP, MealPlan.ALL_INCLUSIVE, 10, 1500.0, "SeaDream"));
        return tours;
    }

    private static void printTours(List<AbstractTour> tours) {
        if (tours.isEmpty()) {
            System.out.println("Нет доступных туров.");
            return;
        }
        System.out.println("Список туров:");
        for (int i = 0; i < tours.size(); i++) {
            System.out.println((i + 1) + ". " + tours.get(i));
        }
    }

    private static void filterByType(List<AbstractTour> tours, Scanner scanner) {
        System.out.println("Доступные типы туров:");
        for (TourType type : TourType.values()) {
            System.out.println(type.ordinal() + 1 + ". " + type.getTitle());
        }
        System.out.print("Выберите тип (номер): ");
        String input = scanner.nextLine();
        int idx;
        try {
            idx = Integer.parseInt(input) - 1;
            if (idx < 0 || idx >= TourType.values().length) {
                System.out.println("Некорректный номер.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод.");
            return;
        }
        TourType selected = TourType.values()[idx];
        List<AbstractTour> result = tours.stream()
                .filter(t -> t.getType() == selected)
                .collect(Collectors.toList());
        printTours(result);
    }

    private static void filterByTransport(List<AbstractTour> tours, Scanner scanner) {
        System.out.println("Доступные виды транспорта:");
        for (Transport transport : Transport.values()) {
            System.out.println(transport.ordinal() + 1 + ". " + transport.getTitle());
        }
        System.out.print("Выберите транспорт (номер): ");
        String input = scanner.nextLine();
        int idx;
        try {
            idx = Integer.parseInt(input) - 1;
            if (idx < 0 || idx >= Transport.values().length) {
                System.out.println("Некорректный номер.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод.");
            return;
        }
        Transport selected = Transport.values()[idx];
        List<AbstractTour> result = tours.stream()
                .filter(t -> t.getTransport() == selected)
                .collect(Collectors.toList());
        printTours(result);
    }

    private static void filterByDays(List<AbstractTour> tours, Scanner scanner) {
        System.out.print("Минимальное количество дней: ");
        String minStr = scanner.nextLine();
        System.out.print("Максимальное количество дней: ");
        String maxStr = scanner.nextLine();
        try {
            int min = Integer.parseInt(minStr);
            int max = Integer.parseInt(maxStr);
            if (min > max) {
                System.out.println("Минимум не может быть больше максимума.");
                return;
            }
            List<AbstractTour> result = tours.stream()
                    .filter(t -> t.getDays() >= min && t.getDays() <= max)
                    .collect(Collectors.toList());
            printTours(result);
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод.");
        }
    }

    private static void sortByPrice(List<AbstractTour> tours) {
        List<AbstractTour> sorted = tours.stream()
                .sorted(Comparator.comparingDouble(AbstractTour::getPrice))
                .collect(Collectors.toList());
        printTours(sorted);
    }

    private static void sortByDays(List<AbstractTour> tours) {
        List<AbstractTour> sorted = tours.stream()
                .sorted(Comparator.comparingInt(AbstractTour::getDays))
                .collect(Collectors.toList());
        printTours(sorted);
    }

    private static void bookTour(List<AbstractTour> tours, Scanner scanner) {
        printTours(tours);
        if (tours.isEmpty()) {
            return;
        }
        System.out.print("Введите номер тура для бронирования: ");
        String input = scanner.nextLine();
        try {
            int idx = Integer.parseInt(input) - 1;
            if (idx < 0 || idx >= tours.size()) {
                System.out.println("Некорректный номер.");
                return;
            }
            AbstractTour tour = tours.get(idx);
            // Полиморфизм: вызываем метод интерфейса Bookable
            tour.book();
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод.");
        }
    }
}
