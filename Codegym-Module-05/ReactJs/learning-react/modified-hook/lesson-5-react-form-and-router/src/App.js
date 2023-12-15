import './App.css';
import Register from "./components/Register";
import Login from "./components/Login"
import LoginWithFormik from "./components/LoginWithFormik";
import {Link, Route, Routes} from "react-router-dom";

function App() {
    return (
        <div>
            <ul>
                <li>
                    {/*<Link to={"/login"}>Login</Link>*/}
                    <Link to={"/login"}>
                        <button>
                            login
                        </button>
                    </Link>
                </li>
                <li>
                    <Link to={"/register"}>Register</Link>
                </li>
            </ul>
            <hr/>
            <Routes>
                <Route path={"/login"} element={<Login/>}></Route>
                <Route path={"/register"} element={<Register/>}></Route>
            </Routes>
        </div>
    )
}

export default App;
