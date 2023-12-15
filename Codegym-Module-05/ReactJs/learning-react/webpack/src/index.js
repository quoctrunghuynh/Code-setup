import React, {useRef} from 'react'
import ReactDOM from 'react-dom/client'

function App() {
    return (
        <>
            <h1>Keeeeeeeng</h1>
            <h2>{writeName(user)}</h2>
        </>
    )
}

function writeName(user){
    return user.name + ' ' + user.code;
}

const user = {
name: 'Mixin',
code: 'Match'
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App/>);
