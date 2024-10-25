import '../index.css'
import InputBox from './InputBox';

function Card(props){
  return(
    <div className='login-card'>
      <div className='login-form'>
        <form action='GET'>
          <p className='mb-6 text-3xl'>Login</p>
          <InputBox className='input login-username p-3' type={'text'} placeholder={'username'}></InputBox>
          <InputBox className='input login-password p-3' type={'password'} placeholder={'password'}></InputBox>
          <button className='btn mt-3'>login</button>
        </form>
      </div>
    </div>
  )
}

export default Card;