package com.xingkong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author cuiguangfan 736068048@qq.com:
 * @version create time：2016年3月16日 下午10:21:42 class description
 */
public class N_133_Clone_Graph {
	private static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};
	
	/**
	 * 利用map保持引用的特点来做的，没生成一个新节点，都在map存放，每次有相同label的节点，都必须从map取出，这样，保持了引用
	 * @param node
	 * @return
	 */
	public UndirectedGraphNode cloneGraph_0(UndirectedGraphNode node) {//20ms 1.7%
        if(node==null) return null;
		Set<Integer> labelSet=new HashSet<Integer>();
		Queue<UndirectedGraphNode> queue=new LinkedList<UndirectedGraphNode>();
		queue.add(node);
		Map<Integer,UndirectedGraphNode> map=new HashMap<Integer,UndirectedGraphNode>();
		map.put(node.label, new UndirectedGraphNode(node.label));
		while(!queue.isEmpty()){
			UndirectedGraphNode tempNode=queue.poll();
			labelSet.add(tempNode.label);
			List<UndirectedGraphNode> resultList=new ArrayList<UndirectedGraphNode>();
			List<UndirectedGraphNode> tempList=tempNode.neighbors;
			if(tempList!=null){
				for(UndirectedGraphNode temp:tempList){
					if(!labelSet.contains(temp.label)){
						queue.add(temp);
						
					}
					if(!map.containsKey(temp.label)) map.put(temp.label, new UndirectedGraphNode(temp.label));
					resultList.add(map.get(temp.label));
				}
				//if(!map.containsKey(tempNode.label)) map.put(tempNode.label, new UndirectedGraphNode(tempNode.label));
				map.get(tempNode.label).neighbors=resultList;
			}
		}
		return map.get(node.label);
    }
	public UndirectedGraphNode cloneGraph_1(UndirectedGraphNode node) {// 10ms  31.35%  去掉了set，因为set和map的作用是相同的
		if(node==null) return null;
		Queue<UndirectedGraphNode> queue=new LinkedList<UndirectedGraphNode>();
		queue.add(node);
		Map<Integer,UndirectedGraphNode> map=new HashMap<Integer,UndirectedGraphNode>();
		map.put(node.label, new UndirectedGraphNode(node.label));
		while(!queue.isEmpty()){
			UndirectedGraphNode tempNode=queue.poll();
			List<UndirectedGraphNode> resultList=new ArrayList<UndirectedGraphNode>();
			List<UndirectedGraphNode> tempList=tempNode.neighbors;
			if(tempList!=null){
				for(UndirectedGraphNode temp:tempList){
					if(!map.containsKey(temp.label)){
						queue.add(temp);
						map.put(temp.label, new UndirectedGraphNode(temp.label));
					}
					resultList.add(map.get(temp.label));
				}
				map.get(tempNode.label).neighbors=resultList;
			}
		}
		return map.get(node.label);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N_133_Clone_Graph n=new N_133_Clone_Graph();
		UndirectedGraphNode node=new UndirectedGraphNode(-1);
		System.out.println(n.cloneGraph_1(node));
	}

}
