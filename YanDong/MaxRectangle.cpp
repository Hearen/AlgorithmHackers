class Solution {
public:
	int maximalRectangle(vector<vector<char>>& matrix) {
		if(matrix.size() <=0){
			return 0;
		}
		int maxArea = 0;
		vector<vector<int> > trans = transform(matrix);
		for(int j = 0;j<trans[0].size();++j){
			stack<int> s;
			for(int i=0;i<trans.size();){
				if(s.empty() || trans[i][j]>=trans[s.top()][j]){
					s.push(i++);
				}
				else{
					int t  = s.top();
					s.pop();
					int tmp = trans[t][j] * (s.empty()?i:i - s.top()-1);
					if(tmp > maxArea){
						maxArea = tmp;
					}
				}
			}

		}
		return maxArea;
	}
	vector<vector<int> > transform(vector<vector<char>>& matrix){
		vector<vector<int>> ret;
		for(int i=0;i<matrix.size();++i){
			vector<int> tmp;
			int cnt = 0;
			for(int j=0;j<matrix[i].size();++j){
				if(matrix[i][j]== '1'){
					++cnt;
					tmp.push_back(cnt);
				}
				else{
					cnt = 0;
					tmp.push_back(0);
				}

			}
			ret.push_back(tmp);
		}
		vector<int> tail;
		for(int i=0;i<matrix[0].size();++i){
			tail.push_back(0);

		}
		ret.push_back(tail);
		return ret;
	}
};
