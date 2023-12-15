import React, {useState} from "react";

const suspectArr = ['Tâm', 'Chung', 'Phát', 'Huy', 'Thành']

function GetSuspect(props) {

    const [suspect, setSuspect] = useState();

    const randomSuspect = () => {
        const index = Math.floor(Math.random() * suspectArr.length);
        setSuspect(suspectArr[index]);
    }
    return (
        <div style={{padding: 32}}>
            <h1>{props.article.header1} </h1>
            <h2>{`Báo thủ chính là: ${suspect || `Chưa biết`}`}</h2>
            <button onClick={randomSuspect}>Đi tìm báo thủ</button>
        </div>
    )
}

export default GetSuspect;