import { useState } from 'react'
import './App.css'
import Login from './components/Login';
import HomePage from './components/HomePage';
// import InputBox from '../components/InputBox';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';


function App() {

  return (
    <div>
      <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/home" element={<HomePage />} />
      </Routes>
      </Router>
    </div>
  )
}

export default App;
