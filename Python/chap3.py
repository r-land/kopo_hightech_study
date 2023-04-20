#비교연산자
num=10
print('%s'%(num>0))
print('%s'%(num<0))
print('%s'%(num==0))
print('%s'%(num!=0))

#비교연산자
num=10
if num > 0:
 print("양수입니다.")

#논리연산자 (순서대로진행)
print('숫자입력!')
num=int(input())
if num%2==0 and num%100==0 or num%200==0:
    print('2의 배수이면서 100의 배수이거나 200의 배수')
else:
    print('해당없음')

#선택 제어문
print('숫자입력!')
num=int(input())
if num > 0:
    print("양수입니다.")
else:
    print("음수입니다.")
    
#중첩if문
num=90
if num >= 90:
    print("A")
else:
    if num >=80:
        print("B")
    else:
        if num >=70:
            print("C")
        else:
            print("F")
            
#다중 if-elif-else문
num=90
if num >= 90:
    print("A")
elif num>=80:
    print("B")
elif num>=70:
    print("C")
else:
    print("F")
    
    
#선택제어문
print('숫자입력!')
num = int(input())
print('%s'%('짝수'if num%2==0 else '홀수'))

#연습문제1
print("정수 세개를 입력하시오")
x,y,z = input().split(',')
large = int(x)
if large<int(y):
    large=int(y)
if large<int(z):
    large=int(z)
print("제일 큰수는 %d입니다."%large)

#연습문제2
print("성적 입력해주세요")
num = int(input())
if num >= 90:
    print("A")
elif num>=80:
    print("B")
elif num>=70:
    print("C")
elif num>=60:
    print("D")
else:
    print("F")
    
#연습문제3
print("윤년일까요?")
num=int(input())
if num%4==0 and num%100!=0 or num%400==0:
    print("윤년입니다")
else:
    print("윤년아니야")
    
#연습문제4
result=0
print('사칙연산 입력! 숫자,연산자,숫자  (,) 구분!')
num1,op,num2=input().split(',')
num1=int(num1)
num2=int(num2)
if op == '+':
 result=num1+num2
elif op == '-':
 result=num1-num2
elif op == '*':
 result=num1*num2
elif op == '/':
 result=num1/num2
else: 
 print("다시 입력하세요.")
print('%d %c %d = %d' %(num1,op,num2,result))

#연습문제5
print("이달은 영어로 무엇일까요?")
num = int(input())
if num == 1:
    print("Jan")
elif num == 2:
    print("Feb")
elif num == 3:
    print("Mar")
elif num == 4:
    print("Apr")
elif num == 5:
    print("May")
elif num == 6:
    print("Jun")
elif num == 7:
    print("Jul")
elif num == 8:
    print("Aus")
elif num == 9:
    print("Sep")
elif num == 10:
    print("Oct")
elif num == 11:
    print("Nov")
else:
    print("Dec")


print("이달은 영어로 무엇일까요?")    
month=['jan','feb','mar','apr','may','jun','jul','aug','sep','oct','nov','dec']
i=int(input('1-12사이 숫자 입력!'))
print('%s' %month[i-1])