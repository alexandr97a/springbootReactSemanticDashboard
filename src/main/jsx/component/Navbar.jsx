import React, { Fragment } from "react";
import 'semantic-ui-css/semantic.min.css'
// import axios from 'axios';
import { Icon,Segment,Menu,Form, Button } from 'semantic-ui-react'
// import { Link } from 'react-router-dom'

class Navbar extends React.Component {
    constructor(props) {
      super(props);
      this.state = {
        list: []
      }
    };
  handleItemClick = (e, { name }) => {
    this.setState({ activeItem: name })
    if (name == 'home')
      this.props.onChangeSection("table_list")
    else
      this.props.onChangeSection("login")
    }
  
    // componentDidMount() {
    //   this._getData();
    // }
  
    // _getData = async () => {
    //     const res = await axios.get('/login');
    //     if (res.data[0] === undefined) {
    //         let cover = [];
    //         cover.push(res.data);
    //         return this.setState({ list: cover, didLoad: true })
    //     }
    //     this.setState({ list: res.data});
    // }
    render() {
      const user = this.state.list[0];
      console.log('state', this.state)
      console.log('user', user)
      
        return(
            <Fragment>
              <Segment inverted color="blue" >
                  <Menu size='huge' color="blue"  inverted >
                      <Menu.Item
                      name='home'
                      onClick={this.handleItemClick}
                      >
                      <Icon name='dashcube' />
                          Dashboard
                      </Menu.Item>
                  <Menu.Menu position='right'>
                      <Menu.Item
                          name='로그인'
                          onClick={this.handleItemClick}/>
                      </Menu.Menu>
                  </Menu>
              </Segment>
            </Fragment>
        )
    };
  };
  
  export default Navbar;