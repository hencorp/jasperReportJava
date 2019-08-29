package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PersonDTO implements Serializable {
    private String id;
    private String name;
    private String email;
    private String ket;
    private List<TestList> list;

    public PersonDTO(String id, String name, String email, String ket, List<TestList> list) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.ket = ket;
        this.list = list;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", ket='" + ket + '\'' +
                ", list=" + list +
                '}';
    }

    public PersonDTO() {
    }
}
