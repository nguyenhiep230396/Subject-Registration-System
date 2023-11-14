import { Route, Routes } from "react-router-dom";
import LoginForm from "./LoginForm";
import Signout from "./Signout";
import Error from "./Error";
import storeReduxUltimate from "../..";
import Home from "./Home";
import Login from "./Login";

export const routesMenu = (
  <Routes>
    <Route path="" element={<Home />} />
    <Route path="/login" element={<Login />} />
    <Route path="*" element={<Error />} />
  </Routes>
);
