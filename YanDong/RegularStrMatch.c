
bool isMatch(const char *s, const char *p) {
    if(*p == 0){
        return *s == 0;
    }
    if(*(p+1) != '*'){
        return (*p == *s || (*p == '.' && *s !=0)) && isMatch(s+1,p+1);
    }else{
        while(*s == *p || (*p == '.' && *s !=0)){
            //match no keyword
            if(isMatch(s,p+2)) return true;
            s++;
        }
        //no preceding letter match
        return isMatch(s,p+2);
    }

}
