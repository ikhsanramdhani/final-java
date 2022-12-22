<template>
  <div class="p-0">
    <div class="card-body border-color rounded bg-white">
      <h5 class="card-title">Success!</h5>
      <p class="card-text">Data Anggota Berhasil Ditambah!</p>
      <button
        @click="closeClicked"
        type="submit"
        class="btn btn-primary text-light"
      >
        Close
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: "anggota-success",
  methods: {
    closeClicked() {
      window.location.reload();
    },
  },
};
</script>

<style scoped>
.border-color {
  border: 1px solid rgba(0, 0, 0, 0.4);
}
</style>
