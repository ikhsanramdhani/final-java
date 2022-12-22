<template>
  <main id="wrapper" class="toggled">
    <KartuSidebar></KartuSidebar>
    <KartuContent></KartuContent>
  </main>
</template>

<script>
import KartuSidebar from "@/components/KartuSidebar.vue";
import KartuContent from "@/components/KartuContent.vue";
export default {
  name: "kkAdd-views",
  components: {
    KartuSidebar,
    KartuContent,
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
