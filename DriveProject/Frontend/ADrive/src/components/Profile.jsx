import React, { useState } from 'react';
import VerticalMenu from "./VerticalMenu";
import '../index.css';
import axios from "axios";

const Profile = () => {
    const [username, setUsername] = useState('User '); // Replace with actual username
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [dob, setDob] = useState('');
    const [email, setEmail] = useState('');
    const [profilePic, setProfilePic] = useState(null);
    const [file , setFile] = useState(null);

    const handleFileChange = (e) => {
        setProfilePic(e.target.files[0]);
        const file = e.target.files[0];
        if (file) {
            setFile(file);
            setProfilePic(URL.createObjectURL(file)); // Create a URL for the uploaded file
        }
    };

    const handleSubmit = async (event) => {
        event.preventDefault(); // Prevent default form submission
    
        try {
          const payload = {
            firstname: firstName,
            lastName: lastName,
            dateOfBirth:dob,
            email:email,
            profilePic:file

          };
    
          const response = await axios.post("http://localhost:8080/register", payload, {
            headers: {
              "Content-Type": "application/json"
            }
          });
    
          // Assuming the response contains a token if login is successful
           // Adjust according to your API's response
    
          if (response.status === 200 && token) {
            console.log("submitted Successfully");
          }
        
        } catch (error) {
          // Handle error
          console.error("failed!", error);
        }
      };
    
    return ( <div>
        <VerticalMenu />
        <div className="profile-container">
            <h1 className='label'>Welcome, {username}</h1>
            <div className="profile-pic-preview">
                {profilePic ? (
                    <img src={profilePic} alt="Profile Preview" className="profile-pic" />
                ) : (
                    <div className="placeholder-pic">No Image</div>
                )}
            </div>
            <form onSubmit={handleSubmit} className="profile-form">
                <div className="form-group  upload-pic-group">
                    <label htmlFor="profilePic">Upload Profile Picture:</label>
                    <input
                        type="file"
                        id="profilePic"
                        accept="image/*"
                        onChange={handleFileChange}
                        className="input"
                    />
                </div>
                <div className="form-row">
                    <div className="form-group">
                        <label htmlFor="firstName">First Name:</label>
                        <input
                            type="text"
                            id="firstName"
                            value={firstName}
                            onChange={(e) => setFirstName(e.target.value)}
                            required
                            className="input"
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="lastName">Last Name:</label>
                        <input
                            type="text"
                            id="lastName"
                            value={lastName}
                            onChange={(e) => setLastName(e.target.value)}
                            required
                            className="input"
                        />
                    </div>
                </div>
                <div className="form-row">
                    <div className="form-group">
                        <label htmlFor="dob">Date of Birth:</label>
                        <input
                            type="date"
                            id="dob"
                            value={dob}
                            onChange={(e) => setDob(e.target.value)}
                            required
                            className="input"
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="email">Email:</label>
                        <input
                            type="email"
                            id="email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            required
                            className="input"
                        />
                    </div>
                </div>
                <button type="submit" className="btn" >Save</button>
            </form>
        </div>
    </div>
    )

};

export default Profile;