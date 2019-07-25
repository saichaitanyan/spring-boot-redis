package com.redis.demo.utility;

import java.util.HashMap;

public class Utility {
    /**
     * to generate response in JSON format
     *
     * @param obj
     * @param type
     * @return
     */
    static public HashMap<String, Object> generateResponse(Object obj, String type) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("data", obj);
        map.put("status", type.split(" ")[1]);
        return map;
    }

}
