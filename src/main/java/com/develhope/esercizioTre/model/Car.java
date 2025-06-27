package com.develhope.esercizioTre.model;

import com.develhope.esercizioTre.enums.TypeColor;
import com.develhope.esercizioTre.enums.CarType;
import jakarta.persistence.*;

@Entity
@Table (name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column (nullable = false)
    private String modelName  ;

    @Column (nullable = false)
    @Enumerated (EnumType.STRING)
    private CarType type ;

    @Column (nullable = false)
    @Enumerated (EnumType.STRING)
    private TypeColor color ;

    @Column(length = 2000)
    private String description ;


    //costruttori
    private Car() {
    }

    public Car(String modelName, CarType type, TypeColor color) {
        this(modelName , type , color , null ) ;

    }

    public Car(String modelName, CarType type, TypeColor color, String description) {
        this.modelName = modelName;
        this.type = type;
        this.color = color;
        this.description = description;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public TypeColor getColor() {
        return color;
    }

    public void setColor(TypeColor color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

    }


