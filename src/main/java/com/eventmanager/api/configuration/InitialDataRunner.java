package com.eventmanager.api.configuration;

import com.eventmanager.api.entity.Event;
import com.eventmanager.api.entity.User;
import com.eventmanager.api.repository.EventRepository;
import com.eventmanager.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
@AllArgsConstructor
public class InitialDataRunner implements CommandLineRunner {
    private EventRepository eventRepository;
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    public void seedData() {
        User adminUser = User.builder()
                .email("admin@gmail.com")
                .firstName("Admin")
                .lastName("Admin")
                .role("admin")
                .phone("+35500000000")
                .password("test")
                .build();

        Optional<User> dbAdmin = userRepository.findByEmailEqualsIgnoreCase(adminUser.getEmail());
        if (dbAdmin.isEmpty())
            adminUser = userRepository.save(adminUser);
        else adminUser = dbAdmin.get();

        createIfNotPresent("Enrique Iglesias", "The first event of year!", "2023-09-26", adminUser.getId(), 10000, "eiglesias.jpg",12);
        createIfNotPresent("Ricky Martin", "The second event of year!", "2023-10-26", adminUser.getId(), 100000, "rmartin.jpg",56);
        createIfNotPresent("Sinan Hoxha", "The third event of year!", "2023-12-12", adminUser.getId(), 1000, "shoxha.jpeg",1);
        createIfNotPresent("Elvana Gjata", "The fourth event of year!", "2024-01-01", adminUser.getId(), 10000, "egjata.jpg",96);
        createIfNotPresent("Event11", "The eleventh event of year!", "2023-07-15", adminUser.getId(), 10000, "event11.jpeg",4);
        createIfNotPresent("Event5", "The fifth event of year!", "2023-09-10", adminUser.getId(), 10000, "event5.jpeg",15);
        createIfNotPresent("Event6", "The sixth event of year!", "2024-08-25", adminUser.getId(), 10000, "event6.jpeg",7);
        createIfNotPresent("Event7", "The seventh event of year!", "2024-03-12", adminUser.getId(), 10000, "event7.jpeg",35);
        createIfNotPresent("Event8", "The eighth event of year!", "2024-12-08", adminUser.getId(), 10000, "event8.jpeg",102);
        createIfNotPresent("Event9", "The ninth event of year!", "2024-06-24", adminUser.getId(), 10000, "event9.jpeg",500);
        createIfNotPresent("Event10", "The tenth event of year!", "2024-04-30", adminUser.getId(), 10000, "event10.jpeg",11);
        createIfNotPresent("Event12", "The twelfth event of year!", "2023-04-30", adminUser.getId(), 10000, "event12.jpeg",6);
        createIfNotPresent("Event13", "The thirteenth event of year!", "2023-05-20", adminUser.getId(), 10000, "event13.jpeg",28);
    }

    public void createIfNotPresent(String title, String description, String date, int ownerId, int maxBooking, String banner, int views) {
        LocalDate firstEventDate = LocalDate.parse(date);
        Event firstEvent = Event.builder()
                .title(title)
                .eventDate(firstEventDate)
                .description(description)
                .maxBookings(maxBooking)
                .ownerId(ownerId)
                .banner(banner)
                .views(views)
                .build();

        Optional<Event> firstEventDb = eventRepository.findByTitleEqualsIgnoreCaseAndEventDateEquals(firstEvent.getTitle(), firstEvent.getEventDate());
        if (firstEventDb.isEmpty())
            firstEvent = eventRepository.save(firstEvent);
        else firstEvent = firstEventDb.get();
    }
}