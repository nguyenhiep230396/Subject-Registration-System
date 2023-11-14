import React, { useEffect, useState } from "react";
import { connect } from "react-redux";
import { NavLink } from "react-router-dom";
import storeReduxUltimate from "../..";

function Menu(props) {
  return (
    <div>
      {/*  */}
      {/* <div class="container">
        <nav class="navbar navbar-inverse">
          <ul class="nav navbar-nav">
            <li>
              <NavLink to="">Home</NavLink>
            </li>
            <li>
              <NavLink to="/login">{props.ShowLogin.loginSignoutMenu}</NavLink>
            </li>
          </ul>
        </nav>
      </div> */}
      {/*  */}
      {/*  */}
      <nav className="navbar navbar-inverse">
        <div className="container-fluid">
          <ul className="nav navbar-nav">
            <li>
              <NavLink to="">Home</NavLink>
            </li>
            <li>
              <NavLink to="/login">{props.ShowLogin.loginSignoutMenu}</NavLink>
            </li>
          </ul>
          <ul className="nav navbar-nav navbar-right">
            {/* <li> */}
            {/* <NavLink to="" className="disabled-link"> */}
            <span id="studentName">{props.ShowLogin.nameStudent} 👻</span>
            {/* </NavLink> */}
            {/* </li> */}
            <li></li>
          </ul>
        </div>
      </nav>
    </div>
  );
}

let mapStateToProps = (state) => {
  return {
    ShowLogin: state.Reducer,
  };
};

export default connect(mapStateToProps, null)(Menu);
//
