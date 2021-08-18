package com.example.demo.service;

import com.example.demo.model.Dep;
import com.example.demo.repository.DepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class DepServiceImpl implements DepService{

    @Autowired
    private DepRepository depRepository;


    @Override
    public void create(Dep dep) {
        depRepository.save(dep);
        System.out.println("Получилось добавить: " + dep.getName() +  ", " + dep.getDescript());
    }

    @Override
    public List<Dep> readAll() {
        return depRepository.findAll();
    }

    @Override
    public Dep read(String name) {
        return depRepository.getById(name);
    }

    @Override
    public boolean update(Dep dep, String name) {
        if (depRepository.existsById(name)) {
            dep.setName(name);
            depRepository.save(dep);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String name) {
        if(depRepository.existsById(name)){
            depRepository.deleteById(name);
            return true;
        }
        return false;
    }

}
