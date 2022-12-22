<template>
  <div class="p-0">
    <div class="mt-5" v-show="!viewSuccessUpdate">
      <div class="mt-5 ml-1">
        <button @click="backClicked" type="submit" class="btn btn-primary mr-2">
          Back
        </button>
      </div>
      <form
        class="mt-4 rounded p-4"
        style="border: 1px solid rgba(0, 0, 0, 0.2)"
        @submit.prevent="updateAnggota"
      >
        <div class="form-row">
          <div class="form-group col-md-6">
            <label>NIK</label>
            <input
              type="text"
              v-model="dataAnggota[index].nik"
              class="form-control"
              placeholder="NIK"
              required
            />
            <small v-show="checkNik" class="text-danger"
              >NIK Sudah Terdaftar</small
            >
          </div>
          <div class="form-group col-md-6">
            <label>Tanggal Lahir</label>
            <input
              type="date"
              v-model="dataAnggota[index].tanggal_lahir"
              class="form-control"
              placeholder="Tanggal Lahir"
              required
            />
          </div>
          <div class="form-group col-md-6">
            <label>Nama</label>
            <input
              type="text"
              v-model="dataAnggota[index].nama"
              class="form-control"
              placeholder="Nama Lengkap"
              required
            />
          </div>
          <div class="form-group col-md-6">
            <label>Agama</label>
            <input
              type="text"
              v-model="dataAnggota[index].agama"
              class="form-control"
              placeholder="Agama"
              required
            />
          </div>

          <div class="form-group col-md-6">
            <label>Jenis Kelamin</label>
            <select
              class="custom-select"
              v-model="dataAnggota[index].jenis_kelamin"
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
              v-model="dataAnggota[index].pendidikan"
              class="form-control"
              placeholder="Pendidikan"
              required
            />
          </div>

          <div class="form-group col-md-6">
            <label>Tempat Lahir</label>
            <input
              type="text"
              v-model="dataAnggota[index].tempat_lahir"
              class="form-control"
              placeholder="Tempat Lahir"
              required
            />
          </div>

          <div class="form-group col-md-6">
            <label>Kepala Keluarga</label>
            <select
              class="custom-select"
              v-model="dataAnggota[index].kepala_keluarga"
            >
              <option selected disabled></option>
              <option>Yes</option>
              <option>No</option>
            </select>
          </div>
          <button
            @click="backClicked"
            type="submit"
            class="btn btn-danger mt-4 mr-2"
          >
            Cancel
          </button>
          <button type="submit" class="btn btn-success mt-4">Update</button>
        </div>
      </form>
    </div>
    <SendSuccess class="mt-5" v-show="viewSuccessUpdate"></SendSuccess>
  </div>
</template>

<script>
import AnggotaKeluargaService from "@/service/AnggotaKeluargaService";
import SendSuccess from "@/components/SendSuccess.vue";
import Swal from "sweetalert2";

export default {
  name: "anggota-update",
  components: {
    SendSuccess,
  },
  data() {
    return {
      dataAnggota: {
        nik: null,
        nama: null,
        agama: null,
        jenis_kelamin: null,
        pendidikan: null,
        tempat_lahir: null,
        tanggal_lahir: null,
        kepala_keluarga: null,
      },
      checkNik: false,
      id: this.$route.params.idList,
      idRoute: this.$route.params.id,
      index: 0,
      viewSuccessUpdate: false,
    };
  },
  methods: {
    viewAnggota(id) {
      id = this.id;
      AnggotaKeluargaService.getAnggotaById(id)
        .then((r) => {
          this.dataAnggota = r.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
    updateAnggota() {
      let id = this.id;
      let data = this.dataAnggota;
      let i = this.index;

      AnggotaKeluargaService.updateAnggota(id, data[i])
        .then((r) => {
          console.log(r.data);
          if (r.data.nik == 0) {
            this.checkNik = true;
          } else {
            this.viewSuccessUpdate = true;
          }
        })
        .catch((e) => {
          console.log(e);
          Swal.fire(
            "Oops...",
            "Sepertinya kamu memasukan data yang salah",
            "warning"
          );
        });
    },
    backClicked() {
      window.location.reload();
    },
  },
  mounted() {
    this.viewAnggota();
  },
};
</script>

<style></style>
