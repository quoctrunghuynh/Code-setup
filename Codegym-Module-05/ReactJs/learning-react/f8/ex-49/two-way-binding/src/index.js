import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
// import app from './app';
import LearningState from './components/LearningState'
import reportWebVitals from './reportWebVitals';
import Toggle from "./components/LearningEventHandling";
import Football from "./components/Football";
import App from "./components/ComponentLifeCycle"

const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
  <React.StrictMode>
    {/*<app article={{header1 : "Custom hello said : 'Hello world'"}} />*/}
    {/*  <LearningState/>*/}
    {/*  <Toggle/>*/}
    {/*  <Football/>*/}
      <App/>

  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
