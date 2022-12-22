package com.example.backend.repository.kartu_keluarga;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.backend.model.KartuKeluarga;

@Repository
public class KartuKeluargaRepositoryImpl implements IKartuKeluargaRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public KartuKeluarga insert(KartuKeluarga kartuKeluarga) {
        // TODO Auto-generated method stub
        var query = "INSERT INTO tb_kartu_keluarga (alamat, desa_kelurahan, kabupaten_kota, kecamatan, kode_pos, nomor_kk, provinsi, rt, rw) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            jdbcTemplate.update(query, new Object[] {
                kartuKeluarga.getAlamat(), kartuKeluarga.getDesa_kelurahan(), kartuKeluarga.getKabupaten_kota(),
                kartuKeluarga.getKecamatan(), kartuKeluarga.getKode_pos(), kartuKeluarga.getNomor_kk(),
                kartuKeluarga.getProvinsi(), kartuKeluarga.getRt(), kartuKeluarga.getRw()
            });
            return kartuKeluarga;
        } catch (Exception e) {
            // TODO: handle exception
            KartuKeluarga obj = new KartuKeluarga();
            return obj;
        }

    }

    @Override
    public List<KartuKeluarga> getKk() {
        // TODO Auto-generated method stub
        var query = "SELECT * FROM tb_kartu_keluarga";

        try {
            var result = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(KartuKeluarga.class));
            return result;
        } catch (Exception e) {
            // TODO: handle exception
            List<KartuKeluarga> obj = new ArrayList<>();
            return obj;
        }

    }

    @Override
    public KartuKeluarga updateKk(int id, KartuKeluarga kartuKeluarga) {
        // TODO Auto-generated method stub
        var query = "UPDATE tb_kartu_keluarga SET alamat = ?, desa_kelurahan = ?, kabupaten_kota = ?, kecamatan = ?, kode_pos = ?, nomor_kk = ?, provinsi = ?, rt = ?, rw = ? WHERE id = ?";

        try {
            jdbcTemplate.update(query, new Object[] {
                kartuKeluarga.getAlamat(), kartuKeluarga.getDesa_kelurahan(), kartuKeluarga.getKabupaten_kota(),
                kartuKeluarga.getKecamatan(), kartuKeluarga.getKode_pos(), kartuKeluarga.getNomor_kk(),
                kartuKeluarga.getProvinsi(), kartuKeluarga.getRt(), kartuKeluarga.getRw(), id
            });
            return kartuKeluarga;
        } catch (Exception e) {
            // TODO: handle exception
            KartuKeluarga obj = new KartuKeluarga();
            return obj;
        }

    }
    
    @Override
    public KartuKeluarga deleteKk(int id) {
        // TODO Auto-generated method stub
        var query = "SELECT * FROM tb_kartu_keluarga WHERE id = ?";

        try {
            var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(KartuKeluarga.class), id);

            query = "DELETE FROM tb_kartu_keluarga WHERE id = ?";
            jdbcTemplate.update(query, id);

            return result;
        } catch (Exception e) {
            // TODO: handle exception
            KartuKeluarga obj = new KartuKeluarga();
            return obj;
        }

    }

    @Override
    public List<KartuKeluarga> getKkById(int id) {
        // TODO Auto-generated method stub
        var query = "SELECT * FROM tb_kartu_keluarga WHERE id = ?";

        try {
            var result = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(KartuKeluarga.class),id);
            return result;
        } catch (Exception e) {
            // TODO: handle exception
            List<KartuKeluarga> obj = new ArrayList<>();
            return obj;
        }

    }

    
    
}
