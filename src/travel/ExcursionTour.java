package travel;

// Конкретный тур "Экскурсии"
public class ExcursionTour extends AbstractTour {

    private int excursionsCount;

    public ExcursionTour(String name,
                         Transport transport,
                         MealPlan mealPlan,
                         int days,
                         double price,
                         int excursionsCount) {
        super(name, TourType.EXCURSION, transport, mealPlan, days, price);
        this.excursionsCount = excursionsCount;
    }

    public int getExcursionsCount() {
        return excursionsCount;
    }

    public void setExcursionsCount(int excursionsCount) {
        this.excursionsCount = excursionsCount;
    }

    @Override
    public String getDetails() {
        return "Количество экскурсий: " + excursionsCount;
    }
}
