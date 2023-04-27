#리스트
a=[1,2,3,4]
print(a)
b=['A','B','C','D']
print(b)
c=['A',1,"Hello",True]
print(c)
print('end:)\n')


#리스트 인덱스 활용
a=[1,2,3,4,5,6,7,8,9]
print(a[0:5])
print(a[5:])
print(a[:7])
print(a[:]) 
print(a[-1])
print(a[6:-2]) 
print(a[:-2])
print('end:)\n')

#리스트 메서드 활용
a=['A',1,"Hello",True]
print(a)
a.append(False)
print(a)
a.insert(1,0)
print(a)
del a[2]
print(a)
a.remove(True)
print(a)
print(a.index('Hello'))
print('end:)\n')

#리스트 생성
digit = list(range(1,11))
print(digit)
digit=[i for i in range(1,11)]
print(digit)
print('end:)\n')

#2차원 리스트
a=[[1,2,3],[4,5,6],[7,8,9]]
print(a)
print(a[0])
print(a[2])
print(a[0][0])
print(a[2][2])
print('end:)\n')

#2차원 리스트 for문 활용
a=[[1,2,3],[4,5,6],[7,8,9]]
for i in a:
    for j in i:
        print(j,end='')
    print('')
print('end:)\n')

#튜플
a=(1,2,3,4,5)
print(a) 
b=('A','B','C','D')
print(b)
c=('A',1,"Hello",True)
print(c)
d=(1,)
print(d)
print('end:)\n')

#튜플 인덱스
a=(1,2,3,4,5) 
print(a[0])
print(a[-1])
print(a[:]) 
print(a[0:5])
print(len(a))
#a[0]=10 튜플은 수정이 불가함 에러
print('end:)\n')

#딕셔너리
person={
    'name':'kim',
    'age':18,
    'mobile':'010-1234-5678',
    'mail':'kim@korea.kr'
}

print(person)
guy={}
guy['name']='susan'
guy['age']=20
print(guy)
print('end:)\n')

#딕셔너리 인덱스
person={'name':'kim','age':18,'mobile':'010-1234-5678','mail':'kim@korea.kr'}
print(person)
print(person['name'])
person['age']=24
print(person['age'])
print('end:)\n')

#딕셔너리 메소드
person={'name':'kim','age':18,'mobile':'010-1234-5678','mail':'kim@korea.kr'} 
print(person)
del person['mail']
print(person.keys())
print(person.values())
print(person.items())
print(len(person)) 
print('end:)\n')



