import Phone.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Contact Vasya = new Contact("Vasya", "Ivanov", "073 228 11 13");
        Contact Serhiy = new Contact("Serhiy", "Azinov", "093 221 21 53");
        Contact Anri = new Contact("Anri", "Jogi", "094 661 21 53");
        Contact Jack = new Contact("Jack", "Kobi", "095 000 21 53");
        Contact Zack = new Contact("Zack", "Snyder", "066 974 54 53");
        Contact Anya = new Contact("Anya", "Kolityna", "099 555 34 57");

        Callog firz = new Callog("073 228 11 13", LocalDateTime.of(2021, 11, 4, 17, 0, 10), Duration.ofMillis(100L));
        Callog secons = new Callog("073 228 11 13", LocalDateTime.of(2021, 11, 3, 10, 1, 11), Duration.ofMillis(200L));
        Callog thirsz = new Callog("093 221 21 53", LocalDateTime.of(2021, 11, 5, 11, 33, 14), Duration.ofMillis(300L));
        Callog fours = new Callog("093 221 21 53", LocalDateTime.of(2021, 11, 6, 22, 9, 19), Duration.ofMillis(150L));
        Callog fiveth = new Callog("094 661 21 53", LocalDateTime.of(2021, 11, 6, 22, 9, 19), Duration.ofMillis(308L));
        Callog sixty = new Callog("095 000 21 53", LocalDateTime.of(2021, 11, 6, 22, 9, 19), Duration.ofMillis(888L));
        Callog seven = new Callog("066 974 54 53", LocalDateTime.of(2021, 11, 6, 22, 9, 19), Duration.ofMillis(888L));
        Callog eigth = new Callog("095 000 21 53", LocalDateTime.of(2021, 11, 6, 22, 9, 19), Duration.ofMillis(888L));
        Callog nineth = new Callog("099 555 34 57", LocalDateTime.of(2021, 11, 6, 22, 9, 19), Duration.ofMillis(888L));

        Message messageone = new Message("073 228 11 13", "I home");
        Message messagnew = new Message("073 228 11 13", "I out");
        Message messagemeow = new Message("093 221 21 53", "Cat hungry");
        Message onemess = new Message("094 661 21 53", "one");
        Message twomess = new Message("095 000 21 53", "two");
        Message threemess = new Message("066 974 54 53", "three");
        Message fourmess = new Message("099 555 34 57", "gourmet");
        Message fivemess = new Message("099 555 34 57", "five");

        List<Contact> contacts = new ArrayList<>();
        contacts.add(Vasya);
        contacts.add(Serhiy);
        contacts.add(Anri);
        contacts.add(Jack);
        contacts.add(Zack);
        contacts.add(Anya);

        List<Callog> callogs = new ArrayList<>();
        callogs.add(firz);
        callogs.add(secons);
        callogs.add(thirsz);
        callogs.add(fours);
        callogs.add(fiveth);
        callogs.add(sixty);
        callogs.add(seven);
        callogs.add(eigth);
        callogs.add(nineth);

        List<Message> messages = new ArrayList<>();
        messages.add(messageone);
        messages.add(messagnew);
        messages.add(messagemeow);
        messages.add(onemess);
        messages.add(onemess);
        messages.add(twomess);
        messages.add(threemess);
        messages.add(fourmess);
        messages.add(fivemess);
        Set<Contact> contSet = new HashSet<>(contacts);
        Set<Callog> messgesSet = new HashSet<>(callogs);
        Set<Message> callogsSet = new HashSet<>(messages);
        /* task 08.10.2021   Practice 2b
         */
        Map<String, Contact> bookPhone = new HashMap<>();
        for (Contact contact : contacts) {
            String nunber = contact.getNumber();
            bookPhone.put(nunber, contact);
        }
        Map<String, List<Message>> logMessage = new HashMap<>();
        for (Contact contact : contacts) {
            String nunber = contact.getNumber();
            List<Message> messageList = Search.search(messages, nunber, new ISearch<Message>() {
                @Override
                public boolean find(Message input, String search) {
                    return input.getNumber().equals(search);
                }
            });
            logMessage.put(nunber, messageList);
        }
        Map<String, Contact> bookPhoneCall = new HashMap<>();
        for (Contact contact : contacts) {
            String nunber = contact.getNumber();
            bookPhoneCall.put(nunber, contact);
        }
        Map<String, List<Callog>> logCalls = new HashMap<>();
        for (Contact contact : contacts) {
            String nunber = contact.getNumber();
            List<Callog> callsLog = Search.search(callogs, nunber, new ISearch<Callog>() {
                @Override
                public boolean find(Callog input, String search) {
                    return input.getNumber().equals(search);
                }
            });
            logCalls.put(nunber, callsLog);
        }
        /* task 12.10.2021
         */
        Map<Contact, Integer> res = new HashMap<>();
        for (Contact contact : contacts) {
            String search = contact.getNumber();
            List<Message> finded = Search.search(messages, search, new ISearch<Message>() {
                @Override
                public boolean find(Message input, String search) {
                    return input.getNumber().equals(search);
                }
            });
            Integer n = finded.size();
            res.put(contact, n);
        }


    }
}
