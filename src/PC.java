/**
 * @author Huy
 */
public class PC {
    private String model;
    private int year;
    private String manufacturer;
    private Set<String> components;

    /**
     * PC constructor
     *
     * @param model
     * @param year
     * @param manufacturer
     * @param components
     */
    public PC(String model, int year, String manufacturer, Set<String> components) {
        if(valid(model, year, manufacturer)) {
            this.model = model;
            this.year = year;
            this.manufacturer = manufacturer;
            this.components = components;
        }
    }

    public boolean valid(String model, int year, String manufacturer) {
        if(validModel(model) && validYear(year) && validManufacturer(manufacturer)){
            return true;
        }
        return false;
    }

    public boolean validModel(String model) {
        if(model != null && model.length() <= 25) {
            return true;
        }
        return false;
    }

    public boolean validYear(int year) {
        if(year >= 1970) {
            return true;
        }
        return false;
    }

    public boolean validManufacturer(String manufacturer) {
        if(manufacturer != null && manufacturer.length() <= 50) {
            return true;
        }
        return false;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Set getComponents() {
        return components;
    }


    public void setModel(String model) {
        this.model = model;
    }

    public void setComponents(Set components) {
        this.components = components;
    }

    @Override
    public String toString() {
        return "PC<\"" + model + "\",\"" + year + "\",\"" + manufacturer + "\",\"" + components.toString() + "\">";
    }
}
