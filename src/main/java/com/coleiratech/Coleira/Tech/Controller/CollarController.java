package com.coleiratech.Coleira.Tech.Controller;

import com.coleiratech.Coleira.Tech.Entity.CollarEntity;
import com.coleiratech.Coleira.Tech.Repository.CollarRepository;
import com.coleiratech.Coleira.Tech.Service.CollarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
