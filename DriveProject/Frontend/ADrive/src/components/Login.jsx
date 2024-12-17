import React, { useState } from "react";
import '../index.css'
import { useNavigate } from "react-router-dom";

import axios from "axios";


function Login(props){
  const [credentials, setCredentials] = useState({ username: "", password: "" });
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  const handleLogin = async (event) => {
    event.preventDefault(); // Prevent default form submission

    try {
      const payload = {
        username: credentials.username,
        password: credentials.password
      };

      const response = await axios.post("http://localhost:8080/login", payload, {
        headers: {
          "Content-Type": "application/json"
        }
      });

      // Assuming the response contains a token if login is successful
      console.log(response.data);
      const token = response.data; // Adjust according to your API's response

      if (response.status === 200 && token) {
        // Store the token in local storage or context
        localStorage.setItem("token", token);
        navigate("/home"); // Redirect to /home
      }
    
    } catch (error) {
      // Handle error
      console.error("Login failed!", error);
      if (error.response) {
        // If the server responded with a status code outside the 2xx range
        setError("Login failed! " + (error.response.data.message || "Please check your username and password."));
      } else {
        // If the request was made but no response was received
        setError("Login failed! Please try again later.");
      }
    }
  };

  
  return(
   <div>
    <h1  className="text-3xl font-bold open-sans-font" >Welcome to ADrive</h1>
    <div className='login-card'>
      <div className='login-form'>
       <form onSubmit={handleLogin}> 
          <p className='mb-6 text-3xl'>Login</p>

          <div className='input-div '>
           <input className="input login-username p-3" 
           value={credentials.username}
            onChange={(e) => setCredentials({ ...credentials, username: e.target.value })}     
           type='text' placeholder='username' />
          </div>

          <div className='input-div '>
           <input className="input login-password p-3"
            value={credentials.password}
            onChange={(e) => setCredentials({ ...credentials, password: e.target.value })}    
            type='password' placeholder='password' />
          </div>
          <button className='btn mt-3' onClick={handleLogin}>login</button>
        </form>
        {error && <p className="text-red-500">{error}</p>} 
      </div>
    </div>
    </div>
  )
}

export default Login;