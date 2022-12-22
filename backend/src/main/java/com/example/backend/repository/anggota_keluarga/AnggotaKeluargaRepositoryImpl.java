package com.example.backend.repository.anggota_keluarga;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.backend.model.AnggotaKeluarga;

@Repository
public class AnggotaKeluargaRepositoryImpl implements IAnggotaKeluargaRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public AnggotaKeluarga insert(AnggotaKeluarga anggotaKeluarga) {
        // TODO Auto-generated method stub
        var query = "INSERT INTO tb_anggota_keluarga (agama, id_kk, jenis_kelamin, kepala_keluarga, nama, nik, pendidikan, tanggal_lahir, tempat_lahir) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            jdbcTemplate.update(query, new Object[] {
                anggotaKeluarga.getAgama(), anggotaKeluarga.getId_kk(), anggotaKeluarga.getJenis_kelamin(), anggotaKeluarga.getKepala_keluarga(),
                anggotaKeluarga.getNama(), anggotaKeluarga.getNik(), anggotaKeluarga.getPendidikan(), anggotaKeluarga.getTanggal_lahir(), anggotaKeluarga.getTempat_lahir()
            });
            return anggotaKeluarga;
        } catch (Exception e) {
            // TODO: handle exception
            AnggotaKeluarga obj = new AnggotaKeluarga();
            return obj;
        }

    }

    @Override
    public List<AnggotaKeluarga> getAnggota() {
        // TODO Auto-generated method stub
        var query = "SELECT * FROM tb_anggota_keluarga";

        try {
            var result = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class));
            return result;
        } catch (Exception e) {
            // TODO: handle exception
            List<AnggotaKeluarga> obj = new ArrayList<>();
            return obj;
        }

    }

    @Override
    public AnggotaKeluarga updateAnggota(int id, AnggotaKeluarga anggotaKeluarga) {
        // TODO Auto-generated method stub
        var query = "UPDATE tb_anggota_keluarga SET agama = ?, id_kk = ?, jenis_kelamin = ?, kepala_keluarga = ?, nama = ?, nik = ?, pendidikan = ?, tanggal_lahir = ?, tempat_lahir = ? WHERE id = ?";

        try {
            jdbcTemplate.update(query, new Object[] {
                anggotaKeluarga.getAgama(), anggotaKeluarga.getId_kk(), anggotaKeluarga.getJenis_kelamin(), anggotaKeluarga.getKepala_keluarga(),
                anggotaKeluarga.getNama(), anggotaKeluarga.getNik(), anggotaKeluarga.getPendidikan(), anggotaKeluarga.getTanggal_lahir(), 
                anggotaKeluarga.getTempat_lahir(), id
            });
            return anggotaKeluarga;
        } catch (Exception e) {
            // TODO: handle exception
            AnggotaKeluarga obj = new AnggotaKeluarga();
            return obj;
        }

    }

    @Override
    public AnggotaKeluarga deleteAnggota(int id) {
        // TODO Auto-generated method stub
        var query = "SELECT * FROM tb_anggota_keluarga WHERE id = ?";

        try {
            var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class), id);

            query = "DELETE FROM tb_anggota_keluarga WHERE id = ?";
            jdbcTemplate.update(query, id);

            return result;
        } catch (Exception e) {
            // TODO: handle exception
            AnggotaKeluarga obj = new AnggotaKeluarga();
            return obj;
        }

    }

    @Override
    public List<AnggotaKeluarga> getAnggotaById(int id) {
        // TODO Auto-generated method stub
        var query = "SELECT * FROM tb_anggota_keluarga WHERE id = ?";

        try {
            var result = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class),id);
            return result;
        } catch (Exception e) {
            // TODO: handle exception
            List<AnggotaKeluarga> obj = new ArrayList<>();
            return obj;
        }

    }


    @Override
    public List<AnggotaKeluarga> getListAnggota(int id_kk) {
        // TODO Auto-generated method stub
        var query = "SELECT * FROM tb_anggota_keluarga WHERE id_kk = ?";

        try {
            var result = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class),id_kk);
            return result;
        } catch (Exception e) {
            // TODO: handle exception
            List<AnggotaKeluarga> obj = new ArrayList<>();
            return obj;
        }
    }

    @Override
    public List<AnggotaKeluarga> deleteAnggotaWithKk(int id_kk) {
        // TODO Auto-generated method stub
        var query = "SELECT * FROM tb_anggota_keluarga WHERE id_kk = ?";

        try {
            var result = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class),id_kk);

            query = "DELETE FROM tb_anggota_keluarga WHERE id_kk = ?";
            jdbcTemplate.update(query, id_kk);

            return result;
        } catch (Exception e) {
            // TODO: handle exception
            List<AnggotaKeluarga> obj = new ArrayList<>();
            return obj;
        }
    }
    
}
