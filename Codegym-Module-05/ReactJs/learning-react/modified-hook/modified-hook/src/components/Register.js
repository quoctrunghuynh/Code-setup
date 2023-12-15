import {useState} from "react";

function Register() {
    const [form, setForm] = useState({})

    const handleChange = (e) => {
        setForm({
            ...form,
            [e.target.name] : e.target.value
        });
        console.log(e.target.name +':'+ e.target.value)
    };

    const REGEX = () => {

    }

    return (
        <div>
            <label htmlFor="emailId">Email</label>
            <input id='emailId'
                   name='email'
                   onChange= {handleChange}
                   type='email'
                   required/>
            <br/>
            <label htmlFor="passwordId">Password</label>
            <input id='passwordId'
                   name='password'
                   onChange= {handleChange}
                   type='password'/>
            <br/>
            <button>Register</button>
        </div>
    )
}

export default Register;