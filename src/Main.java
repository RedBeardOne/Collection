import Phone.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Contact Vasya = new Contact("Vasya", "Ivanov", "073 228 11 13");
        Contact Serhiy = new Contact("Serhiy", "Azinov", "093 221 21 53");

        Callog firz = new Callog("073 228 11 13", LocalDateTime.of(2021, 11, 4, 17, 0, 10), Duration.ofMillis(100L));
        Callog secons = new Callog("073 228 11 13", LocalDateTime.of(2021, 11, 3, 10, 1, 11), Duration.ofMillis(200L));
        Callog thirsz = new Callog("093 221 21 53", LocalDateTime.of(2021, 11, 5, 11, 33, 14), Duration.ofMillis(300L));
        Callog fours = new Callog("093 221 21 53", LocalDateTime.of(2021, 11, 6, 22, 9, 19), Duration.ofMillis(150L));

        Message messageone = new Message("073 228 11 13", "I home");
        Message messagnew = new Message("073 228 11 13", "I out");
        Message messagemeow = new Message("093 221 21 53", "Cat hungry");
        Message messagemeo = new Message("093 221 21 53", "Cat walking");

        List<Contact> contacts = new ArrayList<>();
        contacts.add(Vasya);
        contacts.add(Vasya);
        contacts.add(Serhiy);
        List<Callog> callogs = new ArrayList<>();
        callogs.add(firz);
        callogs.add(secons);
        callogs.add(thirsz);
        callogs.add(fours);
        List<Message> messages = new ArrayList<>();
        messages.add(messageone);
        messages.add(messagnew);
        messages.add(messagemeow);
        messages.add(messagemeo);
        Message mesSearcg = Search.searchLog(messages,"093 221 21 53", new ISearch<Message>() {
            @Override
            public boolean find(Message input, String search) {
                return input.getNumber().equals(search);
            }
        });
        Callog logFin = Search.searchLog(callogs, "093 221 21 53", new ISearch<Callog>() {
            @Override
            public boolean find(Callog input, String search) {
                return input.getNumber().equals(search);
            }
        });
        Contact contFin = Search.searchLog(contacts, "073 228 11 13", new ISearch<Contact>() {
            @Override
            public boolean find(Contact input, String search) {
                return input.getNumber().equals(search);
            }
        });
        List<Message> finded = Search.search(messages, "093 221 21 53", new ISearch<Message>() {
            @Override
            public boolean find(Message input, String search) {
                return input.getNumber().equals(search);
            }
        });
        for (Message message : finded) {
            System.out.println(message.getNumber() + " " + message.getText());
        }
        Set<Contact> contSet = new HashSet<>(contacts);
        Set<Callog> messgesSet = new HashSet<>(callogs);
        Set<Message> callogsSet = new HashSet<>(messages);
        System.out.println(Search.searchDouble(contSet));
        System.out.println(Search.searchDouble(messgesSet));
        System.out.println(Search.searchDouble(callogsSet));

    }
}
