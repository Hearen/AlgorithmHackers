import java.util.Arrays;

public class MaxPointInline {
	Point points[] = {new Point(1, 1),new Point(1, 1),new Point(1, 1),new Point(2, 2)};
//			new Point(1, 2),new Point(0, 3),new Point(-1, 4)};
	class Point{
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}

	/**
	 * @param points
	 * @return
	 * @author xpxstar@gmail.com
	 * @2015年12月9日
	 * Given n points on a 2D plane, 
	 * find the maximum number of points that lie on the same straight line.
	 * 给定二维的n个点，判断最多有多少个点在同一条直线上
	 */
	public int maxPoints(Point[] points){
		/*思路：遍历所有点
		 * 对于某点，找其他点与该点的斜率，相同即在同一直线，找到相同数最多的。
		 */
		if(points.length<3){
			return points.length;
		}
		Float ratio[] = new Float[points.length];
		int maxNum = 1;
		for (int i = 0 ;i < points.length; i++) {
			int equal = 0;
			for (int j = 0; j < points.length;j++) {
				if ((points[i].x ==  points[j].x) &&(points[i].y ==  points[j].y)) {
					equal++;
				}
				ratio[j] = getRatio(points[i], points[j]);
			}
			int tmpNum = getDuplicate(ratio,equal);
			maxNum = tmpNum>maxNum?tmpNum:maxNum;
		}
		return maxNum;
	}
	private Float getRatio(Point p1,Point p2){
		if(p2.x==p1.x) return Float.NaN;
		return ((float) (p2.y-p1.y)/(float)(p2.x-p1.x));
	}
	private int getDuplicate(Float ratio[],int equal){
		int tmpnum = 0;
		Arrays.sort(ratio);
		for (int i = 0 ;i<ratio.length-1; i++) {
			int j = i+1;
			while (j<ratio.length && ratio[i].equals(ratio[j])) {
				j++;
			}
			if (ratio[i].isNaN()) {
				j-=equal;
			}
			tmpnum = tmpnum>(j-i)?tmpnum:j-i;
		}
		return tmpnum+equal;
	}
	public static void main(String[] args) {
		MaxPointInline  mp = new MaxPointInline();
//		System.out.println(mp.lengthOfLongestSubstring(mp.ss));
		
		System.out.println(mp.maxPoints(mp.points));
	}
}
