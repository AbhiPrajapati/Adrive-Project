import { useState } from 'react'
import './App.css'
import Card from './components/Card';
import InputBox from './components/InputBox';

function App() {
  const [count, setCount] = useState(0)

  return (
    <div>
      <h1  className="text-3xl font-bold open-sans-font" >Welcome to ADrive</h1>
      <Card></Card>
    </div>
  )
}

export default App
