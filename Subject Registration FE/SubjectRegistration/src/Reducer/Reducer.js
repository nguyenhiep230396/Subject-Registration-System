import * as Types from "../Constant/ActionType";
import { NavLink } from "react-router-dom";
import LoginForm from "../Component/Route/LoginForm";
import Signout from "../Component/Route/Signout";
import HomeLogin from "../Component/Route/HomeLogin";
import HomeNotLogin from "../Component/Route/HomeNotLogin";

let booleanLogin = false;
let showLoginOrSignOutContent = <LoginForm />;
let showLoginOrSignOutMenu = "Login";
let showLoginOrSignOutHome = <HomeNotLogin />;
let emailAxios = "";
let passwordAxios = "";
let listClass = [];
let id = "";
let name = "";

if (localStorage && localStorage.getItem("Login_Info")) {
  booleanLogin = true;
  showLoginOrSignOutContent = <Signout />;
  showLoginOrSignOutMenu = "Signout";
  showLoginOrSignOutHome = <HomeLogin />;
  emailAxios = JSON.parse(localStorage.getItem("Login_Info")).Email;
  passwordAxios = JSON.parse(localStorage.getItem("Login_Info")).Password;
  id = JSON.parse(localStorage.getItem("Login_Info")).StudentID;
  name = JSON.parse(localStorage.getItem("Login_Info")).StudentName;
}

let initialState = {
  ifLoginSuccess: booleanLogin,
  loginSignoutContent: showLoginOrSignOutContent,
  loginSignoutMenu: showLoginOrSignOutMenu,
  loginSignoutHome: showLoginOrSignOutHome,
  email: emailAxios,
  password: passwordAxios,
  listClass: listClass,
  idStudent: id,
  nameStudent: name,
};

let Reducer = (state = initialState, action) => {
  switch (action.type) {
    case Types.LOGIN_SUCCESS:
      return {
        ...state,
        ifLoginSuccess: true,
      };
    //
    case Types.LOGIN_SUCCESS_CHANGE:
      let emailFromInput = action.email;
      let passwordFromInput = action.password;
      var nameC = action.name;
      return {
        ...state,
        loginSignoutContent: <Signout />,
        loginSignoutMenu: "Signout",
        loginSignoutHome: <HomeLogin />,
        email: emailFromInput,
        password: passwordFromInput,
        nameStudent: nameC,
      };
    //
    case Types.SIGNOUT:
      return {
        ...state,
        ifLoginSuccess: false,
        loginSignoutContent: <LoginForm />,
        loginSignoutMenu: "Login",
        loginSignoutHome: <HomeNotLogin />,
        email: "",
        password: "",
        nameStudent: "",
      };
    //
    case Types.STUDENT_ID:
      let idChange = action.id;
      return {
        ...state,
        idStudent: idChange,
      };
    default:
      return state;
  }
};

export default Reducer;
