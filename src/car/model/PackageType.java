package car.model;

public class PackageType {

    private Long id;
    private String name;
    private String packagetype;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackagetype() {
        return packagetype;
    }

    public void setPackagetype(String packagetype) {
        this.packagetype = packagetype;
    }


    public void assignAssurance(String packagetype) //method
    {
        this.packagetype = packagetype;
    }
}
