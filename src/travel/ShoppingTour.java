package travel;

// Конкретный тур "Шопинг"
public class ShoppingTour extends AbstractTour {

    private String mainMall;

    public ShoppingTour(String name,
                        Transport transport,
                        MealPlan mealPlan,
                        int days,
                        double price,
                        String mainMall) {
        super(name, TourType.SHOPPING, transport, mealPlan, days, price);
        this.mainMall = mainMall;
    }

    public String getMainMall() {
        return mainMall;
    }

    public void setMainMall(String mainMall) {
        this.mainMall = mainMall;
    }

    @Override
    public String getDetails() {
        return "Главный ТЦ: " + mainMall;
    }
}
