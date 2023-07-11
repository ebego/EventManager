package com.eventmanager.api.configuration;

import com.eventmanager.api.entity.Event;
import com.eventmanager.api.entity.User;
import com.eventmanager.api.repository.EventRepository;
import com.eventmanager.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

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

        createIfNotPresent("Boat ride on the lake", "This weekend it's time to sail, so in Tirana Lake you will see the boats. On Sunday, at 09:00, we invite you all, so that together with your family or friends, you can spend a different, fun, quiet and fresh weekend in nature.", "2023-07-16", adminUser.getId(), 40, "img_1.png",12, 50,"Tirane");
        createIfNotPresent("Wedding in the Castle", "This activity will bring together many talented young professionals in different genres, such as ballet, dance, song, performance, instrument, culinary, embroidery, etc.", "2023-07-21", adminUser.getId(), 400, "weding.png",56,500,"Shkoder");
        createIfNotPresent("Korce Beer Festival", "Korce Beer Festival is held every year in August in the city of Korce, home to the oldest and favorite brand of beer. Traditional foods, live music with some international bands playing are featured on the festival menu.", "2023-08-15", adminUser.getId(), 1000, "festaBirres.png",40, 150,"Korce");
        createIfNotPresent("ION Festival 2023", "Set against the stunning backdrop of Dhërmi, a quaint coastal town on the Albanian Riviera, ION is not just a music festival but a destination holiday experience unto itself, with a parallel focus on mindfulness, cultural discovery and community.", "2024-01-01", adminUser.getId(), 10000, "ION.jpg",106, 500,"Dhërmi Beach, Vlorë, Albania");
        createIfNotPresent("Enrique Iglesias", "Enrique Iglesias comes in Tirana for the first time for Spanish Culture Week in Skanderbeg Square on 30th June. We can't wait for his concert here, along with the other famous artists that our city will be expecting this summer!", "2023-07-15", adminUser.getId(), 10000, "enrique.jpg",4,300,"Tirane");
        createIfNotPresent("Elvana Gjata", "Elvana Gjata recently announced that she will be hosting a concert at Air Albania stadium. She said that September 22 will be a very special night for her and she hopes it will be for everyone.", "2023-09-22", adminUser.getId(), 10000, "egjata.jpg",100,42,"Tirane");
        createIfNotPresent("Rita Ora", "Rita Ora is another famous international artist with Albanian blood. She is returning to serve us with an amazing concert.", "2024-08-25", adminUser.getId(), 10000, "rita.jpg",54,24,"Tirane");
        createIfNotPresent("Colour Day Festival", "Colour Day Festival offers entertainment and interactivity throughout the festival, not only energetic music that is on trend but also surprises for the annual faithful of this festival.", "2024-03-12", adminUser.getId(), 10000, "color.jpg",27,18,"Tirane");
        createIfNotPresent("The Pursuit of Art", "‘The Pursuit of Art’ an exhibition by Helidon Gjergji at COD center", "2024-12-08", adminUser.getId(), 10000, "Pursuit.jpg",20,35,"Pogradec");
        createIfNotPresent("Dua Lipa", "Dua Lipa recently announced that she will be hosting a concert at Air Albania stadium this summer.", "2024-06-24", adminUser.getId(), 10000, "dua.jpg",500,70,"Tirane");
        createIfNotPresent("Book Fair", "The Book Fair is one of the most important events at the Palace of Congresses in Tirana", "2024-04-30", adminUser.getId(), 10000, "book.jpg",80,56,"Tirane");
        createIfNotPresent("Sinan Hoxha", "Sinan Hoxha is playing live on Saranda this summer. Book tickets and enjoy the party.", "2023-04-30", adminUser.getId(), 10000, "sinan-2.jpg",6,25,"Sarande");
        createIfNotPresent("South Outdoor Festival", "The South Outdoor Festival is located along the Albanian Riviera in Borsh, in a beautiful venue in southern Albania. This festival combines tradition, food and celebrates Albanian culture.", "2023-05-20", adminUser.getId(), 10000, "SouthFestival.jpg",28,15,"Borsh");

    }

    public void createIfNotPresent(String title, String description, String date, UUID ownerId, int maxBooking, String banner, int views, int price, String location) {
        LocalDate firstEventDate = LocalDate.parse(date);
        Event firstEvent = Event.builder()
                .title(title)
                .eventDate(firstEventDate)
                .description(description)
                .maxBookings(maxBooking)
                .ownerId(ownerId)
                .banner(banner)
                .views(views)
                .price(price)
                .location(location)
                .build();

        Optional<Event> firstEventDb = eventRepository.findByTitleEqualsIgnoreCaseAndEventDateEquals(firstEvent.getTitle(), firstEvent.getEventDate());
        if (firstEventDb.isEmpty())
            firstEvent = eventRepository.save(firstEvent);
        else firstEvent = firstEventDb.get();
    }
}
