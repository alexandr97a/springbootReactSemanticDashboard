// import '../resources/css/custom.css'; // file not found
import 'semantic-ui-css/semantic.min.css'
import React, {Fragment} from "react";
import ReactDOM from 'react-dom';
import {Route, Switch} from "react-router-dom"
import TableList from "./TableList.jsx"
import AddTable from "./AddTable.jsx"
import EditTable from "./EditTable.jsx"
import Table from "./Table.jsx"
import Login from "./Login.jsx"
import Signup from "./Signup.jsx"
import Navbar from './component/Navbar.jsx';
import { isDuration } from 'moment';
 
class MainPage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            section: undefined,
            detailID: undefined,
        }
    };

    componentDidMount() {
        this.onChangeSection("table_list");
    }

    componentDidUpdate(prevProps, prevState) {
        if (prevState.section != this.state.section) {
            this.applyUrl();
        }
    }

    onChangeSection = (section) => {
        this.setState({ section: section });
    }

    onChangeDetailID = (res) => {
        this.setState({ 
            section : res.data
        })
    }

    applyUrl() {
        let url = "/" + this.state.section;
        if (this.state.section=="view" && this.state.viewId) {
            url += "/" + this.state.viewId;
        }
        this.props.history.push(url, this.state);
        // window.location.href = url;
    }

    render() {
        return(
            <Fragment>
                <Switch>
                    {/* <Route Navbar onChangeSection={this.onChangeSection} /> */}
                    <Route path="/table_list" render={() => <TableList onChangeSection={this.onChangeSection} onChangeDetailID={this.onChangeDetailID}/>} />
                    <Route path="/add_table" render={() => <AddTable/>} />
                    <Route path="/edit_table/:id" render={() => <EditTable onChangeSection={this.onChangeSection} detailID={this.state.detailID}/>} />
                    <Route path="/view/:id" render={() => <Table onChangeSection={this.onChangeSection} detailID={this.state.detailID} />} />
                    <Route path="/login" render={() => <Login onChangeSection={this.onChangeSection} />} />
                    <Route path="/signup" render={() => <Signup onChangeSection={this.onChangeSection} />} />
                </Switch>
            </Fragment>
        )
    }
}
export default MainPage;