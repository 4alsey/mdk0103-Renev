package travel;

import java.util.Objects;

// Абстрактный класс — общая часть всех туров
public abstract class AbstractTour implements Bookable {

    private String name;
    private TourType type;
    private Transport transport;
    private MealPlan mealPlan;
    private int days;
    private double price;

    protected AbstractTour(String name,
                           TourType type,
                           Transport transport,
                           MealPlan mealPlan,
                           int days,
                           double price) {
        this.name = name;
        this.type = type;
        this.transport = transport;
        this.mealPlan = mealPlan;
        this.days = days;
        this.price = price;
    }

    // Инкапсуляция: геттеры/сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TourType getType() {
        return type;
    }

    public void setType(TourType type) {
        this.type = type;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public MealPlan getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Дополнительный абстрактный метод, чтобы подклассы могли добавить свою специфику
    public abstract String getDetails();

    @Override
    public void book() {
        System.out.println("Тур \"" + name + "\" забронирован.");
    }

    @Override
    public String toString() {
        return String.format(
                "%s (%s), транспорт: %s, питание: %s, дней: %d, цена: %.2f, детали: %s",
                name,
                type.getTitle(),
                transport.getTitle(),
                mealPlan.getTitle(),
                days,
                price,
                getDetails()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractTour that = (AbstractTour) o;
        return days == that.days
                && Double.compare(that.price, price) == 0
                && Objects.equals(name, that.name)
                && type == that.type
                && transport == that.transport
                && mealPlan == that.mealPlan;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, transport, mealPlan, days, price);
    }
}
