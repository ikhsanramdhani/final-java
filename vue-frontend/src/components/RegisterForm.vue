<template>
  <main class="bg-primary" style="min-width: 100vw; height: 100vh">
    <div class="container">
      <section class="vh-100">
        <div class="container py-5 h-100">
          <div
            class="row d-flex justify-content-center align-items-center h-100"
          >
            <div class="col col-xl-10">
              <form v-show="!isSuccess" @submit.prevent="registration">
                <div class="card" style="border-radius: 1rem">
                  <div class="row g-0">
                    <div class="col-md-6 col-lg-5 d-none d-md-block mt-5">
                      <img
                        src="@/assets/ktp.png"
                        alt="login form"
                        class="mt-5"
                        style="border-radius: 1rem 0 0 1rem"
                      />
                    </div>
                    <div
                      class="col-md-6 col-lg-7 d-flex align-items-center mt-5"
                    >
                      <div class="card-body p-4 p-lg-5 text-black">
                        <div class="d-flex align-items-center mb-3 pb-1">
                          <h2 class="fw-bold mb-0">Daftar Akun!</h2>
                        </div>
                        <div class="form-outline mb-4">
                          <input
                            type="text"
                            class="form-control form-control-lg"
                            placeholder="Nama Lengkap"
                            v-model="regisData.nama"
                          />
                        </div>
                        <div class="form-outline mb-4">
                          <input
                            type="email"
                            class="form-control form-control-lg"
                            placeholder="Email"
                            v-model="regisData.email"
                          />
                        </div>
                        <div class="form-outline mb-4">
                          <input
                            type="password"
                            class="form-control form-control-lg"
                            placeholder="Password"
                            v-model="regisData.password"
                          />
                        </div>
                        <div class="form-outline mb-4">
                          <input
                            type="password"
                            class="form-control form-control-lg"
                            placeholder="Repassword"
                            v-model="repassword"
                          />
                          <small
                            v-show="samePassword"
                            class="form-text text-danger"
                            >Password tidak sama</small
                          >
                        </div>

                        <div class="pt-1 mb-4">
                          <button
                            class="btn btn-primary btn-lg btn-block"
                            type="submit"
                          >
                            Daftar
                          </button>
                        </div>
                        <p class="mb-5 pb-lg-2">
                          Sudah punya akun?
                          <router-link to="/" class="text-primary">
                            Masuk disini
                          </router-link>
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
              </form>
              <RegisterSuccess v-show="isSuccess"></RegisterSuccess>
            </div>
          </div>
        </div>
      </section>
    </div>
  </main>
</template>

<script>
import RegisterSuccess from "@/components/RegisterSuccess.vue";
import UserService from "@/service/UserService";
import Swal from "sweetalert2";

export default {
  name: "register-component",
  components: {
    RegisterSuccess,
  },
  data() {
    return {
      regisData: {
        email: null,
        password: null,
        nama: null,
      },
      samePassword: false,
      repassword: null,
      isSuccess: false,
    };
  },
  methods: {
    registration() {
      let inputUser = this.regisData;

      if (
        inputUser.nama == null ||
        inputUser.email == null ||
        inputUser.password == null ||
        this.repassword == null
      ) {
        Swal.fire(
          "Data tidak boleh kosong!",
          "Silahkan masukan data terlebih dahulu",
          "error"
        );
      } else if (inputUser.password != this.repassword) {
        this.samePassword = true;
      } else {
        UserService.insert(inputUser)
          .then((response) => {
            console.log(response.data);
            if (response.data.email == null) {
              Swal.fire({
                title: "Email sudah terdaftar",
                text: "Silahkan mengisi ulang data anda",
                icon: "error",
              }).then((r) => {
                if (r.isConfirmed) {
                  window.location.reload();
                }
              });
            } else {
              this.isSuccess = true;
            }
          })
          .catch((e) => {
            console.log(e);
          });
      }
    },
  },
};
</script>
