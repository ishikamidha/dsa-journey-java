import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    private Map<Integer, String> checkIns;
    private Map<String, double[]> routes;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, stationName + "," + t);
    }
    
    public void checkOut(int id, String stationName, int t) {
        String[] checkInInfo = checkIns.remove(id).split(",");
        String startStation = checkInInfo[0];
        int startTime = Integer.parseInt(checkInInfo[1]);

        String routeKey = startStation + "->" + stationName;
        int travelTime = t - startTime;

        routes.putIfAbsent(routeKey, new double[2]);

        routes.get(routeKey)[0] += travelTime;
        routes.get(routeKey)[1] += 1;
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        double[] stats = routes.get(routeKey);
        
        return stats[0] / stats[1];
    }
}