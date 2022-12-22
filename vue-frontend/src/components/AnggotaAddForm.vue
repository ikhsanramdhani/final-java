<template>
  <div class="p-0">
    <div class="mt-5">
      <div class="row ml-1" v-show="!viewSuccessForm">
        <button @click="reloadPage" class="btn btn-primary" type="submit">
          Back
        </button>
        <form
          @submit.prevent="inputAnggota"
          class="mt-4 rounded p-4"
          style="border: 1px solid rgba(0, 0, 0, 0.2)"
        >
          <div class="form-row">
            <div class="form-group col-md-6">
              <label>NIK</label>
              <input
                type="text"
                v-model="anggotaData.nik"
                class="form-control"
                placeholder="NIK"
                required
              />
              <small v-show="checkNik" class="text-danger"
                >NIK sudah terdaftar</small
              >
            </div>
            <div class="form-group col-md-6">
              <label>Tanggal Lahir</label>
              <input
                type="date"
                v-model="anggotaData.tanggal_lahir"
                class="form-control"
                required
              />
            </div>
            <div class="form-group col-md-6">
              <label>Nama</label>
              <input
                type="text"
                v-model="anggotaData.nama"
                class="form-control"
                placeholder="Nama Lengkap"
                required
              />
            </div>
            <div class="form-group col-md-6">
              <label>Agama</label>
              <input
                type="text"
                v-model="anggotaData.agama"
                class="form-control"
                placeholder="Agama"
                required
              />
            </div>

            <div class="form-group col-md-6">
              <label>Jenis Kelamin</label>
              <select
                class="custom-select"
                required
                v-model="anggotaData.jenis_kelamin"
              >
                <option selected disabled></option>
                <option>Pria</option>
                <option>Wanita</option>
              </select>
            </div>

            <div class="form-group col-md-6">
              <label>Pendidikan</label>
              <input
                type="text"
                v-model="anggotaData.pendidikan"
                class="form-control"
                placeholder="Pendidikan Terakhir"
                required
              />
            </div>

            <div class="form-group col-md-6">
              <label>Tempat Lahir</label>
              <input
                type="text"
                v-model="anggotaData.tempat_lahir"
                class="form-control"
                placeholder="Tempat Lahir"
                required
              />
            </div>

            <div class="form-group col-md-6">
              <label>Kepala Keluarga</label>
              <select
                class="custom-select"
                required
                v-model="anggotaData.kepala_keluarga"
              >
                <option selected disabled></option>
                <option>Yes</option>
                <option>No</option>
              </select>
            </div>
          </div>
          <button type="submit" class="btn btn-primary mt-4">Submit</button>
        </form>
      </div>
      <AnggotaSuccess v-show="viewSuccessForm"></AnggotaSuccess>
    </div>
  </div>
</template>

<script>
import AnggotaSuccess from "@/components/AnggotaSuccess.vue";
import AnggotaKeluargaService from "@/service/AnggotaKeluargaService";

export default {
  name: "anggota-add",
  components: {
    AnggotaSuccess,
  },
  data() {
    return {
      anggotaData: {
        nik: null,
        id_kk: this.$route.params.id,
        nama: null,
        agama: null,
        jenis_kelamin: null,
        pendidikan: null,
        tempat_lahir: null,
        tanggal_lahir: null,
        kepala_keluarga: null,
      },
      viewSuccessForm: false,
      checkNik: false,
    };
  },
  methods: {
    reloadPage() {
      window.location.reload();
    },
    inputAnggota() {
      let data = this.anggotaData;
      AnggotaKeluargaService.insert(data)
        .then((r) => {
          console.log(r.data);
          if (r.data.nik == 0) {
            this.checkNik = true;
          } else {
            this.viewSuccessForm = true;
          }
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },
};
</script>

<style></style>
