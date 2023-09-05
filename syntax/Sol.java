import java.util.HashMap;
import java.util.Map;

public class Sol {
    public static void main(String[] args) {
        // mutable
        Map<String, Integer> hashMap = new HashMap<String, Integer>() {{
            put("one", 1);
            put("two", 2);
            put("three", 3);
        }};

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey()+ ": "+entry.getValue());
        }
    }
}
