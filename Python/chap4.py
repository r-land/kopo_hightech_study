#for문 in range(초기값,최종값,증감): 최종값이 반복문 정지조건
for i in range(1,5):
    print("%d" %i)
    
tot=0
pro=1
for i in range(1,11):
    tot=tot+i
    pro=pro*i    
print("tot=%d,pro=%d"%(tot,pro))

for i in range(3):
    print('8-5의 답은? 기회는3번')
    ans=int(input('8-5='))
    if(ans==3):
        print("정답")
        break
    else:
        print("오답 다시~")
        
#중첩for문
i_tot=0
j_tot=0
for i in range(1,6): 
 print('i=%d' %(i))
 i_tot=i_tot+1 
 for j in range(1,5): 
    print('j=%d' %(j),end='') 
    j_tot=j_tot+1
 print(end='\n')
print('i_tot=%d j_tot=%d' %(i_tot,j_tot)) 

#중첩for문 구구단
tot=0
pro=1
for i in range(1,10): 
 for j in range(1,10): 
    print('%d * %d = %d' %(i,j,i*j),end='') 
 print(end='\n') 