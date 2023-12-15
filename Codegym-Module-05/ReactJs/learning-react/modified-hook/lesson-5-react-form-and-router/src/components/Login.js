import {useState} from "react";
function Login(){
    const [form,setForm] = useState({});

    const REGEX = {
        email: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
        password: /^[a-zA-Z0-9!@#\$%\^\&*\)\(+=._-]{6,}$/
    };

    const MESSAGE_ERROR = {
        email : "Email error",
        password : "Password error"
    };

    function handleChange(e) {
        let error = REGEX[e.target.name].test(e.target.value)
            ? "" : MESSAGE_ERROR[e.target.name];

        setForm({...form,
            [e.target.name] : {value: e.target.value, error: error}
        });
    }

    function handleSubmit(){
        const isFilled =
            form.email && form.email.value &&
            form.password && form.password.value;

        const isError = isFilled && (form.email.error || form.password.error);

        alert(
            isFilled && !isError
                ? "Login success" : "Login failed successfully"
        )
    }

    return(
        <>
            <div>
                <h1>Login</h1>
                <form onSubmit={handleSubmit}>
                    <div
                        className={`custom-input ${form.email && form.email.error && "custom-input-error"}`}
                    >
                        <label>Email</label>
                        <input
                        name={"email"}
                        type={"email"}
                        placeholder={"Your email here"}
                        value={(form.email && form.email.value) || ""}
                        onChange={handleChange}
                        />
                        {form.email && form.email.error && (
                            <p className={'error'}>Email Error</p>
                        )}
                    </div>
                    <div
                        className={`custom-input ${form.password && form.password.error && "custom-input-error"}`}
                    >
                        <label>Password</label>
                        <input
                            name={"password"}
                            type={"password"}
                            placeholder={"Your password here"}
                            value={(form.password && form.password.value) || ""}
                            onChange={handleChange}
                        />
                    </div>
                    {form.password && form.password.error && (
                        <p className={'error'}>Password Error</p>
                    )}
                    <button
                        type={"submit"}
                    >Submit</button>
                </form>
            </div>
        </>
    )
}

export default Login;