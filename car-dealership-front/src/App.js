import React, { useEffect, useState } from 'react';
import './App.css';
import Home from './components/pages/Home';
import Buy from './components/pages/Buy';
<<<<<<< HEAD
import SignIn from './components/pages/SignIn';
import SignUp from './components/pages/SignUp';
=======
import SignUp from './components/pages/SignUp';
import SignIn from './components/pages/SignIn';
>>>>>>> 0307632b69b2571d5e0561139c94acffd5a650db
import Admin from './components/pages/Admin';
import PageWrapper from './components/reusables/PageWrapper';
import { Route, Routes } from 'react-router-dom';

function App() {
<<<<<<< HEAD
  const [user, setUser] = useState({ userName: "", password: "", isAdmin: false});

  useEffect(() => {
    const userName = localStorage.getItem("userNameCookie");
    if (userName) {
      setUser({ ...user, userName });
=======
  const [user, setUser] = useState({ username: '', password: '' });

  useEffect(() => {
    const username = localStorage.getItem("usernameCookie");
    if (username) {
      setUser({ ...user, username });
>>>>>>> 0307632b69b2571d5e0561139c94acffd5a650db
    }
  }, []);

  return (
<<<<<<< HEAD
    <PageWrapper
    user = {user}
    setUser = {setUser}
    >
      <Routes>
        <Route path="/" element={<Home user={user} setUser={setUser}/>} />
        <Route path="/Buy" element={<Buy user={user} setUser={setUser}/>} />
        <Route path="/SignIn" element={<SignIn user={user} setUser={setUser} />} />
        <Route path="/SignUp" element={<SignUp user={user} setUser={setUser} />} />
=======
    <PageWrapper>
      <Routes>
        <Route path="/" element={<Home/>} />
        <Route path="/Buy" element={<Buy user={user} setUser={setUser}/>} />
        <Route path="/SignUp" element={<SignUp user={user} setUser={setUser} />} />
        <Route path="/SignIn" element={<SignIn user={user} setUser={setUser} />} />
>>>>>>> 0307632b69b2571d5e0561139c94acffd5a650db
        <Route path="/Admin" element={<Admin />} />
      </Routes>
    </PageWrapper>
  );
}

export default App;