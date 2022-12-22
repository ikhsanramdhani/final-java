<template>
  <main id="wrapper" class="toggled">
    <HomeSidebar></HomeSidebar>
    <AnggotaContent></AnggotaContent>
  </main>
</template>

<script>
import HomeSidebar from "@/components/HomeSidebar.vue";
import AnggotaContent from "@/components/AnggotaContent.vue";
export default {
  name: "anggotaList-views",
  components: { HomeSidebar, AnggotaContent },
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
