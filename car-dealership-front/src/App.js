import React, { useEffect, useState } from 'react';
import './App.css';
import Home from './components/pages/Home';
import Buy from './components/pages/Buy';
import SignUpSignIn from './components/pages/SignUpSignIn';
import Admin from './components/pages/Admin';
import PageWrapper from './components/reusables/PageWrapper';
import { Route, Routes } from 'react-router-dom';

function App() {
  const [user, setUser] = useState({ username: '', password: '', isAdmin });

  useEffect(() => {
    const username = localStorage.getItem("usernameCookie");
    if (username) {
      setUser({ ...user, username });
    }
  }, []);

  return (
    <PageWrapper
    
    
    >
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/Buy" element={<Buy user={user} setUser={setUser}/>} />
        <Route path="/SignUpSignIn" element={<SignUpSignIn user={user} setUser={setUser} />} />
        <Route path="/Admin" element={<Admin />} />
      </Routes>
    </PageWrapper>
  );
}

export default App;