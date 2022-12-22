package com.example.backend.service.anggota_keluarga;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.AnggotaKeluarga;
import com.example.backend.repository.anggota_keluarga.IAnggotaKeluargaRepository;

@Service
public class AnggotaKeluargaServiceImpl implements IAnggotaKeluargaService {

    @Autowired
    IAnggotaKeluargaRepository anggotaKeluargaRepository;

    @Override
    public AnggotaKeluarga insert(AnggotaKeluarga anggotaKeluarga) {
        // TODO Auto-generated method stub
        return anggotaKeluargaRepository.insert(anggotaKeluarga);
    }

    @Override
    public List<AnggotaKeluarga> getAnggota() {
        // TODO Auto-generated method stub
        return anggotaKeluargaRepository.getAnggota();
    }

    @Override
    public AnggotaKeluarga updateAnggota(int id, AnggotaKeluarga anggotaKeluarga) {
        // TODO Auto-generated method stub
        return anggotaKeluargaRepository.updateAnggota(id, anggotaKeluarga);
    }

    @Override
    public AnggotaKeluarga deleteAnggota(int id) {
        // TODO Auto-generated method stub
        return anggotaKeluargaRepository.deleteAnggota(id);
    }

    @Override
    public List<AnggotaKeluarga> getAnggotaById(int id) {
        // TODO Auto-generated method stub
        return anggotaKeluargaRepository.getAnggotaById(id);
    }

    @Override
    public List<AnggotaKeluarga> getListAnggota(int id_kk) {
        // TODO Auto-generated method stub
        return anggotaKeluargaRepository.getListAnggota(id_kk);
    }

    @Override
    public List<AnggotaKeluarga> deleteAnggotaWithKk(int id_kk) {
        // TODO Auto-generated method stub
        return anggotaKeluargaRepository.deleteAnggotaWithKk(id_kk);
    }
    
}
