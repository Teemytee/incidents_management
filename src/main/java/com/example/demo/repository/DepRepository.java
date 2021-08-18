package com.example.demo.repository;

import com.example.demo.model.Dep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepRepository extends JpaRepository<Dep, String> {
}
