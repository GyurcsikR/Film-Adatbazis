package hu.progmatic;

public enum AgeLimit {

    UNDEFINED(""),
    I("Korhatár nélkül"),
    II("6 éven aluliak számára nem ajánlott műsorszámok"),
    III("14 éven aluliaknak nem ajánlott"),
    IV("Csak 16 éven felülieknek"),
    V("Csak 18 éven felülieknek");

    public final String value;

    AgeLimit(String value) {
        this.value = value;
    }

    public static AgeLimit getByValue(String value) {
        for (AgeLimit ageLimit : values()) {
            if (ageLimit.value.equals(value)) {
                return ageLimit;
            }
        }
        return UNDEFINED;
    }
}



