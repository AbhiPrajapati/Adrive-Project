import { useState } from 'react'
import './App.css'
import Login from './components/Login';
import HomePage from './components/HomePage';
// import InputBox from '../components/InputBox';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import SignUp from './components/SignUp';


function App() {

  return (
    <div>
      <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/home" element={<HomePage />} />
        <Route path="/signup" element={<SignUp/>}/>
      </Routes>
      </Router>
    </div>
  )
}

export default App;
