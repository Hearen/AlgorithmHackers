/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2015-12-15 16:30
Description : 
Source      : https://leetcode.com/problems/simplify-path/
*******************************************/

char* simplifyPath(char* path)
{
    int pre = 0, cur = 0;
    int index = 0;
    int size = strlen(path);
    if(size == 0)
        return "";
    //make sure the last character is a forward slash;
    if(*(path+size-1) != '/')
    {
        /*strcat(path, "/");//the space spared for path should be enough for another character - but in this case, it's not reliable;*/
        char* tmp = (char*)malloc(sizeof(char)*(size+2));
        strcpy(tmp, path);
        strcat(tmp, "/");
        path = tmp;
        size++;
    }
    //make sure the pre and cur point to the first forward slash;
    while(*(path+cur) != '/')
    {
        pre++;
        cur++;
    }
    int unitSize = 0;
    char* unit = (char*)malloc(sizeof(char)*(size+1));
    char** sArray = (char**)malloc(sizeof(char*) * size);
    for(; *(path+cur) != '\0'; cur++)
    {
        if(*(path+cur) == '/')
        {
            unitSize = cur - pre - 1;
            if(unitSize < 0)//pre and cur point to the same position;
                continue;
            strncpy(unit, path+pre+1, unitSize);//cur - pre > 0 is ensured;
            unit[unitSize] = '\0';
            pre = cur;
            if(strcmp(unit, ".") == 0 || strcmp(unit, "") == 0) //stay the same;
                continue;
            if(strcmp(unit, "..") == 0) //pop out;
            {
                if(index > 0)
                    index--;
            }
            else
            {
                sArray[index] = (char*)malloc(sizeof(char) * (unitSize+1));
                strcpy(sArray[index++], unit);
            }
        }
    }
    //collecting the directories;
    unit[0] = '/';
    unit[1] = '\0';
    unitSize = 0;
    for(int i = 0; i < index; i++)
    {
        unitSize += strlen(sArray[i]) + 1;
        strcat(unit, sArray[i]);
        strcat(unit, "/");
    }
    if(index > 0) //overwriting the last forward slash if it's not root;
        unit[unitSize] = '\0';
    return unit;
}
