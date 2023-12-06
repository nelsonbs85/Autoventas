package com.autoventas.autos.infrastructure.controllers;


import com.autoventas.autos.application.services.AutoServicio;
import com.autoventas.autos.domain.models.AdditionalAutoInfo;
import com.autoventas.autos.domain.models.Auto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autos")
public class AutoController {

    private final AutoServicio autoServicio;


    public AutoController(AutoServicio autoServicio) {
        this.autoServicio = autoServicio;
    }

    @PostMapping
    public ResponseEntity<Auto> createAuto(@RequestBody Auto auto){
        Auto createdAuto = autoServicio.createAuto(auto);
        return new ResponseEntity<>(createdAuto, HttpStatus.CREATED);
    }

    @GetMapping("/{autoId}")
    public ResponseEntity<Auto> getAutoById(@PathVariable Long autoId) {
        return autoServicio.getAuto(autoId)
                .map(auto -> new ResponseEntity<>(auto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Auto>>getAllAuto(){
        List<Auto> autos = autoServicio.getAllAutos();
        return new ResponseEntity (autos, HttpStatus.OK);
    }

    @PutMapping("/{autoId}")
    public ResponseEntity<Auto> updateTask(@PathVariable Long autoId, @RequestBody Auto updateAuto){
        return autoServicio.updateAuto(autoId,updateAuto)
                .map(auto-> new ResponseEntity<>(auto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{autoId}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long autoId ){
        if(autoServicio.deleteAuto(autoId)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/autoId}/aditionalInfo")
    public ResponseEntity<AdditionalAutoInfo> getAdditionalAutoInfo(@PathVariable Long autoId){
        AdditionalAutoInfo additionalAutoInfo = autoServicio.getAdditionalAutoInfo(autoId);
        return new ResponseEntity<>(additionalAutoInfo, HttpStatus.OK);
    }
}
