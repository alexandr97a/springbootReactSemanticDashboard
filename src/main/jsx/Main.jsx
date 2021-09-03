import '../resources/css/custom.css';
import 'semantic-ui-css/semantic.min.css'
import React, {Fragment} from "react";
import ReactDOM from 'react-dom';
import {BrowserRouter as Route, Switch} from "react-router-dom"
import TableList from "./TableList.jsx"
import AddTable from "./AddTable.jsx"
import EditTable from "./EditTable.jsx"
import Table from "./Table.jsx"
import Login from "./Login.jsx"
import Signup from "./Signup.jsx"
 
class Main extends React.Component {
    constructor(props) {
        super(props);
            this.state = {
                section: 'list',
                id:props.match.params.id
            }
    };

    componentDidMount() {
        this.onChangeSection();
    }

    onChangeSection() {
        this.props.history.push(url, this.state);
        this.setState({ 
            section : res.data
        })
    }

    onChangeDetailID() {
        this.props.history.push(url, this.state);
        this.setState({ 
            section : res.data
        })
    }

    render() {
        return(
            <Fragment>
                <Switch>
                    <Route path="/table_list" render={() => <TableList onChangeSection={this.onChangeSection}/>} />
                    <Route path="/add_table" render={() => <AddTable/>} />
                    <Route path="/edit_table/:id" render={() => <EditTable/>} />
                    <Route path="/table/:id" render={() => <Table  onChangeSection={this.onChangeSection}  onChangeDetailID={onChangeDetailID}/>} />
                    <Route path="/login" render={() => <Login/>} />
                    <Route path="/signup" render={() => <Signup/>} />
                </Switch>
            </Fragment>
        )
    }
}
export default Main;