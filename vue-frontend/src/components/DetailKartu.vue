<template>
  <div id="page-content-wrapper">
    <div class="container-fluid">
      <h1>Detail Kartu Keluarga</h1>
      <div class="mb-5" v-show="!viewUpdateForm">
        <div class="row mt-5 ml-1">
          <router-link to="/home" type="submit" class="mr-2 btn btn-primary"
            >Back</router-link
          >
          <button
            @click="viewUpdate"
            type="submit"
            class="mr-2 btn btn-success"
          >
            Update Kartu Keluarga
          </button>
          <router-link
            :to="'/detailKk/' + idRoute + '/listAnggota'"
            type="submit"
            class="btn btn-secondary"
          >
            Lihat Anggota Keluarga
          </router-link>
        </div>
        <form
          class="mt-4 rounded p-4"
          style="border: 1px solid rgba(0, 0, 0, 0.2)"
        >
          <div class="form-row">
            <div class="form-group col-md-6">
              <label>Nomor Kartu Keluarga</label>
              <input
                type="text"
                v-model="kkData[index].nomor_kk"
                class="form-control"
                placeholder="Nomor Kartu Keluarga"
                readonly
              />
            </div>
            <div class="form-group col-md-6">
              <label>Desa / Kelurahan</label>
              <input
                type="text"
                v-model="kkData[index].desa_kelurahan"
                class="form-control"
                placeholder="Desa / Kelurahan"
                readonly
              />
            </div>
            <div class="form-group col-md-6">
              <label>Alamat</label>
              <textarea
                class="form-control"
                v-model="kkData[index].alamat"
                placeholder="Alamat"
                rows="5"
                readonly
              />
            </div>
            <div class="form-group col-md-6">
              <label>Kecamatan</label>
              <input
                type="text"
                v-model="kkData[index].kecamatan"
                class="form-control"
                placeholder="Kecamatan"
                readonly
              />
              <div class="mt-3">
                <label>Kabupaten / Kota</label>
                <input
                  type="text"
                  v-model="kkData[index].kabupaten_kota"
                  class="form-control"
                  placeholder="Kabupaten / Kota"
                  readonly
                />
              </div>
            </div>

            <div class="form-group col-md-6">
              <label>RT</label>
              <input
                type="text"
                v-model="kkData[index].rt"
                class="form-control"
                placeholder="RT"
                readonly
              />
            </div>

            <div class="form-group col-md-6">
              <label>Provinsi</label>
              <input
                type="text"
                v-model="kkData[index].provinsi"
                class="form-control"
                placeholder="Provinsi"
                readonly
              />
            </div>

            <div class="form-group col-md-6">
              <label>RW</label>
              <input
                type="text"
                v-model="kkData[index].rw"
                class="form-control"
                placeholder="RW"
                readonly
              />
            </div>

            <div class="form-group col-md-6">
              <label>Kode Pos</label>
              <input
                type="text"
                v-model="kkData[index].kode_pos"
                class="form-control"
                placeholder="Kode Pos"
                readonly
              />
            </div>
          </div>
        </form>
      </div>
      <KartuUpdate v-show="viewUpdateForm"></KartuUpdate>
    </div>
  </div>
</template>

<script>
import KartuKeluargaService from "@/service/KartuKeluargaService";
import KartuUpdate from "@/components/KartuUpdate.vue";
export default {
  name: "detail-kartu",
  components: {
    KartuUpdate,
  },
  data() {
    return {
      kkData: {
        id: this.$route.params.id,
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
      viewUpdateForm: false,
      index: 0,
      idRoute: this.$route.params.id,
    };
  },
  methods: {
    viewKk(id) {
      id = this.kkData.id;
      KartuKeluargaService.getKkById(id)
        .then((r) => {
          this.kkData = r.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
    viewUpdate() {
      this.viewUpdateForm = true;
    },
  },
  mounted() {
    this.viewKk();
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
