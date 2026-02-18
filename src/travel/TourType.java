package travel;

public enum TourType {
    REST("Отдых"),
    EXCURSION("Экскурсии"),
    TREATMENT("Лечение"),
    SHOPPING("Шопинг"),
    CRUISE("Круиз");

    private final String title;

    TourType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
