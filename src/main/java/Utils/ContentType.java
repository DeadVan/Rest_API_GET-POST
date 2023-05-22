package Utils;

public enum ContentType {
    JSON("application/json"),
    JSON_TYPE("json");

    private final String value;

    ContentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

