<template>
  <div id="page-content-wrapper">
    <div class="container-fluid">
      <h1>{{ headVal }}</h1>
      <div class="p-0" v-show="!viewForm">
        <div class="mt-5" v-show="!viewSuccessDelete">
          <div class="row ml-1">
            <router-link
              :to="'/detailKk/' + idRoute"
              type="submit"
              class="mr-2 btn btn-primary"
              >Back</router-link
            >
            <button
              @click="viewFormAdd"
              type="submit"
              class="btn btn-secondary"
            >
              Tambah Anggota Keluarga
            </button>
          </div>
          <table class="table table-striped mt-4">
            <thead>
              <tr>
                <th scope="col">No</th>
                <th scope="col">NIK</th>
                <th scope="col">Nama</th>
                <th scope="col">Jenis Kelamin</th>
                <th scope="col">Kepala Keluarga</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody>
              <tr v-show="!viewTable">
                <th class="h3 text-center" colspan="6">Data belum tersedia</th>
              </tr>

              <tr
                v-show="viewTable"
                v-for="(item, index) in dataAnggota"
                :key="item"
              >
                <th scope="row">{{ index + 1 }}</th>
                <td>{{ item.nik }}</td>
                <td>{{ item.nama }}</td>
                <td>{{ item.jenis_kelamin }}</td>
                <td>{{ item.kepala_keluarga }}</td>
                <td>
                  <router-link
                    :to="
                      '/detailKk/' +
                      idRoute +
                      '/listAnggota/detailAnggota/' +
                      dataAnggota[index].id
                    "
                    type="submit"
                    class="btn btn-primary mr-2"
                  >
                    Detail
                  </router-link>
                  <button
                    @click="deleteAnggota(item.id)"
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
      </div>
      <SendSuccess class="mt-5" v-show="viewSuccessDelete"></SendSuccess>
      <AnggotaAddForm v-show="viewForm"></AnggotaAddForm>
    </div>
  </div>
</template>

<script>
import AnggotaAddForm from "@/components/AnggotaAddForm.vue";
import AnggotaKeluargaService from "@/service/AnggotaKeluargaService";
import SendSuccess from "@/components/SendSuccess.vue";
import Swal from "sweetalert2";

export default {
  name: "anggota-content",
  components: {
    AnggotaAddForm,
    SendSuccess,
  },
  data() {
    return {
      dataAnggota: [{ id: null }],
      viewTable: false,
      viewSuccessDelete: false,
      viewForm: false,
      idRoute: this.$route.params.id,
      headVal: "Daftar Anggota Keluarga",
    };
  },
  methods: {
    viewFormAdd() {
      this.viewForm = true;
      this.headVal = "Tambah Anggota Keluarga";
    },
    getAnggota(id) {
      id = this.idRoute;

      AnggotaKeluargaService.getListAnggota(id)
        .then((r) => {
          this.dataAnggota = r.data;
          if (this.dataAnggota[0].id) {
            this.viewTable = true;
          } else {
            this.viewTable = false;
          }
        })
        .catch((e) => {
          console.log(e);
        });
    },
    deleteAnggota(id) {
      Swal.fire({
        title: "Kamu yakin akan menghapus data ini?",
        showCancelButton: true,
        confirmButtonText: "Yakin",
        confirmButtonColor: "#0275d8",
        cancelButtonText: "Ngga",
        cancelButtonColor: "#d9534f",
      }).then((r) => {
        if (r.isConfirmed) {
          AnggotaKeluargaService.deleteAnggota(id)
            .then((r) => {
              console.log(r.data);
              this.viewSuccessDelete = true;
            })
            .catch((e) => {
              console.log(e);
            });
        } else if (r.isDismissed) {
          Swal.fire("Hapus dibatalkan", "", "success");
        }
      });
    },
  },
  mounted() {
    this.getAnggota();
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
