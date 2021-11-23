import Phone.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Contact mVasya = new Contact("Vasya", "Ivanov", "073 228 11 13");
        Contact mSerhiy = new Contact("Serhiy", "Azinov", "093 221 21 53");
        Contact mAnri = new Contact("Anri", "Jogi", "094 661 21 53");
        Contact mJack = new Contact("Jack", "Kobi", "095 000 21 53");
        Contact mZack = new Contact("Zack", "Snyder", "066 974 54 53");
        Contact mAnya = new Contact("Anya", "Kolityna", "099 555 34 57");

        Callog first = new Callog("073 228 11 13", LocalDateTime.of(2021, 11, 4, 17, 0, 10), Duration.ofMillis(100L));
        Callog second = new Callog("073 228 11 13", LocalDateTime.of(2021, 11, 3, 10, 1, 11), Duration.ofMillis(200L));
        Callog third = new Callog("093 221 21 53", LocalDateTime.of(2021, 11, 5, 11, 33, 14), Duration.ofMillis(300L));
        Callog fours = new Callog("093 221 21 53", LocalDateTime.of(2021, 11, 6, 22, 9, 19), Duration.ofMillis(150L));
        Callog fifth = new Callog("094 661 21 53", LocalDateTime.of(2021, 11, 6, 22, 9, 19), Duration.ofMillis(308L));
        Callog sixth = new Callog("095 000 21 53", LocalDateTime.of(2021, 11, 6, 22, 9, 19), Duration.ofMillis(888L));
        Callog seven = new Callog("066 974 54 53", LocalDateTime.of(2021, 11, 6, 22, 9, 19), Duration.ofMillis(888L));
        Callog eight = new Callog("095 000 21 53", LocalDateTime.of(2021, 11, 6, 22, 9, 19), Duration.ofMillis(888L));
        Callog ninth = new Callog("099 555 34 57", LocalDateTime.of(2021, 11, 6, 22, 9, 19), Duration.ofMillis(888L));
        Callog tenth = new Callog("099 555 34 57", LocalDateTime.of(2021, 11, 6, 22, 9, 18), Duration.ofMillis(657L));

        Message messageone = new Message("073 228 11 13", "I home");
        Message messagnew = new Message("073 228 11 13", "I out");
        Message messagemeow = new Message("093 221 21 53", "Cat hungry");
        Message onemess = new Message("094 661 21 53", "one");
        Message twomess = new Message("095 000 21 53", "two");
        Message threemess = new Message("066 974 54 53", "three");
        Message fourmess = new Message("099 555 34 57", "gourmet");
        Message fivemess = new Message("099 555 34 57", "five");

        List<Contact> contacts = new ArrayList<>();
        contacts.add(mVasya);
        contacts.add(mSerhiy);
        contacts.add(mAnri);
        contacts.add(mJack);
        contacts.add(mZack);
        contacts.add(mAnya);

        List<Callog> callogs = new ArrayList<>();
        callogs.add(first);
        callogs.add(second);
        callogs.add(third);
        callogs.add(fours);
        callogs.add(fifth);
        callogs.add(sixth);
        callogs.add(seven);
        callogs.add(eight);
        callogs.add(ninth);
        callogs.add(tenth);
        callogs.add(tenth);

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
            String number = contact.getNumber();
            bookPhone.put(number, contact);
        }
        Map<String, List<Message>> logMessage = new HashMap<>();
        for (Contact contact : contacts) {
            String number = contact.getNumber();
            List<Message> messageList = Search.search(messages, number, new ISearch<Message>() {
                @Override
                public boolean find(Message input, String search) {
                    return input.getNumber().equals(search);
                }
            });
            logMessage.put(number, messageList);
        }
        Map<String, Contact> bookPhoneCall = new HashMap<>();
        for (Contact contact : contacts) {
            String number = contact.getNumber();
            bookPhoneCall.put(number, contact);
        }
        Map<String, List<Callog>> logCalls = new HashMap<>();
        for (Contact contact : contacts) {
            String number = contact.getNumber();
            List<Callog> callsLog = Search.search(callogs, number, new ISearch<Callog>() {
                @Override
                public boolean find(Callog input, String search) {
                    return input.getNumber().equals(search);
                }
            });
            logCalls.put(number, callsLog);
        }
        for (String s : bookPhoneCall.keySet()) {
            Contact contact = bookPhoneCall.get(s);
            List<Callog> historyCall = logCalls.get(s);
            System.out.println("History of calls by " + contact.getName() + ":");
            for (Callog callog : historyCall) {
                System.out.println("Date of call " + callog.getDateCall() + ", time of call " + callog.getTime());
            }
        }
        homeTaskSeveList(contacts, callogs);
        homeTaskSevenMap(contacts, callogs);
        homeTaskEightMap(contacts, messages);
        queSomeTry(contacts);
        System.out.println("Task number 8:");
        homePairInList(contacts, messages);



    }


    /**
     * task 12.10.2021
     */


    private static void homeTaskSevenMap(List<Contact> contacts, List<Callog> callogs) {
        Map<Contact, Integer> mapForSeven = new HashMap<>();
        for (Contact contact : contacts) {
            String search = contact.getNumber();
            List<Callog> found = Search.search(callogs, search, new ISearch<Callog>() {
                @Override
                public boolean find(Callog input, String search) {
                    return input.getNumber().equals(search);
                }
            });
            Integer size = found.size();
            mapForSeven.put(contact, size);
        }
        Map<Contact, Integer> sorterMap = Search.sortByInteger(mapForSeven);
        int stop = 0;
        for (Contact contact : sorterMap.keySet()) {
            if (stop > 4) {
                break;
            }
            Integer integer = sorterMap.get(contact);
            System.out.println(contact.getName() + " Quantity of calls " + integer);
            stop++;
        }
    }

    private static void homeTaskEightMap(List<Contact> contacts, List<Message> messages) {
        Map<Contact, Integer> result = new HashMap<>();
        for (Contact contact : contacts) {
            String search = contact.getNumber();
            List<Message> found = Search.search(messages, search, new ISearch<Message>() {
                @Override
                public boolean find(Message input, String search) {
                    return input.getNumber().equals(search);
                }
            });
            Integer size = found.size();
            result.put(contact, size);
        }
    }

    private static void homePairInList(List<Contact> contacts, List<Message> messages) {
        List<Pair<Contact, Integer>> numbersOfMesage = Search.findQuantytyMessage(contacts, messages);
        for (Pair<Contact, Integer> contactIntegerPair : numbersOfMesage) {
            System.out.println("Number " + contactIntegerPair.getFirst().getNumber() + " Quantity of messages " + contactIntegerPair.getSecond().byteValue());
        }
        numbersOfMesage.sort((o1, o2) -> {
            int size1 = o1.getSecond();
            int size2 = o2.getSecond();
            return Integer.compare(size2, size1);
        });
        System.out.println("sorted collection, task 8:");
        int stop = 0;
        for (Pair<Contact, Integer> contactIntegerPair : numbersOfMesage) {
            if (stop > 4) {
                break;
            }
            System.out.println("Number " + contactIntegerPair.getFirst().getNumber() + " Quantity of messages " + contactIntegerPair.getSecond().byteValue());
            stop++;
        }
    }


    private static void homeTaskSeveList(List<Contact> contacts, List<Callog> callogs) {
        List<Pair<Contact, Integer>> numberOfCalls = Search.findQuantytiCalls(contacts, callogs);
        for (Pair<Contact, Integer> numberOfCall : numberOfCalls) {
            System.out.println("Number " + numberOfCall.getFirst().getNumber() + " Quantity of calls " + numberOfCall.getSecond().byteValue());
        }
        numberOfCalls.sort((o1, o2) -> {
            int size1 = o1.getSecond();
            int size2 = o2.getSecond();
            return Integer.compare(size2, size1);
        });


        System.out.println("sorted collection");
        int stop = 0;
        for (Pair<Contact, Integer> numberOfCall : numberOfCalls) {
            if (stop > 4) {
                break;
            }
            System.out.println("Number " + numberOfCall.getFirst().getNumber() + " Quantity of calls " + numberOfCall.getSecond().byteValue());
            stop++;
        }
    }

    private static void queSomeTry(List<Contact> contacts) {
        Queue<Contact> cherga = new ArrayDeque<>();
        for (Contact contact : contacts) {
            cherga.add(contact);
        }
        for (Contact contact : cherga) {
            System.out.println("Que try " + contact);
        }
    }
}

