import {configureStore} from "@reduxjs/toolkit";

export default function LearningRedux() {
    const initState = 0
    function reducer(state = initState, action){
        switch (action.type){
            case 'DEPOSIT': return state + action.payload;
            case 'WITHDRAW': return state - action.payload;
            default: return state;
        }
    }

    const store = window.store = configureStore(reducer);
    console.log(store.getState());

    function render(){
        const output = document.querySelector('#output');
        output.innerText = store.getState();
    }

    const deposit = document.querySelector('#deposit');
    const withdraw = document.querySelector('#withdraw');

    deposit.onclick = () => {
        store.dispatch(actionDeposit(10));
    }
    withdraw.onclick = () => {
        store.dispatch(actionWithdraw(10));
    }
    function actionDeposit(payload){
        return {
            type: 'DEPOSIT',
            payload
        }
    }

    function actionWithdraw(payload){
        return{
            type: 'WITHDRAW',
            payload
        }
    }

    store.subscribe(()=> {
        console.log('State updated');
        render();
    })


    render();

    return (
        <div>
            <h1 id={"output"}></h1>
            <button id={"deposit"}>Deposit 10$</button>
            <button id={"withdraw"}>Withdraw 10$</button>
        </div>
    )
}