package com.develhope.esercizioTre.repository;

import com.develhope.esercizioTre.model.Car;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    // nelle interfaccie public è di default puoi anche non metterlo
    Page<Car> findByModelNameContains(String modelName, Pageable pageable);



    Page<Car> findByModelNameLike(String modelName, Pageable pageable) ;




}
