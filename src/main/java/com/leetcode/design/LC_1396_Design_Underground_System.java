/**
 * Created by Sijia on 2/18/22
 * Time Complexity:
 * <p>
 * Space Complexity:
 * <p>
 * Hints:
 * <p> 1.
 * <p> 2.
 * <p> 3.
 */

package com.leetcode.design;

import com.leetcode.util.Pair;
import java.util.HashMap;

public class LC_1396_Design_Underground_System {
    HashMap<Integer, Pair<String, Integer>> checkInMap = new HashMap<>();  // Uid - {StationName, Time}
    HashMap<String, Pair<Integer, Integer>> checkoutMap = new HashMap<>(); // Route - {TotalTime, Count}


    public void UndergroundSystem() {}

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkIn = checkInMap.get(id);
        String route = checkIn.getKey() + "_" + stationName;
        int totalTime = t - checkIn.getValue();
        Pair<Integer, Integer> checkout = checkoutMap.getOrDefault(route, new Pair<>(0, 0));
        checkoutMap.put(route, new Pair<>(checkout.getKey() + totalTime, checkout.getValue() + 1));
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "_" + endStation;
        Pair<Integer, Integer> checkout = checkoutMap.get(route);
        return (double) checkout.getKey() / checkout.getValue();
    }
}
