import http from "@/http-common";

class AnggotaKeluargaService {
  insert(data) {
    return http.post("/anggota_keluarga/insert", data);
  }

  getAnggota() {
    return http.get("/anggota_keluarga/getAnggota");
  }

  updateAnggota(id, data) {
    return http.put(`/anggota_keluarga/updateAnggota/${id}`, data);
  }

  deleteAnggota(id) {
    return http.delete(`/anggota_keluarga/deleteAnggota/${id}`);
  }

  getAnggotaById(id) {
    return http.get(`/anggota_keluarga/getAnggotaById/${id}`);
  }

  getListAnggota(id_kk) {
    return http.get(`/anggota_keluarga/getListAnggota/${id_kk}`);
  }

  deleteAnggotaWithKk(id_kk) {
    return http.delete(`/anggota_keluarga/deleteAnggotaWithKk/${id_kk}`);
  }
}

export default new AnggotaKeluargaService();
