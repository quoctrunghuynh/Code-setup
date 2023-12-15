import React from 'react';
import ReactDOM from "react-dom/client";

class Toggle extends React.Component {
    constructor(props) {
        super(props);
        this.state = {isToggleOn: true};

        // Phép "ràng buộc" (bind) này là cần thiết để `this` hoạt động trong callback
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick() {
        this.setState(prevState => ({
            isToggleOn: !prevState.isToggleOn
        }));
    }

    render() {
        return (
            <button onClick={this.handleClick}>
                {this.state.isToggleOn ? 'ON' : 'OFF'}
            </button>
        );
    }
}

const root = ReactDOM.createRoot(document.getElementById("root"));

root.render(<Toggle/>);

export default Toggle;