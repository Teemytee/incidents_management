package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "dep")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Dep {

    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "descript")
    private String descript;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }
}
