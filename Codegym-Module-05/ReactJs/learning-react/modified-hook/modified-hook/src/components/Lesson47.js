import {useState, useEffect} from "react";


function App() {

    const [info, setInfo] = useState({
        name: 'Huynh Quoc Trung',
        age: '25',
        address: 'Ho Chi Minh, VN'
    });

    const handleUpdate = () => {
        setInfo({
            ...info,
            gender: 'Male'
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        const nameValue = document.getElementById('inputId').value;
        setInfo({
            ...info,
            name: nameValue
        })
    };

    const cellStyle = {
        border: '1px solid black',
        padding: '8px',
        textAlign: 'center'
    };

    return (
        <div className="App" style={{
            padding: '20px',
            border: '5px solid black',
            borderInline: '1px'
        }}>
            <table>
                <tr>
                    <th style={cellStyle}>Name</th>
                    <th style={cellStyle}>Age</th>
                    <th style={cellStyle}>Address</th>
                    {info.gender && <th style={cellStyle}>Gender</th>}
                </tr>
                <tr>
                    <td style={cellStyle}>{info.name}</td>
                    <td style={cellStyle}>{info.age}</td>
                    <td style={cellStyle}>{info.address}</td>
                    { info.gender && <td style={cellStyle}>{info.gender}</td> }
                </tr>
            <tr>
                <button onClick={handleUpdate}>Update</button>
            </tr>
            </table>
            <form onSubmit={handleSubmit}>
                <input id='inputId'/>;
                <button type="submit">Submit</button>;
            </form>
        </div>
    )
}


export default App;