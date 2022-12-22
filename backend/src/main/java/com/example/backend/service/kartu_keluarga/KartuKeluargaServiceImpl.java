package com.example.backend.service.kartu_keluarga;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.KartuKeluarga;
import com.example.backend.repository.kartu_keluarga.IKartuKeluargaRepository;

@Service
public class KartuKeluargaServiceImpl implements IKartuKeluargaService {

    @Autowired
    IKartuKeluargaRepository kartuKeluargaRepository;

    @Override
    public KartuKeluarga insert(KartuKeluarga kartuKeluarga) {
        // TODO Auto-generated method stub
        return kartuKeluargaRepository.insert(kartuKeluarga);
    }

    @Override
    public List<KartuKeluarga> getKk() {
        // TODO Auto-generated method stub
        return kartuKeluargaRepository.getKk();
    }

    @Override
    public KartuKeluarga updateKk(int id, KartuKeluarga kartuKeluarga) {
        // TODO Auto-generated method stub
        return kartuKeluargaRepository.updateKk(id, kartuKeluarga);
    }

    @Override
    public KartuKeluarga deleteKk(int id) {
        // TODO Auto-generated method stub
        return kartuKeluargaRepository.deleteKk(id);
    }

    @Override
    public List<KartuKeluarga> getKkById(int id) {
        // TODO Auto-generated method stub
        return kartuKeluargaRepository.getKkById(id);
    }
    
}
