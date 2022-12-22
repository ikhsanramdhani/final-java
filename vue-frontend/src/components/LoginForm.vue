<template>
  <main class="bg-primary" style="min-width: 100vw; height: 100vh">
    <div class="container">
      <section class="vh-100">
        <div class="container py-5 h-100">
          <div
            class="row d-flex justify-content-center align-items-center h-100"
          >
            <div class="col col-xl-10">
              <div class="card" style="border-radius: 1rem">
                <div class="row g-0">
                  <div class="col-md-6 col-lg-5 d-none d-md-block">
                    <img
                      src="@/assets/ktp.png"
                      alt="login form"
                      class="mt-5"
                      style="border-radius: 1rem 0 0 1rem"
                    />
                  </div>
                  <div class="col-md-6 col-lg-7 d-flex align-items-center mt-5">
                    <div class="card-body p-4 p-lg-5 text-black">
                      <form @submit.prevent="auth">
                        <div class="d-flex align-items-center mb-3 pb-1">
                          <h2 class="fw-bold mb-0">Selamat Datang!</h2>
                        </div>
                        <div class="form-outline mb-4">
                          <input
                            type="email"
                            class="form-control form-control-lg"
                            placeholder="Email"
                            v-model="dataUser.email"
                          />
                          <small
                            id="emailHelp"
                            v-show="false"
                            class="form-text text-danger"
                            >We'll never share your email with anyone
                            else.</small
                          >
                        </div>

                        <div class="form-outline mb-4">
                          <input
                            type="password"
                            class="form-control form-control-lg"
                            placeholder="Password"
                            v-model="dataUser.password"
                          />
                        </div>

                        <div class="pt-1 mb-4">
                          <button
                            class="btn btn-primary btn-lg btn-block"
                            type="submit"
                          >
                            Login
                          </button>
                        </div>
                        <p class="mb-5 pb-lg-2">
                          Belum punya akun?
                          <router-link to="/register" class="text-primary">
                            Daftar disini
                          </router-link>
                        </p>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  </main>
</template>

<script>
import UserService from "@/service/UserService";
import Swal from "sweetalert2";

export default {
  name: "login-component",
  data() {
    return {
      dataUser: {
        email: null,
        password: null,
      },
    };
  },
  methods: {
    auth() {
      let inputUser = this.dataUser;

      if (inputUser.email == null && inputUser.password == null) {
        Swal.fire(
          "Kesalahan!",
          "Email dan password tidak boleh kosong ya",
          "error"
        );
      } else if (inputUser.email == null) {
        Swal.fire("Hmmm..", "Email kamu masih kosong nih", "question");
      } else if (inputUser.password == null) {
        Swal.fire({
          title: "Password tidak boleh kosong!",
          text: "Silahkan mengisi ulang data anda",
          icon: "warning",
        }).then((r) => {
          if (r.isConfirmed) {
            window.location.reload();
          }
        });
      } else {
        UserService.login(inputUser).then((response) => {
          if (response.data.email == this.dataUser.email) {
            Swal.fire({
              position: "top-end",
              icon: "success",
              title: "Yeyy, Kamu berhasil login!",
              showConfirmButton: false,
              timer: 2000,
            });
            this.$router.push("/home");
          } else {
            Swal.fire({
              text: "Email atau password anda salah",
              title: "Akun Tidak Ditemukan!",
              icon: "error",
            }).then((r) => {
              if (r.isConfirmed) {
                window.location.reload();
              }
            });
          }
        });
      }
    },
  },
};
</script>
