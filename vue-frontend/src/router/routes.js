import Auth from "@/views/Auth";
import Home from "@/views/Home";
import Register from "@/views/Register";
import KkAdd from "@/views/KkAdd";
import KkDetail from "@/views/KkDetail";
import AnggotaList from "@/views/AnggotaList";
import AnggotaDetail from "@/views/AnggotaDetail";

export default [
  {
    path: "/",
    component: Auth,
    name: "auth",
  },
  {
    path: "/home",
    component: Home,
    name: "home",
  },
  {
    path: "/register",
    component: Register,
    name: "register",
  },
  {
    path: "/addKk",
    component: KkAdd,
    name: "addKk",
  },
  {
    path: "/detailKk/:id",
    component: KkDetail,
    name: "detailKk",
  },
  {
    path: "/detailKk/:id/listAnggota",
    component: AnggotaList,
    name: "listAnggota",
  },
  {
    path: "/detailKk/:id/listAnggota/detailAnggota/:idList",
    component: AnggotaDetail,
    name: "detailAnggota",
  },
];
