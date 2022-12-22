<template>
  <div id="page-content-wrapper">
    <div class="container-fluid">
      <h1>Detail Anggota Keluarga</h1>
      <div class="mt-5" v-show="!viewFormUpdate">
        <div class="row mt-5 ml-1">
          <router-link
            :to="'/detailKk/' + idRoute + '/listAnggota'"
            type="submit"
            class="btn btn-primary mr-2"
          >
            Back
          </router-link>
          <button @click="updateAnggota" type="submit" class="btn btn-success">
            Update Anggota
          </button>
        </div>
        <form
          class="mt-4 rounded p-4"
          style="border: 1px solid rgba(0, 0, 0, 0.2)"
        >
          <div class="form-row">
            <div class="form-group col-md-6">
              <label>NIK</label>
              <input
                type="text"
                v-model="dataAnggota[index].nik"
                class="form-control"
                placeholder="NIK"
                readonly
              />
            </div>
            <div class="form-group col-md-6">
              <label>Tanggal Lahir</label>
              <input
                type="date"
                v-model="dataAnggota[index].tanggal_lahir"
                class="form-control"
                placeholder="Tanggal Lahir"
                readonly
              />
            </div>
            <div class="form-group col-md-6">
              <label>Nama</label>
              <input
                type="text"
                v-model="dataAnggota[index].nama"
                class="form-control"
                placeholder="Nama Lengkap"
                readonly
              />
            </div>
            <div class="form-group col-md-6">
              <label>Agama</label>
              <input
                type="text"
                v-model="dataAnggota[index].agama"
                class="form-control"
                placeholder="Agama"
                readonly
              />
            </div>

            <div class="form-group col-md-6">
              <label>Jenis Kelamin</label>
              <select
                class="custom-select"
                v-model="dataAnggota[index].jenis_kelamin"
                disabled
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
                readonly
              />
            </div>

            <div class="form-group col-md-6">
              <label>Tempat Lahir</label>
              <input
                type="text"
                v-model="dataAnggota[index].tempat_lahir"
                class="form-control"
                placeholder="Tempat Lahir"
                readonly
              />
            </div>

            <div class="form-group col-md-6">
              <label>Kepala Keluarga</label>
              <select
                class="custom-select"
                v-model="dataAnggota[index].kepala_keluarga"
                disabled
              >
                <option selected disabled></option>
                <option>Yes</option>
                <option>No</option>
              </select>
            </div>
          </div>
        </form>
      </div>
      <AnggotaUpdate v-show="viewFormUpdate"></AnggotaUpdate>
    </div>
  </div>
</template>

<script>
import AnggotaKeluargaService from "@/service/AnggotaKeluargaService";
import AnggotaUpdate from "@/components/AnggotaUpdate.vue";

export default {
  name: "detail-anggota",
  components: {
    AnggotaUpdate,
  },
  data() {
    return {
      dataAnggota: {
        id: this.$route.params.idList,
        nik: null,
        nama: null,
        agama: null,
        jenis_kelamin: null,
        pendidikan: null,
        tempat_lahir: null,
        tanggal_lahir: null,
        kepala_keluarga: null,
      },
      index: 0,
      idRoute: this.$route.params.id,
      tes: null,
      viewFormUpdate: false,
    };
  },
  methods: {
    viewAnggota(id) {
      id = this.dataAnggota.id;
      AnggotaKeluargaService.getAnggotaById(id)
        .then((r) => {
          this.dataAnggota = r.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
    updateAnggota() {
      this.viewFormUpdate = true;
    },
  },
  mounted() {
    this.viewAnggota();
  },
};
</script>

<style scoped>
#wrapper {
  padding-left: 0;
  -webkit-transition: all 0.5s ease;
  -moz-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  transition: all 0.5s ease;
}

#wrapper.toggled {
  padding-left: 250px;
}

#sidebar-wrapper {
  z-index: 1000;
  position: fixed;
  left: 250px;
  width: 0;
  height: 100%;
  margin-left: -250px;
  overflow-y: auto;
  background: rgb(2, 117, 216);
  -webkit-transition: all 0.5s ease;
  -moz-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  transition: all 0.5s ease;
}

#wrapper.toggled #sidebar-wrapper {
  width: 250px;
}

#page-content-wrapper {
  width: 100%;
  position: absolute;
  padding: 15px;
}

#wrapper.toggled #page-content-wrapper {
  position: absolute;
  margin-right: -250px;
}

/* Sidebar Styles */

.sidebar-nav {
  position: absolute;
  top: 0;
  width: 250px;
  margin: 0;
  padding: 0;
  list-style: none;
}

.sidebar-nav li {
  text-indent: 20px;
  line-height: 40px;
}

.sidebar-nav li a {
  display: block;
  text-decoration: none;
  color: #fff;
}

.sidebar-nav li a:hover {
  text-decoration: none;
  color: #000;
  background: #fff;
}

.sidebar-nav li a:active,
.sidebar-nav li a:focus {
  text-decoration: none;
}

.sidebar-nav > .sidebar-brand {
  height: 65px;
  font-size: 18px;
  line-height: 60px;
}

.sidebar-nav > .sidebar-brand a {
  color: #aeacac;
}

.sidebar-nav > .sidebar-brand a:hover {
  color: rgb(255, 255, 255);
  background: none;
}

@media (min-width: 768px) {
  #wrapper {
    padding-left: 0;
  }
  #wrapper.toggled {
    padding-left: 250px;
  }
  #sidebar-wrapper {
    width: 0;
  }
  #wrapper.toggled #sidebar-wrapper {
    width: 250px;
  }
  #page-content-wrapper {
    padding: 20px;
    position: relative;
  }
  #wrapper.toggled #page-content-wrapper {
    position: relative;
    margin-right: 0;
  }
}
</style>
