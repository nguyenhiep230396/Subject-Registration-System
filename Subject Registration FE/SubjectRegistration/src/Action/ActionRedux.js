import * as Types from "../Constant/ActionType";

export const ifLoginSuccessOrNot = () => {
  return {
    type: Types.LOGIN_SUCCESS,
  };
};

export const changeIfLoginSuccess = (email, password, name) => {
  return {
    type: Types.LOGIN_SUCCESS_CHANGE,
    email: email,
    password: password,
    name: name,
  };
};

export const signOut = () => {
  return {
    type: Types.SIGNOUT,
  };
};

export const changeStudentID = (idStudentChange) => {
  return {
    type: Types.STUDENT_ID,
    id: idStudentChange,
  };
};
