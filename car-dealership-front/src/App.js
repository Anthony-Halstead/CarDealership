import React, { useEffect, useState } from 'react';
import './App.css';
import Home from './components/pages/Home';
import Buy from './components/pages/Buy';
import SignIn from './components/pages/SignIn';
import SignUp from './components/pages/SignUp';
import Admin from './components/pages/Admin';
import PageWrapper from './components/reusables/PageWrapper';
import { Route, Routes } from 'react-router-dom';
import Checkout from './components/pages/Checkout';

function App() {
  const [user, setUser] = useState({ id: 0, userName: "", password: "", isAdmin: false});

  
  useEffect(() => {
    const id = localStorage.getItem("userId");
    if (id) {
      setUser({ ...user, id });
    }
  }, []);

  return (
    <PageWrapper
    user = {user}
    setUser = {setUser}
    >
      <Routes>
        <Route path="/" element={<Home user={user} setUser={setUser}/>} />
        <Route path="/Buy" element={<Buy user={user} setUser={setUser}/>} />
        <Route path="/SignIn" element={<SignIn user={user} setUser={setUser} />} />
        <Route path="/SignUp" element={<SignUp user={user} setUser={setUser} />} />
        <Route path="/Checkout" element={<Checkout user={user} setUser={setUser} />} />
        <Route path="/Admin" element={<Admin />} />
      </Routes>
    </PageWrapper>
  );
}

export default App;