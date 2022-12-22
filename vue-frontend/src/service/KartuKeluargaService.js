import http from "@/http-common";

class KartuKeluargaService {
  insert(data) {
    return http.post("/kartu_keluarga/insert", data);
  }

  getKk() {
    return http.get("/kartu_keluarga/getKk");
  }

  updateKk(id, data) {
    return http.put(`/kartu_keluarga/updateKk/${id}`, data);
  }

  deleteKk(id) {
    return http.delete(`/kartu_keluarga/deleteKk/${id}`);
  }

  getKkById(id) {
    return http.get(`/kartu_keluarga/getKkById/${id}`);
  }
}

export default new KartuKeluargaService();
