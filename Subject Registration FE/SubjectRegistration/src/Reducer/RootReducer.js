import Reducer from "./Reducer";
import { combineReducers } from "redux";

let RootReducer = combineReducers({ Reducer: Reducer });

export default RootReducer;
