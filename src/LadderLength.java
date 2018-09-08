import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/description/
 * @author bwt
 *
 *	注意点：
 *	所有单词具有相同的长度。
 *
 *	图算法。首先要根据 beginWord + wordList 中的单词生成一个 Map<String, List<String>>，
 *表示一个节点 String 可以到达的目的节点 List<String>，最后从 beginWord 开始记录到达每一个点所需的
 *步数。
 *	代码的效率不高，有待优化
 */
public class LadderLength {

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		HashMap<String, List<String>> graphMap = new HashMap<>();
        String str1, str2;

        wordList.add(beginWord);
        for (int i = 0; i < wordList.size(); i++) {
        	for (int j = i + 1; j < wordList.size(); j++) {
        		str1 = wordList.get(i);
        		str2 = wordList.get(j);
        		if (isConnect(str1, str2))	//如果两个单词连通
        			updateGraph(graphMap, str1, str2);
        	}
        }
        
        if (graphMap.get(endWord) == null)
        	return 0;
        if (graphMap.get(beginWord) == null)
        	return 0;
        
        String str;
        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        map.put(beginWord, 1);
        while (!queue.isEmpty()) {
        	str = queue.poll();
        	
        	for (String string : graphMap.get(str)) {
        		if (map.get(string) == null) {
        			queue.add(string);
        			map.put(string, map.get(str) + 1);
        		}
			}
        	
        	if (queue.contains(endWord))
        		return map.get(endWord);
        }
        
		return map.get(endWord);
    }
	
	/**
	 * 计算两个单词间是否连通，即：是否相差一个字符
	 * @return
	 */
	public static boolean isConnect(String a, String b) {
		int diffNum = 0;
		
		//所有单词具有相同的长度 && 没有重复的单词
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				diffNum++;
			if (diffNum > 1)
				return false;
		}
		return diffNum == 1 ? true : false;
	}
	
	/**
	 * 维护一个 map
	 * @param map
	 * @return
	 */
	public static void updateGraph(
			HashMap<String, List<String>> map, String str1, String str2){
		List<String> list = map.get(str1);
		if (list == null)
			list = new ArrayList<>();
		list.add(str2);
		map.put(str1, list);
		
		list = map.get(str2);
		if (list == null)
			list = new ArrayList<>();
		list.add(str1);
		map.put(str2, list);
	}
	
	public static void main(String[] args) {
		String[] params = new String[] {
			//"hit", "cog"
			//"hot","dot","dog","lot","log","cog"
			"dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"
		};
		
		List<String> wordList = new ArrayList<>();
		for (String string : params) {
			wordList.add(string);
		}
		
		int res = ladderLength("nape", "mild", wordList);
		System.err.println(res);
	}
}
