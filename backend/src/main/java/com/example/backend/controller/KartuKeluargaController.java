package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.backend.model.KartuKeluarga;
import com.example.backend.service.kartu_keluarga.IKartuKeluargaService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/kartu_keluarga")
public class KartuKeluargaController {
    
    @Autowired
    IKartuKeluargaService kartuKeluargaService;

    @PostMapping("/insert")
    public KartuKeluarga insert(@RequestBody KartuKeluarga kartuKeluarga) {
        return kartuKeluargaService.insert(kartuKeluarga);
    }

    @GetMapping("/getKk")
    public List<KartuKeluarga> getKk() {
        return kartuKeluargaService.getKk();
    }

    @PutMapping("/updateKk/{id}")
    public KartuKeluarga updateKk(@PathVariable int id, @RequestBody KartuKeluarga kartuKeluarga) {
        return kartuKeluargaService.updateKk(id, kartuKeluarga);
    }

    @DeleteMapping("/deleteKk/{id}")
    public KartuKeluarga deleteKk(@PathVariable int id) {
        return kartuKeluargaService.deleteKk(id);
    }

    @GetMapping("/getKkById/{id}")
    public List<KartuKeluarga> getKkById(@PathVariable int id) {
        return kartuKeluargaService.getKkById(id);
    }

}
