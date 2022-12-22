<template>
  <div class="card-body border-color rounded bg-white">
    <h5 class="card-title">Success!</h5>
    <p class="card-text">{{ `${textVal} !` }}</p>
    <router-link
      v-show="!btnView"
      :to="locRoute"
      type="submit"
      class="btn btn-primary text-light"
      >Close</router-link
    >
    <button
      @click="homeReload"
      v-show="btnView"
      type="submit"
      class="btn btn-primary text-light"
    >
      Close
    </button>
  </div>
</template>

<script>
export default {
  name: "send-success",
  data() {
    return {
      textVal: "Data Berhasil Dihapus",
      currentPath: null,
      locRoute: "/home",
      btnView: false,
      id: this.$route.params.id,
      idList: this.$route.params.idList,
    };
  },
  methods: {
    cekPath() {
      if (this.currentPath == "/home") {
        this.textVal = "Data KK Berhasil Dihapus";
        this.btnView = true;
      } else if (this.currentPath == "/addKk") {
        this.textVal = "Data Berhasil Ditambahkan";
        this.locRoute = "/home";
      } else if (this.currentPath == `/detailKk/${this.id}/listAnggota`) {
        this.textVal = "Data Anggota Berhasil Dihapus";
        this.btnView = true;
      } else if (
        this.currentPath ==
        `/detailKk/${this.id}/listAnggota/detailAnggota/${this.idList}`
      ) {
        this.textVal = "Data Anggota Berhasil Diupdate";
        this.btnView = true;
      }
    },
    homeReload() {
      window.location.reload();
    },
  },
  mounted() {
    this.currentPath = this.$route.path;
    this.cekPath();
  },
};
</script>

<style scoped>
.border-color {
  border: 1px solid rgba(0, 0, 0, 0.4);
}
</style>
