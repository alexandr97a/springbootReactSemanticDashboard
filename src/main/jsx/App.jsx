import React from 'react';
import ReactDOM from 'react-dom';
import Main from './Main.jsx';
import {BrowserRouter as Router, Route, Switch} from "react-router-dom"

class App extends React.Component {
    render() {
        return(
            <Router>
                <Route component={Main} />
            </Router>
        )
    }
}
export default App;