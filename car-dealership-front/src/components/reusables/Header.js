import React from 'react';
import '../../css/pages/header.css'
import '../../css/reusables/positions.css'
function Header(props) {
    return (

        <div className='header-container'>
            <div className='third-width '>
                <a href="/"> <img className='third-width' src="https://th.bing.com/th/id/R.73a2ed0609b61b4f432b0df303d9aaae?rik=J7xCXORgk%2fgiYg&riu=http%3a%2f%2fauctions.morphyauctions.com%2fItemImages%2f000278%2f18020361_1_lg.jpeg&ehk=dpbY5ovF0zXGJtlNbJQ%2fHkOFUwsKLSAqmKvCxIUyzv8%3d&risl=&pid=ImgRaw&r=0" /></a>
            </div>
            <div className='third-width'>
                <a href="/">
                    <div className='header-link'>HOME</div>
                </a>
            </div>
            <div className='third-width'>
                <a href="/Buy">
                    <div className='header-link'>BUY</div>
                </a>
            </div>
            <div className='third-width'>
                <a href="/SignIn">
                    <div className='header-link'>SIGN-IN</div>
                </a>
            </div>
            <div className='third-width'>
                <a href="/SignUp">
                    <div className='header-link'>SIGN-UP</div>
                </a>
            </div>
            <div className='third-width'>
                <a href="/Admin">
                    <div className='header-link'>ADMIN</div>
                </a>
            </div>
        </div>
    )
}

export default Header;