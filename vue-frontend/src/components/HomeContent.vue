<template>
  <div id="page-content-wrapper">
    <div class="container-fluid">
      <h1>Homepage</h1>
      <div class="mt-5" v-show="!viewSuccessDelete">
        <div class="row">
          <div class="col-sm-3">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Jumlah Kartu Keluarga</h5>
                <h1 class="card-text">{{ dataKk.length }}</h1>
              </div>
            </div>
          </div>
          <div class="col-sm-3">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Jumlah Seluruh Warga</h5>
                <h1 class="card-text">{{ dataAnggota.length }}</h1>
              </div>
            </div>
          </div>
        </div>
        <h2 class="text-center mt-5">Data Kartu Keluarga</h2>
        <table class="table table-striped mt-4">
          <thead>
            <tr>
              <th scope="col">No</th>
              <th scope="col">Nomor KK</th>
              <th scope="col">Alamat</th>
              <th scope="col">Kab / Kota</th>
              <th scope="col">Kode Pos</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
            <tr v-show="!viewTable">
              <th class="h3 text-center" colspan="6">Data belum tersedia</th>
            </tr>

            <tr v-show="viewTable" v-for="(item, index) in dataKk" :key="item">
              <th scope="row">{{ index + 1 }}</th>
              <td>{{ item.nomor_kk }}</td>
              <td>{{ item.alamat }}</td>
              <td>{{ item.kabupaten_kota }}</td>
              <td>{{ item.kode_pos }}</td>
              <td>
                <router-link
                  :to="'/detailKk/' + item.id"
                  type="submit"
                  class="btn btn-primary mr-2"
                >
                  Detail
                </router-link>
                <button
                  @click="deleteKk(item.id)"
                  type="submit"
                  class="btn btn-danger"
                >
                  Delete
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <SendSuccess class="mt-5" v-show="viewSuccessDelete"></SendSuccess>
    </div>
  </div>
</template>

<script>
import SendSuccess from "@/components/SendSuccess.vue";
import KartuKeluargaService from "@/service/KartuKeluargaService";
import AnggotaKeluargaService from "@/service/AnggotaKeluargaService";
import Swal from "sweetalert2";

export default {
  name: "home-content",
  components: {
    SendSuccess,
  },
  data() {
    return {
      dataKk: [
        {
          id: null,
        },
      ],
      viewSuccessDelete: false,
      dataAnggota: null,
      viewTable: false,
    };
  },
  methods: {
    getDataKk() {
      KartuKeluargaService.getKk()
        .then((r) => {
          this.dataKk = r.data;
          console.log(this.dataKk);
          if (this.dataKk[0].id) {
            this.viewTable = true;
          } else {
            this.viewTable = false;
          }
        })
        .catch((e) => {
          console.log(e);
        });
    },
    deleteKk(id) {
      Swal.fire({
        title: "Kamu yakin akan menghapus data ini beserta anggotanya?",
        showCancelButton: true,
        confirmButtonText: "Yakin",
        confirmButtonColor: "#0275d8",
        cancelButtonText: "Ngga",
        cancelButtonColor: "#d9534f",
      }).then((result) => {
        if (result.isConfirmed) {
          KartuKeluargaService.deleteKk(id)
            .then((r) => {
              AnggotaKeluargaService.deleteAnggotaWithKk(id).then((r) => {
                console.log(r.data);
              });
              console.log(r.data);
              this.viewSuccessDelete = true;
            })
            .catch((e) => {
              console.log(e);
            });
        } else if (result.isDismissed) {
          Swal.fire("Hapus dibatalkan", "", "success");
        }
      });
    },
    getJumlahAnggota() {
      AnggotaKeluargaService.getAnggota()
        .then((r) => {
          this.dataAnggota = r.data;
          console.log(this.dataAnggota);
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },
  mounted() {
    this.getDataKk();
    this.getJumlahAnggota();
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
