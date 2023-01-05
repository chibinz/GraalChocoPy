package org.chocopy;

import java.util.HashMap;

public class GlobalScope {
    private final HashMap<String, Object> memory = new HashMap<String, Object>();

    public Object get(String id) {
        return memory.get(id);
    }

    public void put(String id, Object val) {
        memory.put(id, val);
    }

    public String toString() {
        return memory.toString();
    }
}
