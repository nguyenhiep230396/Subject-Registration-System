import React from "react";
import storeReduxUltimate from "../..";
import HomeNotLogin from "../Route/HomeNotLogin";
import HomeLogin from "../Route/HomeLogin";
import { connect } from "react-redux";

function Home(props) {
  return <div>{props.showHome.loginSignoutHome}</div>;
}

let mapStateToProps = (state) => {
  return {
    showHome: state.Reducer,
  };
};

export default connect(mapStateToProps, null)(Home);
