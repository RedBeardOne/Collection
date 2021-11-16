package Phone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class GroupBy {

    public static <T> List<T> searchAll(List<T> collect, String str, ISearch<T> callMe) {
        List<T> matches = new ArrayList<>();
        for (T t : collect) {
            if (callMe.find(t, str)) {
                matches.add(t);
            }
        }
        return matches;
    }

}
