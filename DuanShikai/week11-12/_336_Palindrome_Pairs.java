package com.sky.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author DuanSky
 * @date 2016年3月16日 下午7:36:01
 * @content 
 */

public class _336_Palindrome_Pairs {
	
	
	public static void main(String args[]){
		_336_Palindrome_Pairs test = new _336_Palindrome_Pairs();
		String s = "abcdefdcba";
		String[] words = {"aihhieeegdebhb","acajjajbbibaab","ddjihhebahcead","cehdaiaeaggai","di","bcacdfjadgfjgiicghc","ddhigcdidggfcejib","djbgdcadgiaaieh","fggfdajadcfhajhag","dfahbdjcbgdf","dfbhhdfjdcfefij","fjgbegdifedgf","ffeice","gdgjcaichica","gigjifehagcacggg","ehjgha","ddj","igffdiddgecidcjfj","cca","heeig","cdghidigcgdaeda","jbbachabahheidacd","feahagifaacejg","abdbgidheigfcabffe","ehcbieidgfagijafd","gcji","f","jddgd","ibachgei","eeabadcbiebdchiaha","baejcdeef","cagbjjhaecgi","ijfcfecdccchee","jhiidcdba","dgdibjihcbbhg","fcibbcbbjhhbiiiaag","fggefjgbjdajcbcgjbj","gg","hhadjfeaa","aghbgcjfcdcihfc","bfffcggfeddeajbhafge","dggfafhafc","dcdbhcifbbbgbcaeh","dacacdhbjd","ghhifd","aabifcjhadibhfdjbga","baejceehiagaabchabff","bjagbabf","hgijgdifccjdehjaccbf","gbfejbfddgcja","iiedgaigdg","eeieg","cei","bchicbfcihbcjejjfg","jhjdfi","ebdgaghfbjhfceh","bdjdgegfdddadiieaici","abeecj","g","jcadaigbcabcggeddjcd","h","ajjg","iebcbgfbjhbfbai","ghj","gidafdigfgfcjfg","hgjacihicbcfifghgcbc","gaaibecj","ifjciedfgdegfi","bfcbdddjfjjhfahbjfaa","fafgijfgahf","gcjacdbgdbecghif","gjdgah","fdbbcbidbhbgf","ghihccifb","ghjeecjgfefd","b","egigbdaicefieddicee","gjg","baae","jeiehgccjefedjib","jjcjgeaajcj","ihjbhbjgejgcheb","accce","jhc","gjj","icaadccfihj","bafefdchbhibibdfggg","egehfbegjedcicdfjfge","fbcdighdcieideh","bjfibbjigc","daidhjjb","aeeec","ed","dgdbjjibccjdafh","bbde","biejhahgd","bjhhdiidcbe","dibceifgj","c","hedi","fjjfihdejifjfba","hd","bffbd","gdjaaaaihgbiahicde","gdehfchcd","icgidjcj","gd","jddfjhcgiefjee","daajiighijhdfbi","bggj","ecgfbahaacfiajc","ggdffajibaidjib","jf","fhicadfghdcchiiifj","aji","gfjacgcfbicgdjad","cfhfcggadigidigihdid","bfcdidiifgfbc","ahiidhjhbfdiahic","edecdcd","cigigjfafdbhbdhhhjf","fbjefgghghcheja","dhcheddfjffeejb","ffcd","ificcdfdb","ghjgafhiffdcgghjja","jgfadaecjgh","fifahiijidjgcdiedee","dccejgdfaggdadfccd","aeghbjdjgifah","gejaehchdfhfdeegie","bafa","aebgccebdfcgc","abdgbcg","dcedgfjbbgc","jbfhaddbbdaiiegjic","jegdijdaebj","ejgajggidiahadgddeab","ece","i","hegjjfbgegijdjgb","aiiee","eefad","cdbeifbfa","afej","hagaadb","egfdib","hfaiididcidfjccf","debf","ddhceh","hjgecgjjihf","fjjfj","gjceffcedjff","aaaghiabbdagbchhg","dgaieejgbfjdhcbcijfa","cacf","cbjbijehadihhjdi","fiabgiiccbba","eagi","edaagghhehgddic","egcaghjcfci","cjbhgfbdfddh","jbjdhghgjjjacgidfbeg","icjihhgeffbhihhdh","caceeibgbihcfidbig","efij","ahjgfdegbig","cieifgigjdbje","iebahhbjjbjiegaca","bjiheaiaacajdjbdbe","gbgbcdge","bdaijhgefjibfhcedc","gjgfbhhdedhb","hedbgdbajfg","eiebdiiedhagad","a","digcdgjejhf","aaiafddgcefj","dhba","d","ag","bbchdccbgjfbjcgfci","afg","cbjgjfffj","ccgifgeccjgc","jhbgb","dfggiifehbf","hfhedbgjdhfghgdja","fagjbdge","cejhjbccgjggihcgeaf","dbhbfebffgaf","cdhdjhcj","hacjbaifjb","gjejjbbbecidahjched","jadfiigjidfgfa","efjggaebaa","heieaihfffj","ejeafadace","jfajijdifijacbhjc","fig","cehegedcdjcijehaeac","dgjeijfae","dcbeddfdb","gdd","ad","eafdbedfdgeiiif","dagihgebabiahhaf","fiifhdbfhhbb","dfc","eajigcfifjjdhdhjadf","egccbbhgddggebehebhc","debahdfadag","fhhcedjachdcjhd","iaaicjbgejjaihcdaab","jggbiee","gigdjccjficebidhjdcj","fa","aehaghjbfibcd","ceiicfbfgccbfjbi","ieheijg","bhcffafei","ahhihfjja","bdiihbciicfbhead","bebihe","dedigbeddahabdfa","dcehfcbhibiihhg","bdbdaifcbediabebhee","ghbgecjcidafbgfad","bfiaafcbdijj","jffeijjijcbeihgbccfj","fafbbjgagjbdd","jcejgd","dffgjfdibfabjgddcb","acdhaebbiiacffgcdj","ifibah","fighebjccg","jehejgdgiddebehfhdba","ffebafcaafcgadfjai","icjcdgachddebbbhj","hcchjbecfigah","cdjfffgafhie","fedaejjeedahhccg","gdedhijcjh","aaccbgifg","dibffhffigaeegfg","ba","hg","efa","acifijeg","cichjibjdhgajcdc","ccejgejcgabafgb","dhfi","cdgdfcfbhaefbdddh","aebdjf","fdghbigifah","jeegcicbfejc","bebehc","dgfgdhg","jjfbifgfj","gejbebejbfhb","ghfhheeaddc","iedah","hfjchb","hjhdfbjfigdbgbgggf","ebfiecdghcfg","eheiicbhiedi","fjaa","ccbeheejcicahhhj","ebbjbd","hafebbhfgdjbde","aibjfcfe","jbbdbjac","ghdaec","gbabhj","e","fcbjgibadfcdbd","afahbhjjbad","adadeiibjgchihgcdfjh","dgadgfji","ecidcfhajhdfcf","dfeeebggedhfidede","cadejafjaajaicd","ibd","dagf","eigfajhfgdcbhi","ce","jdbgiefed","bgffchfeebhejgh","fj","geddhdghcb","jcabjacjhbiejjaehih","gfchcjceadifii","cgjjaai","jicfgjciciihagd","agcheaeahddheje","jaaiehdhfhcbg","ciafhfadeahiedgac","fdecghgehfdigfa","hajffedb","hcjefhfeggbaafgcheh","fdddcdchbhjgfig","aghggjdcbehgccd","ehfdj","gbbgdb","cdgjifidcdiejfga","gbjdi","fegicbfdhbdeicdac","ijfbegfdjcbjcaddbcgg","hihfjdadifh","fdccdcdchdh","ciciaejifbeefcciigb","afcccc","jfci","fccje","fd","ebbgfdi","bdcig","ehbaji","cbdjiffgfagagjbaid","bejhcgdcaeaaibibca","fhigfbfddfbai","cgbadcgdchia","jh","aahjbj","fddfahebabfajafgceb","cbficcbhadchedcidg","iihjdaedbb","bbigheagfee","ffggehgfificifdejga","acidhghj","bbbggfegjh","bfcbhdied","bejadihbdjid","ajhfgjehaaabb","fhgjjedajhb","jejghcjfbgda","ef","jdcahjiahgfejaacc","fjacgcjjfeb","ggefjf","jfejaah","fbgfhefcegcbbihf","igefidejfgdefjeg","beaecfgjcda","dffccaecieicbcgheeeh","hbfaebjdi","eddgcfjhbh","ieheecbefgjhcjficb","ia","iibfefchhdei","fjdcdccaefi","gebcjejihhdjjbf","jgee","fc","gdfaejbfbgeffffibb","iciabibhihfcejdjggba","bcfhfafj","cchgaibghghjifehgdac","gheheg","fddbc","jfebecgifdajh","bjichcbbdhg","eaeaaadc","febhcc","dba","bafchg","cbjbghgfjij","ae","cihijabjhd","abjb","ijiagdeh","cjhdbbgdfh","ffdgagecchicae","iii","iiejcideejjifiia","dcb","cgjc","eeddie","jedbfgdb","bjiadfef","fddjiejeghhafhjefb","ebdfbfdbgdhcdjddigj","hgiffaigdgehfdb","geggc","beiiagf","gfbhjej","jagadabjcgiceija","gghidjhaeficjej","eibggjgccfbhcad","hhijjeaebbg","chddicbchb","iifgcbed","ehcfbjaeahfbbdjgf","idcdaajf","ch","aigigiehdbiehh","egacbfbejh","chhchhdfccagdidhed","bceefjjjhhjdbj","fgjdcigjaabiccfba","bjhddhjjbbiajbchia","fjbicdcgffadhgbdc","gbgba","ajjdffgegahf","cbjfeeja","egfjbfgghjeaeaaeiej","edhgdgjgfiddfjddd","hc","dhaffehdh","abaca","fdfiajaehcddi","ebddcj","dejh","jjfigabh","bgiijbecafcag","dfffjdabhegej","fgjdjdcjhcidjgbhb","adgaca","jbadfgjfd","ggbdbehbdbjbjif","dbibg","ifdgaihcaaif","hfcicghddi","dfgieidbddhcdbcc","cg","ecajej","cegigiaejcbddgef","j","bbddbjebeccgjbbbifeg","dgffdedej","bcffhigji","bacgeah","cehfdaebaagjecfbfjeh","ffdjbfjigfejheacec","bhicaf","feifehchcf","eh","cc","fgebehacgggaafecahbi","jdjdeg","ceiegifagjdig","egjf","ichajgibiijbffhgjd","hehjhhgjecihiaeh","jjbfbjjgdjijhdefhe","ieijjbabdiggbej","jhggbgcbajigebb","bb","ciigfdigbajfjaajghh","eai","eaggcf","jeefebecid","fhaifhfiiighdgdgicf","fcj","iifd","gbgcaefcf","jjddcjfdchcdchce","ee","hiffa","dcfda","ijcfbbfbae","hcbdhhg","aheifdcjdgbccccjgadc","ecjabjjbdefgjbbhj","bfdjjcfbdfdcef","icjfheiee","hecff","hccccjdgeafdjeebabca","gibiafaihd","idbaahbddg","iieigidefdbddjc","bcahbdifgjcfahcdfea","djadjjgaebcg","idjaeegcc","beehcdcb","ehbfdhffaa","djjff","igacfgdbjiedffia","hdgabjaefahhcibiba","bca","eehfjb","iibfigca","gifgcaafddebajaedjdg","ai","ijgbjcjj","ifdjjjfcabhijjgc","hh","ecfijbhfcajbfc","iifcdifc","ehf","hjfedgdbcdcif","ihhedgbedddegebcfi","gc","cfj","eicigiaacghhfgch","fjcdjadd","idihdhjbfgdjeg","fddbdfigfbgchdcaaehc","cgdfef","idicdcbihehdcdi","bceibi","ifehjcfbihjefaabhcc","ieegghfahacidc","adbicied","ghbcdegb","jeijjbbfgcdgjied","geaad","ajjbccgbifcdggafc","accddbbhjcbhe","fbfb","jifgjhaadchj","hgjhdifeiji","gcjaddjjdgchdbcigch","dghgehia","jdiab","fbad","ebgiaabdbdehjce","hahehbifa","heigfcjigjabhaiedb","cjjc","ffhjbhahegji","bihddjfdbhhigcf","djccffcfjfcdbedcj","jcfbhifieihfibgbbe","jdbgiebfgch","hgfgaibcabf","idbaiaeadficihfd","hihjaadeebegcbddi","cdhahbjgjaifideb","ecficjfgc","dehjdf","fffe","ffeghcihcfab","ahdbee","gfccgc","ahbffbiah","ccg","ecicgiddgebfgcdgi","bc","dbhggffhdbjhhab","idjiijfgi","afch","hcghdedadhhchhjafcji","eaigidgj","bbgb","bghibhjaahcebgf","fjjffj","deaaaaeeheaecj","icjjcdijghgcg","chjh","jgcaahhbdjadfgjcg","gfafjdgh","fdggghejhh","hahhjfidghfbcfjgji","ejg","bjachejdcfjc","ibbbcgdbj","hjjhccggidaie","iiaehchic","jgheggigbbfa","afgieeeafaiaiccaag","eejjfbihhiegbbbgfeh","fjdbcaijfjc","igeedcfegceaajbe","aafjhaeahbedcf","agbcbeifeahh","fafjajddaabefcjdcff","aajfahafedejifaga","hbag","ca","bffdfecaebaghccfbdej","id","cdbbihchhebfi","cjaihigib","bfahhjjjabdeeeje","bhcagbgc","ejjfhebejadiidehdcgb","ecigdhfifbjch","jgagf","bhjdaejfbgjc","hbjfiediiajbej","cjgd","acejgdhecef","jhjdbi","ijidbeaaheaiahjcfcd","gjdfjgcechcjc","bfidjacdhegegibhh","egbefbdbicbid","biga","igebachebcjcecge","dbfciciahgfebecb","ffaig","ebcdeaciibfjefb","hcaibiidejh","hbfebahiid","ffgehig","dfcgidibacf","efdjbchgaihf","abjjhfcah","ijjbeibhedhi"};
		System.out.println(test.palindromePairs_1(words));
	}

	//my solution. 
	public List<List<Integer>> palindromePairs_1(String[] words) {
	    List<List<Integer>> res = new LinkedList<>();
	    if (words == null) return res;
	    Map<String,Integer> map = new HashMap<>();
	    for(int i = 0; i < words.length; i ++) map.put(words[i], i);
	    for(int i = 0; i < words.length; i ++){
	    	int l = 0, r = 0; // l 和 r 分别是左边界和右边界，这两个值只有一个为0，不可能同时为0。l为0时，是固定左边部分
	    	while(l <= r){ //需要循环取出所有的情况
	    		String s = words[i].substring(l,r);
	    		Integer j = map.get(new StringBuilder(s).reverse().toString()); //MISTAKE 注意这里需要反转
		    	if(j!=null  && i!=j && isPalindrome(words[i].substring(l == 0 ? r : 0, l == 0 ? words[i].length() : l))) //MISTAKE 注意这里需要考虑i!=j，因为不能自己跟自己组成回文
		    		res.add(Arrays.asList(l == 0 ? new Integer[]{i,j} : new Integer[]{j,i}));
		    	if(r < words[i].length()) r++; //r先加到右边界
		    	else l++; //l在加到左边界
	    	}
	    }
	    return res;
	} 
	
	//beautiful solution. 
	public List<List<Integer>> palindromePairs_(String[] words) {
	    List<List<Integer>> pairs = new LinkedList<>();
	    if (words == null) return pairs;
	    HashMap<String, Integer> map = new HashMap<>();
	    for (int i = 0; i < words.length; ++ i) map.put(words[i], i);
	    for (int i = 0; i < words.length; ++ i) {
	        int l = 0, r = 0;
	        while (l <= r) {
	            String s = words[i].substring(l, r);
	            Integer j = map.get(new StringBuilder(s).reverse().toString());
	            if (j != null && i != j && isPalindrome(words[i].substring(l == 0 ? r : 0, l == 0 ? words[i].length() : l)))
	                pairs.add(Arrays.asList(l == 0 ? new Integer[]{i, j} : new Integer[]{j, i}));
	            if (r < words[i].length()) ++r;
	            else ++l;
	        }
	    }
	    return pairs;
	}
	
	//暴力检测 68ms 未通过
	public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
        	for(int j = i + 1; j < words.length; j++){
        		if(!canMakePalindrome(words[i]+words[j])) continue;
        		if(isPalindrome(words[i]+words[j]))
        			res.add(Arrays.asList(new Integer[]{i,j}));
        		if(isPalindrome(words[j]+words[i]))
        			res.add(Arrays.asList(new Integer[]{j,i}));
        	}
        }
        return res;
    }
	
	//判断一个字符串是否可以构成回文
	private boolean isPalindrome(String s) {
		if(s == null || s.length() < 2) return true;
		int i = 0, j = s.length()-1;
		while(i<j){
			if(s.charAt(i)!=s.charAt(j)) return false;
			i++; j--;
		}
		return true;
	}

	//判断原字符串是否可以通过改变元素顺序构成回文
	public boolean canMakePalindrome(String s){
		if(s==null || s.length()<2) return true;
		Set<Character> set = new HashSet<Character>();
		for(int i = 0; i < s.length(); i++){
			char a = s.charAt(i);
			if(set.contains(a)) set.remove(a);
			else set.add(a);
		}
		return set.size()<=1;
	}

}
