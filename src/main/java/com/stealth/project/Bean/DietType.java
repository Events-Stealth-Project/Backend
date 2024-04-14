package com.stealth.project.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "diet_types")
public class DietType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "DietName")
    private String DietName;

    public DietType(int id, String dietName) {
        this.id = id;
        DietName = dietName;
    }

    public DietType(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDietName() {
        return DietName;
    }

    public void setDietName(String dietName) {
        DietName = dietName;
    }
}
