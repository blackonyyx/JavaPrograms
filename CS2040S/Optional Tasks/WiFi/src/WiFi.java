import java.util.Arrays;

class WiFi {

    /**
     * Implement your solution here
     */
    public static double computeDistance(int[] houses, int numOfAccessPoints) {
        double lb,ub,m;
        Arrays.sort(houses);
        lb = 0;
        ub = houses[houses.length-1];
        while (Math.abs(ub-lb)>0.01){
            m = lb+(ub-lb)/2;
            if (coverable(houses,numOfAccessPoints,m)== true){
                ub = m;
            }else{
                lb = m+0.001;
            }
        }
        return lb;
    }

    /**
     * for each accesspoint,
     *      add current index + total index
     *      until cannot fit then next
     * return h- houses not serviced == 0
     */
    public static boolean coverable(int[] houses, int numOfAccessPoints, double distance) {
        Arrays.sort(houses);
        double d = distance*2;
        double range = 0;
        int curr = 0;
        for (int i = 1; i<= numOfAccessPoints;i++){
            if (curr<houses.length) {
                range = d + houses[curr];
                while (curr<houses.length){
                    if (houses[curr]<=range){
                        curr++;
                    }else{
                        break;
                    }
                }
            }
        }
        return curr==houses.length;
    }
}
