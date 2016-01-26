/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-22 16:53
Description : 
Source      : https://leetcode.com/problems/compare-version-numbers/
*******************************************/
int compare(int a, int b)
{
    if(a > b)
        return 1;
    else if(a == b)
        return 0;
    else
        return -1;
}

//AC - 0ms;
int compareVersion(char* v1, char* v2)
{
    while(*v1 != '\0' || *v2 != '\0')
    {
        int version1 = 0;
        int version2 = 0;
        while((*v1 != '.' && *v1 != '\0') || (*v2 != '.' && *v2 != '\0'))
        {
            if(*v1 != '.' && *v1 != '\0')
            {
                version1 = 10*version1 + (*v1 - '0');
                v1++;
            }
            if(*v2 != '.' && *v2 != '\0')
            {
                version2 = 10*version2 + (*v2 - '0');
                v2++;
            }
        }
        int ret = compare(version1, version2);
        if(ret != 0)
            return ret;
        else if(*v1 == '\0' && *v2 == '\0')
            return 0;
        if(*v1 == '.')
            v1++;
        if(*v2 == '.')
            v2++;
    }
}
