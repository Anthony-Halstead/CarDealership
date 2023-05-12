import React, { useEffect, useState } from 'react';
import './App.css';
import Home from './components/pages/Home';
import Buy from './components/pages/Buy';
import SignUp from './components/pages/SignUp';
import SignIn from './components/pages/SignIn';
import Admin from './components/pages/Admin';
import PageWrapper from './components/reusables/PageWrapper';
import { Route, Routes } from 'react-router-dom';

function App() {
  const [user, setUser] = useState({ username: '', password: '' });

  useEffect(() => {
    const username = localStorage.getItem("usernameCookie");
    if (username) {
      setUser({ ...user, username });
    }
  }, []);

  return (
    <PageWrapper>
      <Routes>
        <Route path="/" element={<Home/>} />
        <Route path="/Buy" element={<Buy user={user} setUser={setUser}/>} />
        <Route path="/SignUp" element={<SignUp user={user} setUser={setUser} />} />
        <Route path="/SignIn" element={<SignIn user={user} setUser={setUser} />} />
        <Route path="/Admin" element={<Admin />} />
      </Routes>
    </PageWrapper>
  );
}

export default App;