import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import { BrowserRouter } from "react-router-dom";
import { createStore } from "redux";
import RootReducer from "./Reducer/RootReducer";
import { Provider } from "react-redux";

const storeReduxUltimate = createStore(RootReducer, window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__({ trace: true }));

const root = ReactDOM.createRoot(document.getElementById("root"));

root.render(
  <React.StrictMode>
    <BrowserRouter>
      <Provider store={storeReduxUltimate}>
        <App />
      </Provider>
    </BrowserRouter>
  </React.StrictMode>
);

export default storeReduxUltimate;
