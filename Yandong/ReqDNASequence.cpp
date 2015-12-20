class Solution {
public:
vector<string> findRepeatedDnaSequences(string s) {
		vector<string> ret;
		if(s.size() < 11)
			return ret;
		int encode[26];
		encode['A'-'A'] = 0;
		encode['C'-'A'] = 1;
		encode['G'-'A'] = 2;
		encode['T'-'A'] = 3;
		int hmap[1024*1024];
		memset(hmap,0,sizeof(hmap));
		int tmp = 0;
		for(int i=0;i<10;i++){
			tmp <<= 2;
			tmp |= encode[s[i]-'A'];
		}
		cout<<tmp<<endl;
		hmap[tmp] = 1;
		for(int i=10;i<s.size();i++){
			string stmp = s.substr(i-9,10);
			tmp <<= 2;
			tmp |= encode[s[i]-'A'];
			tmp &= 0xFFFFF;
			cout<<tmp<<endl;
			if(hmap[tmp] == 1){
				ret.push_back(stmp);
				hmap[tmp] = 2;
			}
			else if(hmap[tmp] == 0){
				hmap[tmp] = 1;
			}
		}
		return ret;

	}
};