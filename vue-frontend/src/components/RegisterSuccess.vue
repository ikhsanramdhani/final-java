<template>
  <div class="card-body border-color rounded bg-white">
    <h5 class="card-title">Success!</h5>
    <p class="card-text">Data Berhasil Terdaftar!</p>
    <router-link to="/" type="submit" class="btn btn-primary text-light">
      Close
    </router-link>
  </div>
</template>

<script>
export default {
  name: "register-success",
};
</script>

<style scoped>
.border-color {
  border: 1px solid rgba(0, 0, 0, 0.4);
}
</style>
