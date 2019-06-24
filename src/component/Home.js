import React from 'react';
import axios from 'axios';
import { Redirect } from 'react-router-dom';


class Home extends React.Component {

  constructor(props){
    super(props);
    this.state={
      username:'',
      password:'',
      redirect: false,
    }
    this.handleChange = this.handleChange.bind(this);
  }

  handleChange(event) {
    const target = event.target;
    const name = target.name;
    const value = target.type === 'checkbox' ? target.checked : target.value;
    this.setState({
      [name]: value
    })

  }

  handleLogin(username,password){
    const success = (data) => {
      if (data){
        this.setState({
            redirect: true
          });
              alert(data + "ok")

      }

         else alert(data + "nok");
        }
        const failure = (message) => {
          if (message === "Request failed with status code 400"){
          }
          else {
            this.setState({
              redirect: true
            });
            alert(message);
          }
        }

        login(username, password, success, failure);
  }

  

  render (){
    
if (this.state.redirect){
  //return <Redirect to="container/1231232"/>
  alert("tk");
}

     return(
    <form >
      <legend>Login To A Club Book</legend>
    <div className="container">
    <div className="col-xs-6 col-sm-6 col-md-6 col-lg-6">
      <div className="form-group">
        <label>Username</label>
        <input type="text" className="form-control" name="username" id="" onChange={this.handleChange} placeholder="Username"/>
      </div>
      <div className="form-group">
        <label>Password</label>
        <input type="text" className="form-control" name="password" id="" onChange={this.handleChange} placeholder="Password"/>
      </div>
    
      <button className="btn btn-primary" onClick = {() => this.handleLogin(this.state.username, this.state.password)}>Submit</button>
    

    </div>
    </div>
    </form>

    );
  }

 
 }

 function login(username, password, success, failure) {

    axios.request({
      url: `http://localhost:8080/Book/login?username=${username}&password=${password}`,
      method: "POST",
    }).then(r => { success(r.data) },
    r => { failure(r.message) })
}


export default Home;
