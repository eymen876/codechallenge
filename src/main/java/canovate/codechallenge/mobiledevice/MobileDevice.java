package canovate.codechallenge.mobiledevice;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table
public class MobileDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
