package travel;

// Конкретный тур "Лечение"
public class TreatmentTour extends AbstractTour {

    private String clinicName;

    public TreatmentTour(String name,
                         Transport transport,
                         MealPlan mealPlan,
                         int days,
                         double price,
                         String clinicName) {
        super(name, TourType.TREATMENT, transport, mealPlan, days, price);
        this.clinicName = clinicName;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    @Override
    public String getDetails() {
        return "Клиника: " + clinicName;
    }
}
