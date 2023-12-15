import {useState, useEffect} from "react";

function Lesson52() {
    const [title, setTitle] = useState('');

    useEffect(() => {
        document.title = title;
    })

    return (
        <>
            <div>
                <input
                    value={title}
                    onChange={e => setTitle(e.target.value)}
                />
            </div>
        </>
    )
}

export default Lesson52;