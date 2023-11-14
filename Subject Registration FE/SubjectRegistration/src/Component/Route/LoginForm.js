import React, { useState } from "react";
import Axios from "axios";
import { ifLoginSuccessOrNot, changeIfLoginSuccess, changeStudentID } from "../../Action/ActionRedux";
import storeReduxUltimate from "../../index";
import { connect } from "react-redux";

function LoginForm(props) {
  let [email, setEmail] = useState("");
  let [password, setPassword] = useState("");

  let handleChangeEmail = (event) => {
    setEmail(event.target.value);
  };

  let handleChangePassword = (event) => {
    setPassword(event.target.value);
  };

  let handleLogin = () => {
    Axios.get("http://localhost:8083/api/v1/login", {
      auth: {
        username: email,
        password: password,
      },
    })
      .then((response) => {
        let loginDTO = response.data;
        let studentID = loginDTO.studentID;
        let studentName = loginDTO.studentName;
        console.log(loginDTO);
        let Login_Info = {
          Email: email,
          Password: password,
          StudentID: studentID,
          StudentName: studentName,
        };

        let name = Login_Info.StudentName;

        localStorage.setItem("Login_Info", JSON.stringify(Login_Info));

        props.ifLoginSuccessOrNot();

        props.changeIfLoginSuccess(email, password, name);

        console.log("chạy changeNavIfLoginSuccess");

        let id = Login_Info.StudentID;

        props.changeStudentID(id, name);

        alert("Chào mừng sinh viên " + studentName + " đã đăng nhập thành công");
      })
      .catch((error) => {
        console.log("ERROR: ", error);
        alert("Email hoặc Mật Khẩu KHÔNG Hợp Lệ");
      });
  };

  let handleReset = () => {
    setEmail("");
    setPassword("");
  };

  return (
    <div>
      <div class="container">
        <form action="" method="POST" role="form">
          <legend>Login</legend>

          <div class="form-group">
            <input type="email" class="form-control" id="" placeholder="Input Email" name="email" value={email} onChange={handleChangeEmail} />
          </div>
          <div class="form-group">
            <input type="password" class="form-control" id="" placeholder="Input Password" name="password" value={password} onChange={handleChangePassword} />
          </div>

          <button type="button" class="btn btn-success btn-lg" onClick={handleLogin}>
            Login
          </button>
          <button type="reset" class="btn btn-warning btn-lg" onClick={handleReset}>
            Reset
          </button>
        </form>
      </div>
    </div>
  );
}

// mapDispatchToProps-----------------------------------------------------------------
let mapDispatchToProps = (dispatch, props) => {
  return {
    ifLoginSuccessOrNot: () => {
      storeReduxUltimate.dispatch(ifLoginSuccessOrNot());
    },
    //
    changeIfLoginSuccess: (email, password, name) => {
      storeReduxUltimate.dispatch(changeIfLoginSuccess(email, password, name));
    },
    //
    changeStudentID: (id) => {
      storeReduxUltimate.dispatch(changeStudentID(id));
    },
  };
};

export default connect(null, mapDispatchToProps)(LoginForm);
