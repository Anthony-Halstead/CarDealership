import React from 'react'
import '../../css/pages/signupsignin.css'
import '../../css/reusables/positions.css'

function SignUpSignIn() {
    return (
        <div className='signup-signin-content'>

            <div className='sign-up-box'>
                <div>
                    New User? Sign-up Today!
                </div>
                <h1>Sign-Up</h1>
                <div className='flex-row justify-content-left'>
                    USERNAME
                    <input className='input-container'></input>
                </div>
                <div className='flex-row justify-content-left'>
                    PASSWORD
                    <input className='input-container'></input>
                </div>
                <div className='flex-row justify-content-center'>
                    <button>SUBMIT</button>
                </div>
            </div>
            <div className='sign-up-box'>
                <div>Already A User?</div>
                <h1>Sign-In</h1>
                <div className='flex-row justify-content-left'>
                    USERNAME
                    <input className='input-container'></input>
                </div>
                <div className='flex-row justify-content-left'>
                    PASSWORD
                    <input className='input-container'></input>
                </div>
                <div className='flex-row justify-content-center'>
                    <button>SUBMIT</button>
                </div>
            </div>

        </div>
    )
}

export default SignUpSignIn