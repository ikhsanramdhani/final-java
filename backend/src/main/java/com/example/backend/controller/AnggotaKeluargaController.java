package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.backend.model.AnggotaKeluarga;
import com.example.backend.service.anggota_keluarga.IAnggotaKeluargaService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/anggota_keluarga")
public class AnggotaKeluargaController {

    @Autowired
    IAnggotaKeluargaService anggotaKeluargaService;

    @PostMapping("/insert")
    public AnggotaKeluarga insert(@RequestBody AnggotaKeluarga anggotaKeluarga) {
        return anggotaKeluargaService.insert(anggotaKeluarga);
    }

    @GetMapping("/getAnggota")
    public List<AnggotaKeluarga> getAnggota() {
        return anggotaKeluargaService.getAnggota();
    }

    @PutMapping("/updateAnggota/{id}")
    public AnggotaKeluarga updateAnggota(@PathVariable int id, @RequestBody AnggotaKeluarga anggotaKeluarga) {
        return anggotaKeluargaService.updateAnggota(id, anggotaKeluarga);
    }

    @DeleteMapping("/deleteAnggota/{id}")
    public AnggotaKeluarga deleteAnggota(@PathVariable int id) {
        return anggotaKeluargaService.deleteAnggota(id);
    }

    @GetMapping("/getAnggotaById/{id}")
    public List<AnggotaKeluarga> getAnggotaById(@PathVariable int id) {
        return anggotaKeluargaService.getAnggotaById(id);
    }

    @GetMapping("/getListAnggota/{id_kk}")
    public List<AnggotaKeluarga> getListAnggota(@PathVariable int id_kk) {
        return anggotaKeluargaService.getListAnggota(id_kk);
    }

    @DeleteMapping("/deleteAnggotaWithKk/{id_kk}")
    public List<AnggotaKeluarga> deleteAnggotaWithKk(@PathVariable int id_kk) {
        return anggotaKeluargaService.deleteAnggotaWithKk(id_kk);
    }

}
