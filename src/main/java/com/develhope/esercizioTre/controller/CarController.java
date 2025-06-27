package com.develhope.esercizioTre.controller;

import com.develhope.esercizioTre.dto.APIResponse;
import com.develhope.esercizioTre.model.Car;
import com.develhope.esercizioTre.repository.CarRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarRepository carRepo ;

    @PostMapping
    public ResponseEntity<APIResponse> creation(@RequestBody Car car) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new APIResponse(carRepo.save(car))) ;

    }

    @GetMapping
    public ResponseEntity<APIResponse> getAllCars() {

        return ResponseEntity.status(HttpStatus.OK)
        .body(new APIResponse(carRepo.findAll()));

    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse>  findById(@PathVariable ("id") Long id) {
        Optional<Car> opt = carRepo.findById(id);
        if(opt.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new APIResponse(opt.get()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIResponse("car not found")) ;

    }

    @PostMapping("/{id}")
    public ResponseEntity<APIResponse> update(@PathVariable ("id") long id , @RequestBody Car car) {
        boolean exists = carRepo.existsById(id);
        if(!exists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIResponse("car not found")) ;
        }

        Optional<Car> car1  = carRepo.findById(id) ;
        if(car1.isPresent()) {
            car1.get().setType(car.getType());
           Car risultato = carRepo.save(car1.get()) ;
            return ResponseEntity.status(HttpStatus.OK).body(new APIResponse(risultato));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIResponse("car not found")) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteById(@PathVariable ("id") long id) {
        Optional<Car> opt = carRepo.findById(id);
        if (opt.isPresent()) {

            carRepo.deleteById(id);

            return ResponseEntity.status(HttpStatus.OK).body(new APIResponse(opt.get()));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIResponse("element not found")) ;
    }

    @DeleteMapping()
    public ResponseEntity<APIResponse> delete(){
        carRepo.deleteAll();

        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("element are deleted", true));
        }


//    @GetMapping("/All")
//    public ResponseEntity<APIResponse> getAllCar() {
//        Pageable pageable = PageRequest.of(pageNumber , pageSize , Sort.by(""))
//        carRepo.findAll(pageable)
//
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(new APIResponse(carRepo.findAll()));
//
//    }
}
