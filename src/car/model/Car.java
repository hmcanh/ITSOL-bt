package car.model;

import java.util.Date;

public class Car {
    private Long id;
    private String name;
    private String numberPlate;
    private Integer yearOfManufacture;
    private String brand;
    private Boolean haveInsurance;
    private Boolean havePositioningDevice;
    private Long actionDuration;
    private Long havePowerSteering;

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

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public Integer getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Integer yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Boolean getHaveInsurance() {
        return haveInsurance;
    }

    public void setHaveInsurance(Boolean haveInsurance) {
        this.haveInsurance = haveInsurance;
    }

    public Boolean getHavePositioningDevice() {
        return havePositioningDevice;
    }

    public void setHavePositioningDevice(Boolean havePositioningDevice) {
        this.havePositioningDevice = havePositioningDevice;
    }

    public Long getActionDuration() {
        return actionDuration;
    }

    public void setActionDuration(Long actionDuration) {
        this.actionDuration = actionDuration;
    }

    public Long getHavePowerSteering() {
        return havePowerSteering;
    }

    public void setHavePowerSteering(Long havePowerSteering) {
        this.havePowerSteering = havePowerSteering;
    }
}