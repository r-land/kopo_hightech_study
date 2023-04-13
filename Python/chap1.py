import time #time모듈에는 시간에 대한 함수들이 있다
tot = 0 #변수 선언
def display(): #함수 선언
    print('%d'%tot)
for i in range(11):
    tot = tot + i
    print('%d'%i)
    
time.sleep(1) #1초 기다림
display()