import React, { useState } from "react";
import '../index.css';
import { useNavigate } from "react-router-dom";
import axios from "axios";

function SignUp(props) {
  const [credentials, setCredentials] = useState({ username: "", password: "", confirmPassword: "" });
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  const handleSignUp = async (event) => {
    event.preventDefault(); // Prevent default form submission

    if (credentials.password !== credentials.confirmPassword) {
      setError("Passwords do not match!");
      return;
    }

    try {
      const payload = {
        username: credentials.username,
        password: credentials.password
      };

      const response = await axios.post("http://localhost:8080/signup", payload, {
        headers: {
          "Content-Type": "application/json"
        }
      });

      // Assuming the response contains a success message
      console.log(response.data);
      if (response.status === 200) {
        // Redirect to login or home page after successful sign up
        navigate("/login"); // Redirect to /login
      }
    
    } catch (error) {
      // Handle error
      console.error("Sign Up failed!", error);
      if (error.response) {
        // If the server responded with a status code outside the 2xx range
        setError("Sign Up failed! " + (error.response.data.message || "Please try again."));
      } else {
        // If the request was made but no response was received
        setError("Sign Up failed! Please try again later.");
      }
    }
  };

  return (
    <div>
      <h1 className="text-3xl font-bold open-sans-font">Welcome to ADrive</h1>
      <div className='login-card'>
        <div className='login-form'>
          <form onSubmit={handleSignUp}>
            <p className='mb-6 text-3xl'>Sign Up</p>

            <div className='input-div'>
              <input className="input login-username p-3"
                value={credentials.username}
                onChange={(e) => setCredentials({ ...credentials, username: e.target.value })}
                type='text' placeholder='username' />
            </div>

            <div className='input-div'>
              <input className="input login-password p-3"
                value={credentials.password}
                onChange={(e) => setCredentials({ ...credentials, password: e.target.value })}
                type='password' placeholder='password' />
            </div>

            <div className='input-div'>
              <input className="input login-password p-3"
                value={credentials.confirmPassword}
                onChange={(e) => setCredentials({ ...credentials, confirmPassword: e.target.value })}
                type='password' placeholder='confirm password' />
            </div>
            <div className="button-container flex justify-center mt-3">
              <button className='btn' type="submit">Sign Up</button>
            </div>
           </form>
          {error && <p className="text-red-500">{error}</p>}
        </div>
      </div>
    </div>
  );
}

export default SignUp;