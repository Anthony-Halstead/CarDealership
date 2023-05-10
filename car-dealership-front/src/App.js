import './App.css';
import { Route, Routes } from 'react-router';
import Home from './components/pages/Home';
import Buy from './components/pages/Buy';
import SignUpSignIn from './components/pages/SignUpSignIn';
import Admin from './components/pages/Admin';
import PageWrapper from './components/reusables/PageWrapper';

function App() {
  return (
    <PageWrapper>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/Buy" element={<Buy />} />
        <Route path="/SignUpSignIn" element={<SignUpSignIn />} />
        <Route path="/Admin" element={<Admin />} />
      </Routes>
    </PageWrapper>
  );
}

export default App;