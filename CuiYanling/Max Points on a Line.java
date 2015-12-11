/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        int linep = 0;
        for(int i=0;i<points.length;i++){
            Map<Double,Integer> intercep = new HashMap<Double,Integer>();
            int repet = 1,count = 0,parel = 0;
            for(int j=i+1;j<points.length;j++){
                if(points[j].x==points[i].x&&points[j].y==points[i].y){
                    repet++;
                    continue;
                }
                if(points[j].y==points[i].y){
                	parel++;continue;
                }
                double xie = 0.0;
                if(points[i].x==points[j].x)
                    xie = Integer.MAX_VALUE;
                else xie = (points[i].y-points[j].y+0.0)/(points[i].x-points[j].x);
                if(intercep.containsKey(xie))
                    intercep.put(xie,intercep.get(xie)+1);
                else intercep.put(xie,1);
            }
            for(Integer c:intercep.values())
                count = Math.max(count,c);
            linep = Math.max(linep,count+repet);
            linep = Math.max(linep, parel+repet);
        }
        return linep;
    }
}
