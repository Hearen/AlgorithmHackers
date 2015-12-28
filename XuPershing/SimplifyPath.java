public class SimplifyPath {
	/**
	 * @param path
	 * @return
	 * @author xpxstar@gmail.com
	 * @2015年12月14日
	 * Given an absolute path for a file (Unix-style), simplify it。
	 * For example,
	 * path = "/home/", => "/home"
	 * path = "/a/./b/../../c/", => "/c"
	 * click to show corner cases.
	 * Corner Cases:
	 * Did you consider the case where path = "/../"?
	 * In this case, you should return "/".
	 * Another corner case is the path might contain multiple slashes '/' together,
	 *  such as "/home//foo/".
	 *  In this case, you should ignore redundant slashes and return "/home/foo".
	 */
	String[] strs = {"/.../","/a/b/c/../d/./e../","/../...","/.../","a","../","/","/../..","///./"};
	public String simplifyPathAbort(String path) {
		if (path.length()<1) {
			return "/";
		}
		int top = 0;
		char[] s = new char[path.length()+1];	
		char tmp;
		int start = 1;
		int dot = 0;//last number of dots in s
		for(int i = 0;i < path.length();i++){
			switch (path.charAt(i)) {
			case '/':
				tmp = s[top];
				if (dot == 1) {
					top--;
					dot = 0;
				}else if(dot == 2) {
					top--;
					dot = 0;
					while('/' != s[top--]){
						if (top == 0) {
							s[++top] = '/';
							break;
						}
					}
					while(top !=0 &&'/' != s[top]){
						top--;
					}
				}else if(tmp == '/') {
				}else {
					s[++top] = '/';
				}
				break;
			case '.':
				tmp = s[top];
				s[++top] = '.';
				dot++;
				break;
			default:
				dot = 0;
				s[++top] = path.charAt(i);
				break;
			}
			
		}
		while (dot <3&&top>=0&& s[top] == '.'){
			top--;
		}
		if (top != 1 &&s[top] == '/') {
			top--;
		}
		if (s[1] != '/') {
			s[0] = '/';
			start = 0;
		}
		return String.valueOf(s).substring(start, top+1);
    }
	public String simplifyPath(String path){
		/*思路：首先判断s为空和长度为0的情况
		 * 反斜杠是分界符，以之划分段，判断段内符号，如果是.或者..或者空，特殊处理，否则添加到新的字符串数组中。
		 */
		if (null==path || path.length() == 0) {
			return "/";
		}
		String[] parts = path.split("/");
		int top = -1;
		String[] stack = new String[parts.length];
		for (String part : parts) {
			if (part.equals(".")) {
			}else if (part.equals("..")) {
				top = top>-1? top-1:top;
			}else if (part.equals("")) {
			}else {
				stack[++top] = part;
			}
		}
		if (top ==-1) {
			return "/";
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0;i<=top;i++) {
			sb.append("/");
			sb.append(stack[i]);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		SimplifyPath sp = new SimplifyPath();
		for (String s : sp.strs) {
			System.out.println(sp.simplifyPath(s));
		}
	}
}
