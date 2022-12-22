<template>
  <div id="sidebar-wrapper">
    <ul class="sidebar-nav p-2">
      <li class="sidebar-brand text-light">
        <h2 class="mt-3 ml-2">
          <strong>E-KTP APP</strong>
        </h2>
        <hr class="bg-light mx-3" />
      </li>
      <li class="mt-2">
        <router-link to="/home">Home</router-link>
      </li>
      <li class="mt-2">
        <router-link to="/addKk" style="color: #000; background: #fff"
          >Tambah KK</router-link
        >
      </li>
      <li class="mt-4">
        <a @click="logout" id="hoverSidebar">Keluar</a>
      </li>
    </ul>
  </div>
</template>

<script>
import Swal from "sweetalert2";
export default {
  name: "kartu-sidebar",
  methods: {
    logout() {
      Swal.fire({
        title: "Yakin mau keluar?",
        text: "Kalo kamu keluar, kamu harus login ulang",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#0275d8",
        cancelButtonColor: "#d9534f",
        confirmButtonText: "Yakin banget",
        cancelButtonText: "Gajadi deh",
      }).then((result) => {
        if (result.isConfirmed) {
          Swal.fire("Yeyy!", "Kamu berhasil logout!", "success");
          this.$router.push("/");
        } else {
          Swal.fire({
            icon: "success",
            position: "top-end",
            title: "Logout Dibatalkan",
            timer: 1500,
            showConfirmButton: false,
          });
        }
      });
    },
  },
};
</script>

<style scoped>
#hoverSidebar:hover {
  cursor: pointer;
}

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
