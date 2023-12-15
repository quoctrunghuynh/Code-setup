import React from "react";
import ReactDOM from "react-dom/client";

class Football extends React.Component {
    shoot = (a) => {
        alert(a);
    }
    render() {
        return (
            <button onClick={() => this.shoot("Haheho")}>Take the shot!</button>
        );
    }
}

const root = ReactDOM.createRoot(document.getElementById("root"));

root.render(<Football />);

export default Football;