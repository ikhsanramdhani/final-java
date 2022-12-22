package com.example.backend.repository.kartu_keluarga;

import java.util.List;

import com.example.backend.model.KartuKeluarga;

public interface IKartuKeluargaRepository {
    public KartuKeluarga insert(KartuKeluarga kartuKeluarga);
    public List<KartuKeluarga> getKk();
    public KartuKeluarga updateKk(int id, KartuKeluarga kartuKeluarga);
    public KartuKeluarga deleteKk(int id);
    public List<KartuKeluarga> getKkById(int id);
}
