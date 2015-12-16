/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-15 16:30
Description : 
Source      : https://leetcode.com/problems/simplify-path/
*******************************************/

char* simplifyPath(char* path)
{
    int pre = -1, cur = 0;
    int index = 0;
    int size = strlen(path);
    if(size == 0)
        return "";
    if(*(path+size-1) != '/')
    {
        strcat(path, "/");
        size++;
    }
    int unitSize = 0;
    char* unit = (char*)malloc(sizeof(char)*size*2);
    char** sArray = (char**)malloc(sizeof(char*) * size);
    for(; *(path+cur) != '\0'; cur++)
    {
        if(*(path+cur) == '/')
        {
            unitSize = cur - pre - 1;
            strncpy(unit, path+pre+1, unitSize);
            unit[unitSize] = '\0';
            pre = cur;
            if(strcmp(unit, ".") == 0) //stay the same;
                continue;
            if(strcmp(unit, "..") == 0) //pop out;
                index > 0? index-- : (index = 0);
            else
            {
                sArray[index] = (char*)malloc(sizeof(char) * 2 * unitSize);
                strcpy(sArray[index++], unit);
            }
        }
    }
    if(index == 0)
        return "";
    unit[0] = '/';
    unit[1] = '\0';
    unitSize = 0;
    for(int i = 0; i < index; i++)
    {
        unitSize += strlen(sArray[i]) + 1;
        strcat(unit, sArray[i]);
        strcat(unit, "/");
    }
    unit[unitSize] = '\0';
    return unit;
}
