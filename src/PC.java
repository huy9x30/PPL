/**
 * @overview
 *  Represent an PC object
 *
 * @attributes
 *  int         id
 *  String      model
 *  int         year
 *  String      manufacturer
 *  Set<String> components
 *
 * @object
 *  A typical PC is <model, year, manufacturer, components>
 *
 * @abstract_properties
 *  mutable(model) = true /\ optional(model) = false /\ length(model) = 25 /\
 *  mutable(year) = false /\ optional(year) = false /\ min(year) = 1970 /\
 *  mutable(manufacturer) = false /\ optional(manufacturer) = false /\ length(manufacturer) = 50 /\
 *  mutable(components) = true /\ optional(components) = false
 *
 * @author Huy
 */
public class PC {
    private static int autoId = 1;
    @DomainConstraint(type = "int", mutable = false, optional = false, min = 1)
    private int id;
    @DomainConstraint(type = "String", optional = false, length = 25)
    private String model;
    @DomainConstraint(type = "int", mutable = false, optional = false, min = 1970)
    private int year;
    @DomainConstraint(type = "String", mutable = false, optional = false, length = 50)
    private String manufacturer;
    @DomainConstraint(type = "Set", optional = false)
    private Set components;

    /**
     * @effects
     *  initialise empty PC object
     */
    public PC(){

    }

    /**
     *  @effects
     *   initialise this as PC:<model,year,manufacturer,components>,
     *      where id = autoId
     */
    public PC(String model, int year, String manufacturer, Set components) {
        if(validate(model, year, manufacturer)) {
            this.id = autoId;
            this.model = model;
            this.year = year;
            this.manufacturer = manufacturer;
            this.components = components;
            autoId++;
        }
    }

    /**
     *  @effects
     *      if model is valid, year is valid, manufacturer is valid
     *          return true
     *      else
     *          return false
     *
     */
    public boolean validate(String model, int year, String manufacturer) {
        return (validateModel(model) && validateYear(year) && validateManufacturer(manufacturer));
    }

    /**
     *  @effects
     *      if model is valid
     *          return true
     *      else
     *          return false
     */
    public boolean validateModel(String model) {
        return (model != null && model.length() <= 25);
    }

    /**
     *  @effects
     *      if year is valid
     *          return true
     *      else
     *          return false
     */
    public boolean validateYear(int year) {
            return (year >= 1970);
    }

    /**
     *
     *  @effects
     *      if manufacturer is valid
     *          return true
     *      else
     *          return false
     */
    public boolean validateManufacturer(String manufacturer) {
        return (manufacturer != null && manufacturer.length() <= 50);
    }

    /**
     *  @effects
     *      return model
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
     *  return id
     */
    public int getId(){
        return id;
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
        if (validateModel(model))
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
