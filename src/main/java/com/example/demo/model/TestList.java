package com.example.demo.model;

import lombok.Data;

@Data
public class TestList {
    private String no;
    private String barang;

    public TestList(String no, String barang) {
        this.no = no;
        this.barang = barang;
    }

    @Override
    public String toString() {
        return "TestList{" +
                "no='" + no + '\'' +
                ", barang='" + barang + '\'' +
                '}';
    }
}
