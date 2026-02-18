package travel;

public enum Transport {
    PLANE("Самолет"),
    TRAIN("Поезд"),
    BUS("Автобус"),
    SHIP("Корабль");

    private final String title;

    Transport(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
