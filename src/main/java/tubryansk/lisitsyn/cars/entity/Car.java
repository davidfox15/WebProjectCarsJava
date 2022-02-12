package tubryansk.lisitsyn.cars.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Stack;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String brand;
    private String model;
    private Integer year;
    private String imageName;
    private String date;

    public Car() {
    }

    public Car(String brand, String model, Integer year, String date) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String image) {
        this.imageName = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    //    private Integer run;
//    private String body;
//    private String color;
//    private String engineType;
//    private Integer engineVolume;
//    private Integer engineHp;
//    private String equipment;
//    private String drive;
//    private String gear;
//    private String wheel;
//    private String condition;
//    private Integer numberOfOwners;
//    private String image;
//    private String comment;
}
