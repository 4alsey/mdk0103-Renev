package travel;

public enum MealPlan {
    NONE("Без питания"),
    BREAKFAST("Завтрак"),
    HALF_BOARD("Полупансион"),
    FULL_BOARD("Полный пансион"),
    ALL_INCLUSIVE("Все включено");

    private final String title;

    MealPlan(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
