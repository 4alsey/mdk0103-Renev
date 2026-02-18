package travel;

// Конкретный тур "Отдых"
public class RestTour extends AbstractTour {

    private boolean hasBeachAccess;

    public RestTour(String name,
                    Transport transport,
                    MealPlan mealPlan,
                    int days,
                    double price,
                    boolean hasBeachAccess) {
        super(name, TourType.REST, transport, mealPlan, days, price);
        this.hasBeachAccess = hasBeachAccess;
    }

    public boolean isHasBeachAccess() {
        return hasBeachAccess;
    }

    public void setHasBeachAccess(boolean hasBeachAccess) {
        this.hasBeachAccess = hasBeachAccess;
    }

    @Override
    public String getDetails() {
        return hasBeachAccess ? "Пляж рядом" : "Без прямого доступа к пляжу";
    }
}
