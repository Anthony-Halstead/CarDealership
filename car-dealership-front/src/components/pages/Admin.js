import React, { useState } from 'react'
import '../../css/pages/signupsignin.css'
import '../../css/reusables/positions.css'
import axios from 'axios';
import { useNavigate } from 'react-router';

function Admin()  {

  const [reportDates, setReportDates] = useState({startDate: '', endDate: '' });

  const navigator = useNavigate()

    const changeHandler = (event) => {
    const name = event.target.name;
    const value = event.target.value;
    const tempReportDates = { ...reportDates};
    tempReportDates[name] = value;

    setReportDates(tempReportDates)
    }

  const reportSubmitHandler = () => {
    axios.post("http://localhost:8080/car/findCarsSold/${reportDates.startDate}`/${reportDates.endDate}`")
      .then((response) => {
        let text = response.data
        const obj = JSON.parse(text);
      })
      .catch((e) => {
        console.log(e)
      })

    }



    return (
        <div className='signup-signin-content'>
            <div className='sign-up-box'>
                <div>
                    Hello Dealer
                </div>
                    <h1>Run Report</h1>
                <div className='flex-row justify-content-left'>
                    Report Start Date
                    <input className='input-container'  value={reportDates.startDate} name='startDate' type='startDate' onChange={changeHandler} required></input>
                </div>
                <div className='-row justify-content-left'>
                    Report End Date
                    <input className='input-container' value={reportDates.endDate} name='endDate' type='endDate' onChange={changeHandler} required></input>
                </div>
                <div className='flex-row justify-content-center'>
                    <button role="button" onClick={reportSubmitHandler}>SUBMIT</button>
                </div>
        </div>        
        </div>
    

      
   )
}



export default Admin