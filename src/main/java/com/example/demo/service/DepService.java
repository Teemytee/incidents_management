package com.example.demo.service;

import com.example.demo.model.Dep;

import java.util.List;

public interface DepService {
    void create(Dep dep);
    List<Dep> readAll();
    Dep read(String name);
    boolean update(Dep dep, String name);
    boolean delete(String name);
}
