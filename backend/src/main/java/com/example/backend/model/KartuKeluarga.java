package com.example.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_kartu_keluarga")
public class KartuKeluarga {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String alamat;
    private String desa_kelurahan;
    private String kabupaten_kota;
    private String kecamatan;
    private int kode_pos;

    @Column(unique = true)
    private long nomor_kk;

    private String provinsi;
    private byte rt;
    private byte rw;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getDesa_kelurahan() {
        return desa_kelurahan;
    }
    public void setDesa_kelurahan(String desa_kelurahan) {
        this.desa_kelurahan = desa_kelurahan;
    }
    public String getKabupaten_kota() {
        return kabupaten_kota;
    }
    public void setKabupaten_kota(String kabupaten_kota) {
        this.kabupaten_kota = kabupaten_kota;
    }
    public String getKecamatan() {
        return kecamatan;
    }
    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }
    public int getKode_pos() {
        return kode_pos;
    }
    public void setKode_pos(int kode_pos) {
        this.kode_pos = kode_pos;
    }
    public long getNomor_kk() {
        return nomor_kk;
    }
    public void setNomor_kk(long nomor_kk) {
        this.nomor_kk = nomor_kk;
    }
    public String getProvinsi() {
        return provinsi;
    }
    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }
    public byte getRt() {
        return rt;
    }
    public void setRt(byte rt) {
        this.rt = rt;
    }
    public byte getRw() {
        return rw;
    }
    public void setRw(byte rw) {
        this.rw = rw;
    }

}
