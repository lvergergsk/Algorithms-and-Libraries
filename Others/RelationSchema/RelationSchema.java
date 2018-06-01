import java.util.*;

public class RelationSchema {
    private HashMap<String, String> FDs;
    private Set<String> attributes;

    RelationSchema() {
        FDs = new HashMap<>();
        attributes = new HashSet<>();
    }

    public static void main(String[] args) {
        RelationSchema schema = new RelationSchema();
        schema.addFd("A", "B");
        schema.addFd("B", "C");
        schema.addAttribute("D");
        schema.listFds();
        Set<String> closureOfA = schema.closure(new HashSet<>(Arrays.asList("B")));
        System.out.println("Closure of A: " + closureOfA.toString());
    }

    void addFd(String A, String B) {
        FDs.put(A, B);
        attributes.add(A);
        attributes.add(B);
    }

    void addAttribute(String A) {
        attributes.add(A);
    }

    Set<String> closure(Set<String> attribute) {
        Set<String> res = new HashSet<>(attribute);
        int oldSize;
        do {
            oldSize = res.size();
            Iterator it = FDs.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                if (res.contains(pair.getKey())) res.add((String) pair.getValue());
            }
        } while (oldSize != res.size());
        return res;
    }

    void listFds() {
        Iterator it = FDs.entrySet().iterator();
        System.out.print("Functional Dependency:\n{ ");
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.print(pair.getKey() + "->" + pair.getValue() + " ");
        }
        System.out.println("}");
        System.out.println("Attributes:");
        System.out.println(attributes.toString());
    }

}
