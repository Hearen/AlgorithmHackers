package com.sky.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author DuanSky
 * @date 2016年3月9日 下午4:26:58
 * @content 
 * 
 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
["aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba"]
 * 
 * "fohhemkkaecojceoaejkkoedkofhmohkcjmkggcmnami"
["kfomka","hecagbngambii","anobmnikj","c","nnkmfelneemfgcl","ah","bgomgohl","lcbjbg","ebjfoiddndih","hjknoamjbfhckb","eioldlijmmla","nbekmcnakif","fgahmihodolmhbi","gnjfe","hk","b","jbfgm","ecojceoaejkkoed","cemodhmbcmgl","j","gdcnjj","kolaijoicbc","liibjjcini","lmbenj","eklingemgdjncaa","m","hkh","fblb","fk","nnfkfanaga","eldjml","iejn","gbmjfdooeeko","jafogijka","ngnfggojmhclkjd","bfagnfclg","imkeobcdidiifbm","ogeo","gicjog","cjnibenelm","ogoloc","edciifkaff","kbeeg","nebn","jdd","aeojhclmdn","dilbhl","dkk","bgmck","ohgkefkadonafg","labem","fheoglj","gkcanacfjfhogjc","eglkcddd","lelelihakeh","hhjijfiodfi","enehbibnhfjd","gkm","ggj","ag","hhhjogk","lllicdhihn","goakjjnk","lhbn","fhheedadamlnedh","bin","cl","ggjljjjf","fdcdaobhlhgj","nijlf","i","gaemagobjfc","dg","g","jhlelodgeekj","hcimohlni","fdoiohikhacgb","k","doiaigclm","bdfaoncbhfkdbjd","f","jaikbciac","cjgadmfoodmba","molokllh","gfkngeebnggo","lahd","n","ehfngoc","lejfcee","kofhmoh","cgda","de","kljnicikjeh","edomdbibhif","jehdkgmmofihdi","hifcjkloebel","gcghgbemjege","kobhhefbbb","aaikgaolhllhlm","akg","kmmikgkhnn","dnamfhaf","mjhj","ifadcgmgjaa","acnjehgkflgkd","bjj","maihjn","ojakklhl","ign","jhd","kndkhbebgh","amljjfeahcdlfdg","fnboolobch","gcclgcoaojc","kfokbbkllmcd","fec","dljma","noa","cfjie","fohhemkka","bfaldajf","nbk","kmbnjoalnhki","ccieabbnlhbjmj","nmacelialookal","hdlefnbmgklo","bfbblofk","doohocnadd","klmed","e","hkkcmbljlojkghm","jjiadlgf","ogadjhambjikce","bglghjndlk","gackokkbhj","oofohdogb","leiolllnjj","edekdnibja","gjhglilocif","ccfnfjalchc","gl","ihee","cfgccdmecem","mdmcdgjelhgk","laboglchdhbk","ajmiim","cebhalkngloae","hgohednmkahdi","ddiecjnkmgbbei","ajaengmcdlbk","kgg","ndchkjdn","heklaamafiomea","ehg","imelcifnhkae","hcgadilb","elndjcodnhcc","nkjd","gjnfkogkjeobo","eolega","lm","jddfkfbbbhia","cddmfeckheeo","bfnmaalmjdb","fbcg","ko","mojfj","kk","bbljjnnikdhg","l","calbc","mkekn","ejlhdk","hkebdiebecf","emhelbbda","mlba","ckjmih","odfacclfl","lgfjjbgookmnoe","begnkogf","gakojeblk","bfflcmdko","cfdclljcg","ho","fo","acmi","oemknmffgcio","mlkhk","kfhkndmdojhidg","ckfcibmnikn","dgoecamdliaeeoa","ocealkbbec","kbmmihb","ncikad","hi","nccjbnldneijc","hgiccigeehmdl","dlfmjhmioa","kmff","gfhkd","okiamg","ekdbamm","fc","neg","cfmo","ccgahikbbl","khhoc","elbg","cbghbacjbfm","jkagbmfgemjfg","ijceidhhajmja","imibemhdg","ja","idkfd","ndogdkjjkf","fhic","ooajkki","fdnjhh","ba","jdlnidngkfffbmi","jddjfnnjoidcnm","kghljjikbacd","idllbbn","d","mgkajbnjedeiee","fbllleanknmoomb","lom","kofjmmjm","mcdlbglonin","gcnboanh","fggii","fdkbmic","bbiln","cdjcjhonjgiagkb","kooenbeoongcle","cecnlfbaanckdkj","fejlmog","fanekdneoaammb","maojbcegdamn","bcmanmjdeabdo","amloj","adgoej","jh","fhf","cogdljlgek","o","joeiajlioggj","oncal","lbgg","elainnbffk","hbdi","femcanllndoh","ke","hmib","nagfahhljh","ibifdlfeechcbal","knec","oegfcghlgalcnno","abiefmjldmln","mlfglgni","jkofhjeb","ifjbneblfldjel","nahhcimkjhjgb","cdgkbn","nnklfbeecgedie","gmllmjbodhgllc","hogollongjo","fmoinacebll","fkngbganmh","jgdblmhlmfij","fkkdjknahamcfb","aieakdokibj","hddlcdiailhd","iajhmg","jenocgo","embdib","dghbmljjogka","bahcggjgmlf","fb","jldkcfom","mfi","kdkke","odhbl","jin","kcjmkggcmnami","kofig","bid","ohnohi","fcbojdgoaoa","dj","ifkbmbod","dhdedohlghk","nmkeakohicfdjf","ahbifnnoaldgbj","egldeibiinoac","iehfhjjjmil","bmeimi","ombngooicknel","lfdkngobmik","ifjcjkfnmgjcnmi","fmf","aoeaa","an","ffgddcjblehhggo","hijfdcchdilcl","hacbaamkhblnkk","najefebghcbkjfl","hcnnlogjfmmjcma","njgcogemlnohl","ihejh","ej","ofn","ggcklj","omah","hg","obk","giig","cklna","lihaiollfnem","ionlnlhjckf","cfdlijnmgjoebl","dloehimen","acggkacahfhkdne","iecd","gn","odgbnalk","ahfhcd","dghlag","bchfe","dldblmnbifnmlo","cffhbijal","dbddifnojfibha","mhh","cjjol","fed","bhcnf","ciiibbedklnnk","ikniooicmm","ejf","ammeennkcdgbjco","jmhmd","cek","bjbhcmda","kfjmhbf","chjmmnea","ifccifn","naedmco","iohchafbega","kjejfhbco","anlhhhhg"]
 */

public class _139_Word_Break {
	
	public static void main(String args[]){
		_139_Word_Break test = new _139_Word_Break();
		String s = "aaaaaaa";
		Set<String> wordDict = new HashSet<>(Arrays.asList(new String[]{"aa","aaaa"}));
		System.out.println(test.wordBreak_4(s, wordDict));
	}

	//14ms MISTAKE 注意哪些地方需要 i+1 哪些地方需要取等。 
	public boolean wordBreak_4(String s,Set<String> wordDict){
		if(s == null || s.length()==0 || wordDict == null || wordDict.size()==0) return false;
		boolean[] d = new boolean[s.length()+1]; d[0] = true;
		for(int i = 0; i < s.length(); i ++){
			for(int j = -1; j < i; j ++){ //j是s[0,1,2...i]中的一个切分点..
				String t = s.substring(j+1,i+1);
				if(d[j+1] && wordDict.contains(t)){
					d[i+1] = true;
					wordDict.add(s.substring(0,i+1)); //增加了这一行 可以提速到7ms
					break;
				}
			}
		}
		return d[s.length()];
	}
	
	//神作，不知道啥意思
	Map<Integer, Boolean> isBreakable = new HashMap<>(); 
    public boolean wordBreak_3(String s, Set<String> wordDict) {
        if (s.equals("")) {
            return true;
        }
        for (int i=1; i<=s.length(); ++i) {
            if (wordDict.contains(s.substring(0, i))) {
                Boolean result = isBreakable.get(i);
                if (result == null) {
                    result = wordBreak_3(s.substring(i), wordDict);
                    isBreakable.put(i, result);
                }
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }
	
	public boolean wordBreak_2(String s,Set<String> wordDict){
		if(s==null || s.length()==0 || wordDict==null || wordDict.size()==0) return false;
        boolean r = divide_2(s,wordDict,new HashMap<String,Boolean>());
        return r;
	}
	
	private Set<Integer> wordLength(Set<String> wordDict){
		Set<Integer> set = new HashSet<>();
		for(String word : wordDict)
			set.add(word.length());
		return set;
	}
	
	//从左往右截断 
	private boolean divide_2(String s, Set<String> wordDict,Map<String,Boolean> map) {
		if(map.containsKey(s)) return map.get(s);
		if(wordDict.contains(s)) return true;
		for(int i = 1; i < s.length(); i ++){
			if( wordDict.contains(s.substring(0,i))){
				boolean curr = divide_2(s.substring(i),wordDict,map);
				if(curr){
					map.put(s.substring(i), true);
					return true;
				}
				else
					map.put(s.substring(i), false);
			}
		}
		return false;
	}

	//Solution Time Limit Exceeded !!!
	public boolean wordBreak_1(String s, Set<String> wordDict) {
        if(s==null || s.length()==0 || wordDict==null || wordDict.size()==0) return false;
        Set<String> wordDelete = new HashSet<String>();
        boolean r = divide_1(s,wordDict,wordDelete);
        return r;
    }
	
	public boolean divide_1(String s,Set<String> wordDict,Set<String> wordDelete){
		if(wordDelete.contains(s)) return false;
		if(wordDict.contains(s)) return true; //如果该字符串直接就存在，则返回true.
		for(int i = 1; i < s.length(); i ++){
			//将原来的字符串切分成两半，分别验证左右两半是否可以由词典构成
			String ls = s.substring(0,i);
			String rs = s.substring(i,s.length());
			boolean lb = false, rb = false;
			if(wordDict.contains(ls)) lb = true; //如果左半部分可以构成单词。
			else lb = wordDelete.contains(ls) ? false : divide_1(ls,wordDict,wordDelete); //如果左半部分不能构成单词，则继续往下切分
			if(!lb) {//如果左半部分没有找到，则记录下来，重新分割。
				wordDelete.add(ls);
				continue;
			}
			if(wordDict.contains(rs)) rb = true;
			else rb =wordDelete.contains(rs) ? false : divide_1(rs,wordDict,wordDelete);
			if(!rb){
				wordDelete.add(ls);
				continue;
			}
			wordDict.add(s);
			return true;
		}
		wordDelete.add(s);
		return false;
	}
}
