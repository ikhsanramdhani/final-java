<template>
  <div class="p-0">
    <div class="card-body border-color rounded bg-white">
      <h5 class="card-title">Success!</h5>
      <p class="card-text">Data KK Berhasil Diupdate!</p>
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
  name: "kartu-update-success",
  data() {
    return {
      viewDetail: false,
    };
  },
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
