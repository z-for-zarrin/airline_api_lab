package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // PASSENGERS
        Passenger roseGoldman = new Passenger("Rose Goldman", "rgoldman3@email.com");
        Passenger gussyBreyt = new Passenger("Gussy Breyt", "gbreyt8@wordpress.com");
        Passenger cobGwilliam = new Passenger("Cob Gwilliam", "cgwilliaml@craigslist.org");
        Passenger brianRootes = new Passenger("Brian Rootes", "iambroote@bbc.com");
        Passenger jorganLeckie = new Passenger("Jorgan Leckie", "jleckie21@paginegialle.it");

        passengerRepository.save(roseGoldman);
        passengerRepository.save(gussyBreyt);
        passengerRepository.save(cobGwilliam);
        passengerRepository.save(brianRootes);
        passengerRepository.save(jorganLeckie);

        // FLIGHTS
        Flight italy = new Flight("Rome", 200, LocalDate.of(2024, 3, 3), LocalTime.of(7,35));
        Flight morocco = new Flight("Marrakesh", 250, LocalDate.of(2024, 4, 7), LocalTime.of(12,30));
        Flight japan = new Flight("Tokyo", 300, LocalDate.of(2024, 7, 10), LocalTime.of(20, 18));

        // ASSIGNMENT
        italy.addPassenger(gussyBreyt);
        italy.addPassenger(cobGwilliam);
        italy.addPassenger(jorganLeckie);

        morocco.addPassenger(roseGoldman);
        morocco.addPassenger(gussyBreyt);
        morocco.addPassenger(cobGwilliam);
        morocco.addPassenger(brianRootes);

        japan.addPassenger(roseGoldman);
        japan.addPassenger(brianRootes);


        flightRepository.save(italy);
        flightRepository.save(morocco);
        flightRepository.save(japan);


    }
}
