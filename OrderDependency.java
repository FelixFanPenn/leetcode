package Practice;

import java.util.*;
class Order{
    String orderName;
    public Order(String orderName)
    {
        this.orderName = orderName;
    }
}
class OrderDependency{
    Order order;
    Order dependent;
    public OrderDependency(Order order, Order dependent)
    {
        this.order = order;
        this.dependent = dependent;
    }
}
class Solution {
    public static List<Order> findOrder(List<OrderDependency> dependency) {
        Map<String, Integer> inMap = new HashMap<>();
        Map<String, List<String>> outMap = new HashMap<>();
        
        for (OrderDependency od : dependency) {
            if (!inMap.containsKey(od.order.orderName)) inMap.put(od.order.orderName, 0);
            if (!inMap.containsKey(od.dependent.orderName)) inMap.put(od.dependent.orderName, 0);
            inMap.put(od.order.orderName, inMap.get(od.order.orderName) + 1);
            
            if (!outMap.containsKey(od.dependent.orderName)) {
                outMap.put(od.dependent.orderName, new ArrayList<>());
            }
            outMap.get(od.dependent.orderName).add(od.order.orderName);
        }
        
        List<Order> orders = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
    
        for (String string : inMap.keySet()) {
            if (inMap.get(string) == 0) {
                queue.offer(string);
            }
        }
        
        while (!queue.isEmpty()) {
            String string = queue.poll();
            orders.add(new Order(string));
            
            for (String key : outMap.get(string)) {
                inMap.put(key, inMap.get(key)-1);
                if (inMap.get(key) == 0) {
                    queue.offer(key);
                    inMap.remove(key);
                }
            }
        }
        
        return orders;
    }
}


