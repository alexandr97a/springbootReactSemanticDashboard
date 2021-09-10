import 'semantic-ui-css/semantic.min.css'
import React, { Fragment } from 'react';
import ReactDOM from 'react-dom';
import { Button, Form, Grid, Header, Message, } from 'semantic-ui-react'
import jQuery from 'jquery';
window.$ = window.jQuery = jQuery;

class Login extends React.Component {
    constructor(props) {
      super(props);
        this.state = {
          user_email: "",
          user_password:"",
        }
      };

    _email = (e) => {
      this.setState({ user_email : e.currentTarget.value })
    }
    _password = (e) => {
      this.setState({ user_password : e.currentTarget.value })
    }
  
    _login =(e)=>  {
      e.preventDefault();

      const _this = this;
    
      $.post("/user/login",
        {
          user_email: this.state.user_email,
          user_password: this.state.user_password,
        },
        function (data) {
          if (data.status == "fail") {
            alert(data.msg);
            return;
          }
          alert('로그인 성공. data: ' + data.msg);
          _this.props.onChangeSection("table_list");
        });
    }
    render() {
        return(
          <Fragment>
              <Grid textAlign='center' style={{ height: '100vh' }} verticalAlign='middle'>
                  <Grid.Column style={{ maxWidth: 450 }}>
                      <Header as='h2' color='blue' textAlign='center'>
                      Log-in to your account
                      </Header>
                      <Form size='large' id="login" onSubmit={this._login}>
                        <Form.Input type="email" fluid icon='user' iconPosition='left' name="username" placeholder='E-mail address' onChange={this._email} />
                        <Form.Input
                    fluid
                    icon='lock'
                    iconPosition='left'
                    name="password"
                    placeholder='Password'
                    type='password'
                    onChange={this._password}
                        />
                      <Button color='blue' fluid size='large' type="submit">
                        Login
                      </Button>
                      </Form>
                      <Message>
                        New to us? <a href='/signup.html'>Sign Up</a>
                      </Message>
                  </Grid.Column>
              </Grid>
          </Fragment>
        )
    };
  };
export default Login;