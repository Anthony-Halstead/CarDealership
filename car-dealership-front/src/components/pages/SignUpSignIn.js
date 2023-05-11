import React from 'react'
import '../../css/pages/signupsignin.css'
import '../../css/reusables/positions.css'
import axios from 'axios';
import { useNavigate } from 'react-router';

function SignUpSignIn(props) {


    const navigator = useNavigate()

    const changeHandler = (event) => {
    const name = event.target.name;
    const value = event.target.value;
    const tempUser = { ...props.user };
    tempUser[name] = value;

    props.setUser(tempUser)
  }

  const submitHandler = () => {
    axios.post("http://localhost:8080/user/signUp", props.user)
      .then((response) => {
        localStorage.setItem("emailCookie", response.data.email)
        props.setUser(response.data)
        navigator("/")
      })
      .catch((e) => {
        console.log(e)
      })

    }
    return (
        <div className='signup-signin-content'>
            <div className='sign-up-box'>
                <div>
                    New User? Sign-up Today!
                </div>
                <h1>Sign-Up</h1>
                <div className='flex-row justify-content-left'>
                    EMAIL
                    <input className='input-container'  value={props.user.email} name='email' type='email' onChange={changeHandler} required></input>
                </div>
                <div className='flex-row justify-content-left'>
                    PASSWORD
                    <input className='input-container' value={props.user.password} name='password' type='password' onChange={changeHandler} required></input>
                </div>
                <div className='flex-row justify-content-center'>
                    <button onClick={submitHandler}>SUBMIT</button>
                </div>
            </div>
            <div className='sign-up-box'>
                <div>Already A User?</div>
                <h1>Sign-In</h1>
                <div className='flex-row justify-content-left'>
                    EMAIL
                    <input className='input-container'  value={props.user.email} name='email' type='email' onChange={changeHandler} required></input>
                </div>
                <div className='flex-row justify-content-left'>
                    PASSWORD
                    <input className='input-container' value={props.user.password} name='password' type='password' onChange={changeHandler} required></input>
                </div>
                <div className='flex-row justify-content-center'>
                    <button onClick={submitHandler}>SUBMIT</button>
                </div>
            </div>

        </div>
    )
}

export default SignUpSignIn