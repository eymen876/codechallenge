package canovate.codechallenge.mobiledevice.Entity;

import canovate.codechallenge.mobiledevice.Enums.os;

import javax.persistence.*;

@Entity
@Table
public class MobileDevice {

    @Id
    @SequenceGenerator(
            name= "device_sequence",
            sequenceName = "device_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "device_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private os os;
    @Column(nullable = false)
    private String osVersion;

    public MobileDevice() {
    }

    public Long getId() {
        return id;
    }

    public void setID(Long id){this.id = id;}

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

    public os getOs() {
        return os;
    }

    public void setOs(os os) {
        this.os = os;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    @Override
    public String toString() {
        return "MobileDevice{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", os=" + os +
                ", osVersion='" + osVersion + '\'' +
                '}';
    }
}
