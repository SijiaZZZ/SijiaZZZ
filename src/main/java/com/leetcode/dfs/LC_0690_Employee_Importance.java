package com.leetcode.dfs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Time Complexity O(N) - N is the # of employee, need to go through each
 * <p>
 * Space Complexity O(N) - N is the # of employee, getImportanceHelper call times
 */
public class LC_0690_Employee_Importance {

  public int getImportance(List<Employee> employees, int id) {
    // build a map
    Map<Integer, Employee> idMap = new HashMap<Integer, Employee>();
    for (Employee e : employees) {
      idMap.put(e.id, e);
    }
    return getImportanceHelper(idMap, id);
  }

  private int getImportanceHelper(Map<Integer, Employee> idMap, int id) {
    Employee e = idMap.get(id);
    int subImportance = 0;
    if (e.subordinates.isEmpty()) {
      return e.importance;
    }
    for (int sub : e.subordinates) {
      subImportance += getImportanceHelper(idMap, sub);
    }
    return e.importance + subImportance;
  }
}
