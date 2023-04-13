print("hello")
print("hi")
print("hello?",end=" ")
print("hi")
print("hello?", "hi")
print("hello?", "hi", sep='/')

print("\tHELLO? \n\\Nice to meet you\\")

print("name %s, age %d"%('susan',25))
print("10진수=%d,8진수=%o,16진수=%x"%(10,10,10))
print("정수형=%d,실수형=%f,지수형=%e" %(10,12.5,0.00001))


print("|%d|\n" %1234)
print("|%10d|\n" %1234)
print("|%-10d|\n" %1234)
print("|%+10d|\n" %1234)
print("|%010d|\n" %1234)
print("|%10.5f|\n" %1234.56)
print("|%10.2f|\n" %1234.56)
print("|%10.1f|\n" %1234.56)
print("|%10.5f|\n" %12340.56)
print("|%10s|\n" %'ABCD')
print("|%-10s|\n" %'ABCD')

a=input('정수를 입력:')
print('입력값은 %s' %a)

a=eval(input('정수를 입력:'))
print('입력값은 %d' %a)

a,b=input('a,b를 입력하시오:').split()
print("a=%d,b=%d"%(eval(a),eval(b)))

a=1
print("a=",a,"id(a)=",id(a))

i=10
j=10.5
print("i=%s,j=%s"%(type(i),type(j)))

a='A'
print('a=%c, a=%d, a=%s'%(a,ord(a),type(a)))

a="HELLO"
print('a=%s, a=%s'%(a,type(a)))

a=True
print('a=%s, a=%s' %(a,type(a)))

# 지역변수 전역변수
def result():
    answer=100
    print('answer=',answer)
answer=0
print('answer=',answer)
result()
print('answer=',answer)


def result():
    global answer
    answer =100
answer=0
print('answer=',answer)
result()
print('answer=',answer)

# 객체, id메소드(주소값) type메소드(자료형)
print('7=%s, 7.7=%s, hello=%s' %(type(7),type(7.7),type('hello'))) 
i=7
j=7.7
k='hello'
print('i(id)=%s, j(id)=%s, k(id)=%s' %(id(i),id(j),id(k))) 
print('i=%s, j=%s, k=%s' %(type(i),type(j),type(k))) 


#객체 점표기법, title메소드(첫글자대문자)
k='hello'
print('k=%s'%(k.title()))

#format 메소드(출력형식,인덱스)
print('Hello {0} How old? {1}'.format('Tom',29))

print('Hello {0:5s} How old? {1:5d}'.format('Tom',29))

print('|{:10d}|'.format(1234)) 
print('|{:<10d}|'.format(1234)) 
print('|{:010d}|'.format(1234))  
print('|{:10.5f}|'.format(1234.56)) 
print('|{:10.2f}|'.format(1234.56)) 
print('|{:10.1f}|'.format(1234.56)) 
print('|{:10s}|'.format('ABCD'))  
print('|{:>10s}|'.format('ABCD'))

# upper메소드(대문자) lower메소드(소문자)

k='hello'
print('k=%s' %(k.upper()))

print('HELLO'.lower())

# str메소드(숫자>문자변환) int메소드(문자>숫자변환) float메소드(문자>실수)
print("I am " + str(20) + " years old")

print('%d, type=%s'%(int('1234'),type(int('1234')))) 
print('%d, type=%s'%(int('1234.7'),type(int('1234.7')))) 

print('%f, type=%s'%(float('1234.7'),type(float('1234.7')))) 
print('%f, type=%s'%(float(1234),type(float(1234)))) 

# strip메소드(공백제거) split메소드(공백출력)
passwd = ' python ' 
print('|%s|'%passwd) 
print('|%s|'%passwd.strip()) 
passwd=passwd.strip() 
print('|%s|'%passwd)

language = 'python C Java C#'
print('%s'%language.split())
language='python,C,Java,C#'
print('%s'%language.split(','))

