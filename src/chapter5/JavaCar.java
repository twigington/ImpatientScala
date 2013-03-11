package chapter5;

public class JavaCar {
    private final String manufacturer;
    private final String modelName;
    private int modelYear = -1;
    private String licensePlate = "";

    public JavaCar(String manufacturer, String modelName, int modelYear, String licensePlate) {
        this(manufacturer, modelName, modelYear);
        this.licensePlate = licensePlate;
    }

    public JavaCar(String manufacturer, String modelName, int modelYear) {
        this(manufacturer, modelName);
        this.modelYear = modelYear;
    }

    public JavaCar(String manufacturer, String modelName) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
    }

    public JavaCar(String manufacturer, String modelName, String licensePlate) {
        this(manufacturer, modelName);
        this.licensePlate = licensePlate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public int getModelYear() {
        return modelYear;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}
