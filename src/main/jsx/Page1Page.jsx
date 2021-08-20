import '../resources/css/custom.css';
import 'semantic-ui-css/semantic.min.css'
import React, {Fragment} from "react";
import ReactDOM from 'react-dom';
import {BrowserRouter as Router, Route, Switch} from "react-router-dom"
import Main from "./Main.jsx"
import Add_table from "./Add_table.jsx"
 
class Page1Page extends React.Component {
 
    render() {
        return(
            <Fragment>
                <Router>
                    <Route path='/' exact={true} component={Main} />
                    <Switch>
                        <Route path="/add_table" component={Add_table} />
                        {/* <Route path="/table/:id" component={Table} /> */}
                        {/* <Route path="/edit_table/:id" component={Edit_table} />
                        <Route path="/login" component={Login} />
                        <Route path="/signup" component={Signup} />   
                        <Route path="/test" component={Test} /> */}
                    </Switch>
                </Router>
            </Fragment>
        )
    }
 
}
export default Page1Page;