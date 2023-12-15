import {Component} from "react";
import Alert from "bootstrap/js/src/alert";

function Home(){
    class Home extends Component{
        componentWillUnmount() {
            return (
                alert("Goodbye!!!")
            )
        }
    }
}