import Vue from "vue";
import App from "./App.vue";
import { BootstrapVue, IconsPlugin } from "bootstrap-vue";
import VueRouter from "vue-router";
import Router from "@/router/routes";

import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";

Vue.config.productionTip = false;

Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.use(VueRouter);

const router = new VueRouter({
  routes: Router,
  mode: "history",
});

// router.beforeEach((to, from, next) => {
//   if (to.name != "auth" && !localStorage.user_login) next({ name: "auth" });
//   else if (to.name != "register" && !localStorage.user_register)
//     next({ name: "register" });
//   else next();
// });

new Vue({
  render: (h) => h(App),
  router: router,
}).$mount("#app");
