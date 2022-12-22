import http from "@/http-common";

class UserService {
  insert(data) {
    return http.post("/user/insertUser", data);
  }

  getUser() {
    return http.get("/user/getUser");
  }

  login(data) {
    return http.post("/user/login", data);
  }
}

export default new UserService();
