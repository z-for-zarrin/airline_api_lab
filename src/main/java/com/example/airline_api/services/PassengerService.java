package com.example.airline_api.services;

import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;
}
