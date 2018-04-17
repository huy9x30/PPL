/**
 * @author Huy
 */
public class PC {
    private static int autoId = 1;
    private int id;
    private String model;
    private int year;
    private String manufacturer;
    private Set<String> components;

    /**
     *
     * @effects
     *   initialise this as PC:<model,year,manufacturer,components>, where id = autoId
     *
     * @abstract_properties
     *  mutable(model) = true /\ optional(model) = false /\ length(model) = 25 /\
     *  mutable(year) = false /\ optional(year) = false /\ min(year) = 1970 /\
     *  mutable(manufacturer) = false /\ optional(manufacturer) = false /\ length(manufacturer) = 50 /\
     *  mutable(components) = true /\ optional(components) = false
     */
    public PC(String model, int year, String manufacturer, Set<String> components) {
        if(valid(model, year, manufacturer)) {
            this.id = autoId;
            this.model = model;
            this.year = year;
            this.manufacturer = manufacturer;
            this.components = components;
            autoId++;
        }
    }

    /**
     *
     * @return
     *
     */
    public boolean valid(String model, int year, String manufacturer) {
        if(validModel(model) && validYear(year) && validManufacturer(manufacturer)){
            return true;
        }
        return false;
    }

    /**
     *  @effects
     *      if(model != null /\ model.length <= 25)
     *          return true
     *      else
     *          return false
     */
    public boolean validModel(String model) {
        if(model != null && model.length() <= 25) {
            return true;
        }
        return false;
    }

    /**
     *  @effects
     *      if(year >= 1970)
     *          return true
     *      else
     *          return false
     */
    public boolean validYear(int year) {
        if(year >= 1970) {
            return true;
        }
        return false;
    }

    /**
     *
     * @effects
     *      if(manufacturer != null /\ manufacturer.length <= 50)
     *          return true
     *      else
     *          return false
     */
    public boolean validManufacturer(String manufacturer) {
        if(manufacturer != null && manufacturer.length() <= 50) {
            return true;
        }
        return false;
    }

    /**
     *
     * @effects
     *  return model
     */
    public String getModel() {
        return model;
    }

    /**
     * @effects
     *  return year
     */
    public int getYear() {
        return year;
    }

    /**
     * @effects
     *  return manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     *  @effects
     *      return components
     */
    public Set getComponents() {
        return components;
    }

    /**
     *  @effects
     *      set this.model = model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     *  @effects
     *      set this.components = components
     */
    public void setComponents(Set components) {
        this.components = components;
    }

    /**
     *  @effects
     *      return PC:<model,year,manufacturer,components>
     */
    @Override
    public String toString() {
        return "PC:<\"" + model + "\",\"" + year + "\",\"" + manufacturer + "\",\"" + components.toString() + "\">";
    }
}
