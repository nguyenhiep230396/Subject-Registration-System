import React from "react";
import { connect } from "react-redux";
import storeReduxUltimate from "../..";
import { signOut } from "../../Action/ActionRedux";

function Signout(props) {
  let handleSignout = () => {
    props.SignOut();
    localStorage.clear();
    alert("Đăng xuất thành công");
    //
  };

  return (
    <div>
      <button type="button" class="btn btn-info btn-lg" onClick={handleSignout}>
        Signout
      </button>
    </div>
  );
}

let mapDispatchToProps = (dispatch, props) => {
  return {
    SignOut: () => {
      storeReduxUltimate.dispatch(signOut());
    },
  };
};

export default connect(null, mapDispatchToProps)(Signout);
