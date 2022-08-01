package canovate.codechallenge.mobiledevice.ModelDTO;

public class MobileDeviceDTO {
    private Long id;
    private String model;
    private String brand;
    private canovate.codechallenge.mobiledevice.Enums.os os;
    private String osVersion;

    public MobileDeviceDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public canovate.codechallenge.mobiledevice.Enums.os getOs() {
        return os;
    }

    public void setOs(canovate.codechallenge.mobiledevice.Enums.os os) {
        this.os = os;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MobileDeviceDTO that = (MobileDeviceDTO) o;
        return id.equals(that.id);
    }

}
