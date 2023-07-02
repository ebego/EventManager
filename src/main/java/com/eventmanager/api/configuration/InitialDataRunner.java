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

        createIfNotPresent("Enrique Iglesias", "The first event of year!", "2023-09-26", adminUser.getId(), 10000, "eiglesias.jpg");
        createIfNotPresent("Ricky Martin", "The second event of year!", "2023-10-26", adminUser.getId(), 100000, "eiglesias.jpg");
        createIfNotPresent("Sinan Hoxha", "The third event of year!", "2023-12-12", adminUser.getId(), 1000, "eiglesias.jpg");
        createIfNotPresent("Elvana Gjata", "The fourth event of year!", "2024-01-01", adminUser.getId(), 10000, "eiglesias.jpg");
    }

    public void createIfNotPresent(String title, String description, String date, int ownerId, int maxBooking, String banner) {
        LocalDate firstEventDate = LocalDate.parse(date);
        Event firstEvent = Event.builder()
                .title(title)
                .eventDate(firstEventDate)
                .description(description)
                .maxBookings(maxBooking)
                .ownerId(ownerId)
                .banner(banner)
                .build();

        Optional<Event> firstEventDb = eventRepository.findByTitleEqualsIgnoreCaseAndEventDateEquals(firstEvent.getTitle(), firstEvent.getEventDate());
        if (firstEventDb.isEmpty())
            firstEvent = eventRepository.save(firstEvent);
        else firstEvent = firstEventDb.get();
    }
}
