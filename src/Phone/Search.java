package Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
        int count= 0;
        for (S s : collect) {
            for (S s1 : collect) {
                if (s.equals(s1)) {
                   count++;
                   if (count>1){
                       return true;
                   }
                }
            }
            count =0;
        }
        return false;
    }
}
