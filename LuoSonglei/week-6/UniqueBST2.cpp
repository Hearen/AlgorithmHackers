/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-09 10:46
Description : 
Source      : https://leetcode.com/problems/unique-binary-search-trees-ii/
*******************************************/
struct TreeNode
{
    int val;
    TreeNode *left, *right;
    TreeNode(int x): val(x), left(NULL), right(NULL){}
};

//AC - 24ms;
class Solution
{
    public:
        vector<TreeNode*> generateTrees(int n)
        {
            if(n==0)
            {
                vector<TreeNode*> v;
                return v;
            }
            return generateTrees(1, n);
        }

    private:
        vector<TreeNode*> generateTrees(int begin, int end)
        {
            vector<TreeNode*> v;
            if(begin > end)
            {
                v.push_back(NULL);
                return v;
            }
            if(begin == end)
            {
                TreeNode* t = new TreeNode(begin);
                v.push_back(t);
                return v;
            }
            for(int i = begin; i<=end; i++)
            {
                vector<TreeNode*> lVector = generateTrees(begin, i-1);
                vector<TreeNode*> rVector = generateTrees(i+1, end);
                for(int j=0; j!=lVector.size(); j++)
                    for(int k=0; k!=rVector.size(); k++)
                    {
                        TreeNode* root = new TreeNode(i);
                        root->left = lVector[j];
                        root->right = rVector[k];
                        v.push_back(root);
                    }
            }
            return v;
        }
};
