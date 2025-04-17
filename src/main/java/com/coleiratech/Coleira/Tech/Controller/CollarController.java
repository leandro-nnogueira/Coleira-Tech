package com.coleiratech.Coleira.Tech.Controller;

import com.coleiratech.Coleira.Tech.Entity.CollarEntity;
import com.coleiratech.Coleira.Tech.Repository.CollarRepository;
import com.coleiratech.Coleira.Tech.Service.CollarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/collar")
public class CollarController {

    private final CollarService service;

    public CollarController(CollarService service) {
        this.service = service;
    }

    @PostMapping("/localization")
    public CollarEntity saveLocation(@RequestBody CollarEntity collar) {
        return service.saveLocaltion(collar);
    }

    @GetMapping("/localization/{id}")
    public ResponseEntity<CollarEntity> getLocationById(@PathVariable UUID id) {
        return service.getLocationById(id).map(collar -> new ResponseEntity<>(collar, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
