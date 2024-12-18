import { useState } from 'react'
import './App.css'
import Login from './components/Login';
import Profile from './components/Profile';
import Documents from './components/Documents';
import Chats from './components/Chats';
import Photos from './components/Photos';
import Videos from './components/Videos';
import Settings from './components/Settings';
import HomePage from './components/HomePage';
// import InputBox from '../components/InputBox';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import SignUp from './components/SignUp';


function App() {

  return (
    <div>
      <Router>
      <Routes>
      <Route path="/chats" element={<Chats />} />
        <Route path="/documents" element={<Documents />} />
        <Route path="/profile" element={<Profile/>}/>
        <Route path="/photos" element={<Photos />} />
        <Route path="/videos" element={<Videos />} />
        <Route path="/settings" element={<Settings />} />
        <Route path="/" element={<Login />} />
        <Route path="/home" element={<HomePage />} />
        <Route path="/signup" element={<SignUp/>}/>
        <Route path="/login" element={<Login />} />
      </Routes>
      </Router>
    </div>
  )
}

export default App;
