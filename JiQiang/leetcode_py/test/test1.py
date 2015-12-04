
li = ['q','w','q','a']

print(li.index('q'))
ll = [i for i,j in enumerate(li) if j == 'q']
print(ll)

for i,value in enumerate(['a','b','c']):
    print( i,value)