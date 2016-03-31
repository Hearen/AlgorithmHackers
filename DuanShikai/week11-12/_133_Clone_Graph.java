package com.sky.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DuanSky
 * @date 2016年3月18日 下午9:15:20
 * @content 
 */

public class _133_Clone_Graph {
	
	public static void main(String args[]){
		_133_Clone_Graph test = new _133_Clone_Graph();
		UndirectedGraphNode node  = new UndirectedGraphNode(0);
		node.neighbors.add(node);
		node.neighbors.add(node);
		test.cloneGraph(node);
	}
	
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
        if(node == null) return null; //MISTAKE 注意需要考虑为空的情况
		return core(node,new HashMap<Integer,UndirectedGraphNode>());
	}
	
	public UndirectedGraphNode core(UndirectedGraphNode node, Map<Integer,UndirectedGraphNode> map){
		if(map.containsKey(node.label)) return map.get(node.label); //如果之前新建的这样的一个对象，则直接返回这个对象
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		map.put(copy.label, copy);
		List<UndirectedGraphNode> neighbors = node.neighbors;
		for(UndirectedGraphNode neighbor : neighbors){
			copy.neighbors.add(core(neighbor,map));
		}  
		return copy;
	}
	
	//====================================================================================
	public UndirectedGraphNode cloneGraph_wrong_answer(UndirectedGraphNode node) {
        if(node == null) return null;
		List<UndirectedGraphNode> neighbors = node.neighbors;
		List<UndirectedGraphNode> copy = new ArrayList<UndirectedGraphNode>();
		for(UndirectedGraphNode neighbor : neighbors){
			copy.add(cloneGraph_wrong_answer(neighbor)); //MISTAKE 当出现环路的时候，会陷入死循环。
		}
		UndirectedGraphNode root = new UndirectedGraphNode(node.label);
		root.neighbors = copy;
		return root;
    }

}

class UndirectedGraphNode {
	 int label;
	 List<UndirectedGraphNode> neighbors;
	 UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
