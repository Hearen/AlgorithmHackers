
li = ['q','w','q','a']

print(li.index('q'))
ll = [i for i,j in enumerate(li) if j == 'q']
print(ll)

for i,value in enumerate(['a','b','c']):
    print( i,value)\


k = 4
print(--k)
print(k)

ii = [i for i in range(0,9,3)]

board = ["123","233"]
print(board)
sss = set([1,2,3])
sss.add(5)
sss.remove(1)
print(sss)

stack = [ i for i in range(9,0,-1)]
stack.pop()
print(stack)

print(ord('A'))
print(ord('T'))
print(ord('C'))
print(ord('G'))
s = "12334"
print(s[1:4])