<<<<<<< HEAD

=======
>>>>>>> 0307632b69b2571d5e0561139c94acffd5a650db
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../../css/pages/buy.css'
import { useNavigate } from 'react-router-dom';
function Buy(props) {

  const [cars, setCars] = useState([])
  const [selectedCar, setSelectedCar] = useState(null)
  const [isModalOpen, setIsModalOpen] = useState(false);
  const navigate = useNavigate();


  useEffect(() => {
    axios.get("http://localhost:8080/car/findCarsInInventory")
      .then((response) => {
        setCars(response.data)
      })
      .catch((e) => {
        console.log(e)
      })
  }, [])

  const goToCheckout = (car) => {
<<<<<<< HEAD
    navigate("/checkout",{ state: {car: car, user: props.user} });
=======
    navigate("/checkout",{ state: {car, user: props.user} });
>>>>>>> 0307632b69b2571d5e0561139c94acffd5a650db
  }

  const handleCarClick = (car) => {
    setSelectedCar(car);
    setIsModalOpen(true);
  }

  const closeModal = () => {
    setIsModalOpen(false);
  }
  const showCars = () => {
    return cars.map(
      (car) => {
        return (
          <div className='car-card' key={car.id} onClick={() => handleCarClick(car)}>
            <img src={car.carPhotos[0]} alt={car.model} />
          </div>
        )
      }
    )
  }

  const showCarPhotos = (car) => {
    return (
        <div className="image-grid">
            {car.carPhotos.map((photo) => (
                <img src={photo} alt={car.model} key={photo.id} />
            ))}
        </div>
    );
};

  return (
    <div className='buy-content'>
      {showCars()}
      {setIsModalOpen && selectedCar && (
        <div>
          <div>
            <button onClick={closeModal}>Close</button>
          </div>
          <div>
            {/* All of the items below still need organized and css'd also add image grid css*/}
            {selectedCar.description}
            {selectedCar.make}
            {selectedCar.model}
            {selectedCar.year}
            {selectedCar.miles}
            {selectedCar.dateAdded}

            {selectedCar.price}
            <div>
              {showCarPhotos(selectedCar)}
            </div>
          </div>
          <div>
<<<<<<< HEAD
           <button onClick={() => goToCheckout(selectedCar)}>Checkout</button>
=======
            <button onClick={goToCheckout(selectedCar)}>Checkout</button>
>>>>>>> 0307632b69b2571d5e0561139c94acffd5a650db
          </div>
        </div>
      )}
    </div>
  )
}

<<<<<<< HEAD
export default Buy
=======
export default Buy
>>>>>>> 0307632b69b2571d5e0561139c94acffd5a650db
