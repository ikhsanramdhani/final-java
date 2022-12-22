<template>
  <main id="wrapper" class="toggled">
    <HomeSidebar></HomeSidebar>
    <DetailKartu></DetailKartu>
  </main>
</template>

<script>
import HomeSidebar from "@/components/HomeSidebar.vue";
import DetailKartu from "@/components/DetailKartu.vue";
export default {
  name: "kkDetail-views",
  components: {
    HomeSidebar,
    DetailKartu,
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

@media (min-width: 768px) {
  #wrapper {
    padding-left: 0;
  }
  #wrapper.toggled {
    padding-left: 250px;
  }
}
</style>
