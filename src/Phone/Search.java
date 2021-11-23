package Phone;

import java.util.*;
import java.util.function.Predicate;


public class Search {

    public static <T> T searchLog(List<T> collect, String str, ISearch<T> callMe) {
        for (T t : collect) {
            if (callMe.find(t, str)) {
                return t;
            }
        }
        return null;
    }

    public static <S> List<S> search(List<S> collect, String str, ISearch<S> callMe) {
        List<S> matches = new ArrayList<>();
        for (S s : collect) {
            if (callMe.find(s, str)) {
                matches.add(s);
            }
        }
        return matches;
    }

    public static <S> boolean searchDouble(Set<S> collect) {
        int count = 0;
        for (S s : collect) {
            for (S s1 : collect) {
                if (s.equals(s1)) {
                    count++;
                    if (count > 1) {
                        return true;
                    }
                }
            }
            count = 0;
        }
        return false;
    }

    public static List<Pair<Contact, Integer>> findQuantytiCalls(List<Contact> contacts, List<Callog> calllog) {
        List<Pair<Contact, Integer>> collection = new ArrayList<>();
        for (Contact contact : contacts) {
            Pair<Contact, Integer> res = Search.findContInt(contact, calllog);
            collection.add(res);
        }
        return collection;
    }
    public static List<Pair<Contact, Integer>>  findQuantytyMessage( List <Contact> contacts, List<Message> messages){
        List<Pair<Contact, Integer>> collection = new ArrayList<>();
        for (Contact contact : contacts) {
            Pair<Contact, Integer> res = Search.findMessageInt(contact, messages);
            collection.add(res);
        }
        return collection;
        }

    private static Pair<Contact, Integer> findMessageInt(Contact contact, List<Message> messages){
        Collection<Message>finded = Search.findMessageForCont(messages, new Predicate<Message>(){

            @Override
            public boolean test(Message message) {
                return message.getNumber().equals(contact.getNumber());
            }
        });
        Pair<Contact, Integer> result = new Pair<>(contact, finded.size());
        return result;
    }


    private static Pair<Contact, Integer> findContInt(Contact contact, List<Callog> callogs) {
        Collection<Callog> finded = Search.findCallsForCont(callogs, new Predicate<Callog>() {
            @Override
            public boolean test(Callog callog) {
                return callog.getNumber().equals(contact.getNumber());
            }
        });
        Pair<Contact, Integer> result = new Pair<>(contact, finded.size());
        return result;
    }
    private static Collection<Message>  findMessageForCont (List<Message> messages, Predicate<Message> predicate){
        Collection<Message> temp = new ArrayList<>();
        for (Message message : messages) {
            if (predicate.test(message)){
                temp.add(message);
            }
        }
        return temp;
    }


    private static Collection<Callog> findCallsForCont(List<Callog> calls, Predicate<Callog> predicate) {
        Collection<Callog> temp = new ArrayList<Callog>();
        for (Callog call : calls) {
            if (predicate.test(call)) {
                temp.add(call);
            }
        }
        return temp;
    }

    public static Map<Contact, Integer> sortByInteger(Map<Contact, Integer> map) {
        List<Map.Entry<Contact, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Contact, Integer>>() {
            @Override
            public int compare(Map.Entry<Contact, Integer> o1, Map.Entry<Contact, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        Map<Contact, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Contact, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
