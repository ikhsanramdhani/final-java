package com.example.backend.service.anggota_keluarga;

import java.util.List;

import com.example.backend.model.AnggotaKeluarga;

public interface IAnggotaKeluargaService {
    public AnggotaKeluarga insert(AnggotaKeluarga anggotaKeluarga);
    public List<AnggotaKeluarga> getAnggota();
    public AnggotaKeluarga updateAnggota(int id, AnggotaKeluarga anggotaKeluarga);
    public AnggotaKeluarga deleteAnggota(int id);
    public List<AnggotaKeluarga> deleteAnggotaWithKk(int id_kk);
    public List<AnggotaKeluarga> getAnggotaById(int id);
    public List<AnggotaKeluarga> getListAnggota(int id_kk);
}
