package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.models.PassengerDTO;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> findFlightById(Long id) {
        return flightRepository.findById(id);
    }

    public void cancelFlight(long id) {
        flightRepository.deleteById(id);
    }

    public Flight bookPassengerByFlightId(long flightId,Passenger passenger) {
        Flight flightToBook = findFlightById(flightId).get();
        passenger.getFlights().add(flightToBook);
        flightToBook.getPassengers().add(passenger);

        flightRepository.save(flightToBook);
        passengerRepository.save(passenger);
        return flightToBook;
    }
}
