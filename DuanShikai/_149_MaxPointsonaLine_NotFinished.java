/**
 * ����˼·�����⡣������Ҫ��ԭ���ĵ����½��л��֡�
* @author DuanSky
* @date 2015��12��7�� ����11:23:37
* @content 
*/
package com.sky.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _149_MaxPointsonaLine {
	
		
	public static void main(String args[]){
		//Point[] points={new Point(-4,-4),new Point(-8,-582),new Point(-3,3),new Point(-9,-651),new Point(9,591)};
		Point[] points={new Point(0,0),new Point(0,0),new Point(0,0)};
		System.out.println(maxPoints_wrong_solution_1(points));
		
	}
	
	//暴力解法
	public static int maxPoints_wrong_solution_1(Point[] points){
		if(points.length<=2) return points.length;
		int result=0;
		for(int i=0;i<points.length;i++){
			int counter=1; //这是第一个点
			for(int j=i+1;j<points.length;j++){
				if(points[j].x==points[i].x && points[j].y==points[i].y){//如果这两个点重合
					counter++; //如果下一个点跟第一个点相同，则计数器+1，同时继续往下找，直到跟第一个点不同的点
					continue;
				}
				counter++; //现在又找到了一个点，而且这个点和第一个点不是同一个点,这是第二个点
				//根据这两个不是同一个点的点，可以计算斜率
				int dx=points[j].x-points[i].x;
				int dy=points[j].y-points[i].y;
				int gdc=gdc(dy,dx);
				dx/=gdc;dy/=gdc;
				//现在开始找第三个点
				for(int k=j+1;k<points.length;k++){ //现在开始验证第三个点是否和第一个及第二个共线
					if((points[k].x==points[i].x && points[k].y==points[i].y) //同样如果第三个点和第一个或者第二个是同一个点，则自动跳过。
							||(points[k].x==points[j].x && points[k].y==points[j].y)){
						counter++;continue;
					}
					//现在找到的第三个点和第一个以及第二个点都不相同，则计算斜率
					int ddx=points[k].x-points[j].x;
					int ddy=points[k].y-points[j].y;
					int dgdc=gdc(ddy,ddx);
					ddx/=dgdc;ddy/=dgdc;
					
					if(ddx==dx && ddy==dy){ //如果第三个点和第一个以及第二个共线，则将第三个点加进来
						counter++;
					}
				}
				//此时，由前两个点确定的直线已经遍历结束。下次将重新找第二个点。因此先将计数器恢复。
				if(counter>result){
					result=counter;
				}
				counter=1;
			}
			if(counter>result){
				result=counter;
			}
		}
		return result;
	}
	
	public static int gdc(int a,int b){
		if(b==0)
			return a;
		else
			return gdc(b,a%b);
	}
	
	//��һ�η���֮�󣬺����ķ��鶼����֮ǰ�ķ����Ͻ��еģ�Ȼ�����ܵ�һ�η���ͷִ������õ��Ľⲻ�����Ž⡣
    public static int maxPoints_wrong_solution(Point[] points) {
        if(points.length<=2) return points.length;
        List<List<Point>> lines=new ArrayList<List<Point>>();
        for(int i=0;i<points.length;i++){
        	//�жϵ�ǰ�ĵ��Ƿ���Լ��뵽lines��
        	if(lines==null || lines.size()==0){ //�����ǰ����Ϊ��
    	        List<Point> line=new ArrayList<Point>();
    	        line.add(points[i]);
    	        lines.add(line);
        	}
        	else{
        		boolean addIn=false;
            	for(List<Point> line : lines){ //��ǰ���ϲ�Ϊ�գ����ҵ�����ʵĵط����Ҽ��뵽�ô�
            		if(line.size()==1){//��ǰ����ֻ��һ���㣬��Ȼ���Լ��뵽�ü���֮��
            			line.add(points[i]);
            			addIn=true;
            			break;
            		}
            		else if(line.size()>1){//��ǰ�����ж����
            			Point p1=line.get(0);
            			Point p2=line.get(1);//����õ���p2��p1��һ�������δ���?
            			//TODO pay attention!
            			for(int j=2;i<line.size();i++){
            				p2=line.get(i);
            				if(p1.x!=p2.x || p1.y!=p2.y)
            					break;
            			}
            			if(p1.x==p2.x){ //б��Ϊ�����ʱ
            				if((p1.y==p2.y)||p1.x==points[i].x){ //����ʱ�򽫸õ���뵽�ü�����
            					line.add(points[i]);
            					addIn=true;
            					break;
            				}
            			}
            			else{//��б�ʲ�Ϊ�����ʱ
            				if((p1.y-p2.y)*(points[i].x-p2.x)==(points[i].y-p2.y)*(p1.x-p2.x)){//����ʱ�򽫸õ���뵽�ü�����
            					line.add(points[i]);
            					addIn=true;
            					break;
            				}
            			}
            		}
            	}
            	if(addIn==false){//���û���ҵ����ߵļ��ϣ����¿�һ�����ϣ����ҽ��õ���뵽�ü���֮��
            		List<Point> line=new ArrayList<Point>();
            		line.add(points[i]);
            		lines.add(line);
            	}
        	}
        }
        int max=0;
        for(List<Point> line : lines){
        	if(line.size()>max)
        		max=line.size();
        }
        return max;
    }
}
