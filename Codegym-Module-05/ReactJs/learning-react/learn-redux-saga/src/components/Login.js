import {useState, useEffect} from "react";
import {useDispatch, useSelector} from "react-redux";
import {useNavigate} from "react-router-dom";

export default function Login() {
    const navigate = useNavigate();
    const dispatch = useDispatch();
    const [user, setUser] = useState({username: "", password: ""});

    const userLoggedIn = useSelector(state => state.userLoggedIn);
    const setValueForUser = (key, value) => {
        const newVal = {...user, [key]: value};
        setUser(newVal)
    };
    const login = () => {
        dispatch({
            type: "LOGIN", payload: user
        });
    };
    useEffect(() => {
        if (userLoggedIn.username) {
            navigate("/users");
        }
    }, [userLoggedIn, navigate]);
    return (
        <form>
            <label>Username</label>
            <input id={"username"}
                   onChange={e => setValueForUser("username", e.target.value)}
                   type={"email"}
            />
            <br/>
            <label>Password</label>
            <input id={"password"}
                   onChange={e => setValueForUser("password", e.target.value)}
                   type={"password"}
            />
            <br/>
            <button
                type="button"
                onClick={() => {
                    login();
                }}>Login</button>
        </form>
    )
}