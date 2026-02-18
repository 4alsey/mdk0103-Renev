package travel;

// Конкретный тур "Круиз"
public class CruiseTour extends AbstractTour {

    private String shipName;

    public CruiseTour(String name,
                      Transport transport,
                      MealPlan mealPlan,
                      int days,
                      double price,
                      String shipName) {
        super(name, TourType.CRUISE, transport, mealPlan, days, price);
        this.shipName = shipName;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    @Override
    public String getDetails() {
        return "Корабль: " + shipName;
    }
}
