package tubryansk.lisitsyn.cars.entity;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer year;
    private Integer run;
    private Integer engineHp;
    private Float engineVolume;
    @Enumerated(EnumType.STRING)
    private CarBrand brand;
    @Enumerated(EnumType.STRING)
    private CarDrive drive;
    @Enumerated(EnumType.STRING)
    private CarTransmission transmission;
    @Enumerated(EnumType.STRING)
    private CarWheel wheel;
    @Enumerated(EnumType.STRING)
    private CarEngineType engineType;
    @Enumerated(EnumType.STRING)
    private CarBody body;
    private String model;
    private String imageName;
    private String date;
    private String color;
    private String comment;

    public Car(Integer year, Integer run, Integer engineHp, Float engineVolume, CarBrand brand, CarDrive drive, CarTransmission transmission, CarWheel wheel, CarEngineType engineType, CarBody body, String model, String date, String color) {
        this.year = year;
        this.run = run;
        this.engineHp = engineHp;
        this.engineVolume = engineVolume;
        this.brand = brand;
        this.drive = drive;
        this.transmission = transmission;
        this.wheel = wheel;
        this.engineType = engineType;
        this.body = body;
        this.model = model;
        this.date = date;
        this.color = color;
    }

    public Car() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRun() {
        return run;
    }

    public void setRun(Integer run) {
        this.run = run;
    }

    public Integer getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(Integer engineHp) {
        this.engineHp = engineHp;
    }

    public Float getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(Float engineVolume) {
        this.engineVolume = engineVolume;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }

    public CarDrive getDrive() {
        return drive;
    }

    public void setDrive(CarDrive drive) {
        this.drive = drive;
    }

    public CarTransmission getTransmission() {
        return transmission;
    }

    public void setTransmission(CarTransmission transmission) {
        this.transmission = transmission;
    }

    public CarWheel getWheel() {
        return wheel;
    }

    public void setWheel(CarWheel wheel) {
        this.wheel = wheel;
    }

    public CarEngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(CarEngineType engineType) {
        this.engineType = engineType;
    }

    public CarBody getBody() {
        return body;
    }

    public void setBody(CarBody body) {
        this.body = body;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
