<template>
  <div id="page-content-wrapper">
    <div class="container-fluid">
      <h1>Tambah Kartu Keluarga</h1>
      <div class="mt-5" v-show="!viewFormSuccess">
        <router-link to="/home" type="submit" class="btn btn-primary"
          >Back</router-link
        >
        <form
          class="mt-4 rounded p-4"
          style="border: 1px solid rgba(0, 0, 0, 0.2)"
          @submit.prevent="inputKk"
        >
          <div class="form-row">
            <div class="form-group col-md-6">
              <label>Nomor Kartu Keluarga</label>
              <input
                type="text"
                v-model="kkData.nomor_kk"
                class="form-control"
                placeholder="Nomor Kartu Keluarga"
                required
              />
              <small v-show="checkNoKk" class="text-danger"
                >Nomor KK sudah terdaftar</small
              >
            </div>
            <div class="form-group col-md-6">
              <label>Desa / Kelurahan</label>
              <input
                type="text"
                v-model="kkData.desa_kelurahan"
                class="form-control"
                placeholder="Desa / Kelurahan"
                required
              />
            </div>
            <div class="form-group col-md-6">
              <label>Alamat</label>
              <textarea
                class="form-control"
                v-model="kkData.alamat"
                placeholder="Alamat"
                rows="5"
                required
              />
            </div>
            <div class="form-group col-md-6">
              <label>Kecamatan</label>
              <input
                type="text"
                v-model="kkData.kecamatan"
                class="form-control"
                placeholder="Kecamatan"
                required
              />
              <div class="mt-3">
                <label>Kabupaten / Kota</label>
                <input
                  type="text"
                  v-model="kkData.kabupaten_kota"
                  class="form-control"
                  placeholder="Kabupaten / Kota"
                  required
                />
              </div>
            </div>

            <div class="form-group col-md-6">
              <label>RT</label>
              <input
                type="text"
                v-model="kkData.rt"
                class="form-control"
                placeholder="RT"
                required
              />
            </div>

            <div class="form-group col-md-6">
              <label>Provinsi</label>
              <input
                type="text"
                v-model="kkData.provinsi"
                class="form-control"
                placeholder="Provinsi"
                required
              />
            </div>

            <div class="form-group col-md-6">
              <label>RW</label>
              <input
                type="text"
                v-model="kkData.rw"
                class="form-control"
                placeholder="RW"
                required
              />
            </div>

            <div class="form-group col-md-6">
              <label>Kode Pos</label>
              <input
                type="text"
                v-model="kkData.kode_pos"
                class="form-control"
                placeholder="Kode Pos"
                required
              />
            </div>
          </div>
          <button type="submit" class="btn btn-primary mt-4">Submit</button>
        </form>
      </div>
      <SendSuccess class="mt-5" v-show="viewFormSuccess"></SendSuccess>
    </div>
  </div>
</template>

<script>
import SendSuccess from "@/components/SendSuccess.vue";
import KartuKeluargaService from "@/service/KartuKeluargaService";
import Swal from "sweetalert2";

export default {
  name: "kartu-content",
  components: {
    SendSuccess,
  },
  data() {
    return {
      kkData: {
        nomor_kk: null,
        alamat: null,
        desa_kelurahan: null,
        kabupaten_kota: null,
        kode_pos: null,
        kecamatan: null,
        provinsi: null,
        rt: null,
        rw: null,
      },
      viewFormSuccess: false,
      checkNoKk: false,
    };
  },
  methods: {
    inputKk() {
      let data = this.kkData;

      KartuKeluargaService.insert(data)
        .then((r) => {
          console.log(r.data);
          if (r.data.nomor_kk == 0) {
            this.checkNoKk = true;
          } else {
            this.viewFormSuccess = true;
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
