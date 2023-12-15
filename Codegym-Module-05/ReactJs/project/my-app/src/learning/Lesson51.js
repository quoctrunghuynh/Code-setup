import Content from "./Content";
import {useState} from "react";

export default function Lesson51() {
    const [show, setShow] = useState(false);

    function handleClick() {
        setShow(!show);
    }

    return (
        <div style={{padding: 20}}>
            <button onClick={handleClick}>
                {show ? "Hide the text!?" : "Show the text!"}
            </button>
            {show && <Content/>}
        </div>
    )
}