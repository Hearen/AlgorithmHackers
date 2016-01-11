/*自顶向下 用递归会超时*/
int numTrees(int n) {
    if(n == 0) return 1;
    if(n == 1)return 1;
    if(n == 2)return 2;
    int sum = 0;
    for(int i = 1;i<=n;i++){
        sum += numTrees(i-1) * numTrees(n-i);
    }
    return sum;
}
/*递归会存在大量的重复计算，可以用数组存储下来
自底向上 AC
*/
int numTrees(int n) {
    if(n == 0) return 1;
    if(n == 1)return 1;
    int store[1000];
    store[0] = 1;
    store[1] = 1;
    for(int i = 2;i<=n;i++){
        store[i] = 0;
        for(int j=1;j<=i;j++){
            store[i] += store[j-1] * store[i-j];
        }
    }
    return store[n];
}
