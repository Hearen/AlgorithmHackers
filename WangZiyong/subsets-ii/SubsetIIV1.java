package leetcode.java.Subsets.II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set S of n distinct integers, there is a relation between Sn and Sn-1.
 * 
 * The subset of Sn-1 is the union of {subset of Sn-1} and {each element in Sn-1 + one more element}.
 * 
 * Therefore, a Java solution can be quickly formalized.
 * 
 * Runtime: 4 ms
 * 
 * @author wziyong
 *
 */
public class SubsetIIV1
{
	public List<List<Integer>> subsetsWithDup(int[] num)
	{
		if (num == null)
			return null;

		Arrays.sort(num);

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();

		for (int i = num.length - 1; i >= 0; i--)
		{

			// get existing sets
			if (i == num.length - 1 || num[i] != num[i + 1] || prev.size() == 0)
			{
				prev = new ArrayList<ArrayList<Integer>>();
				for (int j = 0; j < result.size(); j++)
				{
					prev.add(new ArrayList<Integer>(result.get(j)));
				}
			}

			// add current number to each element of the set
			for (ArrayList<Integer> temp : prev)
			{
				temp.add(0, num[i]);
			}

			// add each single number as a set, only if current element is different with previous
			if (i == num.length - 1 || num[i] != num[i + 1])
			{
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(num[i]);
				prev.add(temp);
			}

			// add all set created in this iteration
			for (ArrayList<Integer> temp : prev)
			{
				result.add(new ArrayList<Integer>(temp));
			}
		}

		// add empty set
		result.add(new ArrayList<Integer>());

		return result;
	}
}
