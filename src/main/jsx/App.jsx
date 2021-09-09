import React from 'react';
import ReactDOM from 'react-dom';
import MainPage from './MainPage.jsx';
import {BrowserRouter, Route} from "react-router-dom"

class App extends React.Component {
    render() {
        return(
            <BrowserRouter>
                <Route component={MainPage} />
            </BrowserRouter>
        )
    }
}
ReactDOM.render(<App />, document.getElementById('root'));
