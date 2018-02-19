
/**
 * @overview A class define object PC
 * @author huynq
 */
public class PC {

    /**
     * String model
     * int year
     * String manufacturer
     * Set components
     */
    private String model;
    private int year;
    private String manufacturer;
    Set components = new Set();

    /**
     *
     * @param model
     * @param year
     * @param manufacturer
     * @param components
     */
    public PC(String model, int year, String manufacturer, Set components) {
        if(validate(model, year, manufacturer,components)) {
            this.model = model;
            this.year = year;
            this.manufacturer = manufacturer;
            this.components = components;
        }
    }

    /**
     *
     * @param model
     * @param year
     * @param manufacturer
     * @param components
     * @return
     */
    public boolean validate(String model, int year, String manufacturer, Set components) {
        if(validateModel(model) && validateYear(year) && validateManufacturer(manufacturer) && validateComponents(components))  {
            return true;
        }
        return false;
    }

    /**
     *
     * @param model
     * @return
     */
    public boolean validateModel(String model) {
        if(model != null && model.length() <= 25) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param year
     * @return
     */
    public boolean validateYear (int year) {
        if (year >= 1970) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param manufacturer
     * @return
     */
    public boolean validateManufacturer (String manufacturer) {
        if (manufacturer != null && manufacturer.length() <= 50) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param components
     * @return
     */
    public boolean validateComponents (Set components) {
        if (components != null) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return
     */
    public String getModel() {
        return model;
    }

    /**
     *
     * @return
     */
    public int getYear() {
        return year;
    }

    /**
     *
     * @return
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     *
     * @return
     */
    public Set getComponents() {
        return components;
    }

    /**
     *
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     *
     * @param components
     */
    public void setComponents(Set components) {
        this.components = components;
    }

    /**
     *
     * @return
     */
    public String toString() {
        return "";
    }
}
