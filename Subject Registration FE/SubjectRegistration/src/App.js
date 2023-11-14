import "./App.css";
import Menu from "./Component/Menu/Menu";
import { routesMenu } from "./Component/Route/Route";

function App() {
  return (
    <div className="App">
      {/* Menu */}
      <Menu />
      {/* Menu */}

      {/* Hiển thị */}
      {routesMenu}
      {/* Hiển thị */}
    </div>
  );
}

export default App;
