import React, { useEffect, useState } from "react";
import { connect } from "react-redux";
import storeReduxUltimate from "../..";
import LoginForm from "./LoginForm";
import Signout from "./Signout";

function Login(props) {
  return <div>{props.ShowLogin.loginSignoutContent}</div>;
}

let mapStateToProps = (state) => {
  return {
    ShowLogin: state.Reducer,
  };
};

export default connect(mapStateToProps, null)(Login);
