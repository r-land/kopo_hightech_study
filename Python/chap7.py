#!/usr/bin/env python
# coding: utf-8

# In[1]:


def display(): 
 print('hello you') 
display() 
display() 


# In[2]:


def mul(a,b):
    result=a*b
    return result
x,y=input('두수를 입력하시오.').split(',')
result=mul(int(x),int(y))
print('두수 곱의 결과 %d'%result)


# In[3]:


def function(x,y): 
 x=10 
 y=20.0 
 print('함수 : %d %f' %(x,y)) 
x = 5 
y = 10.0 
print('메인함수 : %d %f' %(x,y)) 
function(x,y)
print('메인함수 : %d %f' %(x,y))


# In[4]:


def display(name,job,age): 
 print('Name:',name)
 print('Job:',job)
 print('Age:',age)
display('Kevin','teacher',28) 
display('Kevin',28,'teacher') 


# In[39]:


def display(name,job,age):
    print('Name:'+name)
    print('Job:',job)
    print('Age:',age)
display(name='Kevin',job='teacher',age='28')
display(name='Kevin',age='28',job='teacher')


# In[6]:


def function(x):
    x[0]=10
    print('함수 x:',x)
x=[1,2,3,4,5]
print('메인함수 x:',x)
function(x)
print('메인함수 x:',x)


# In[8]:


def function(x):
 for i in x: 
     print('리스트 데이터 : %d ' %(i))
x = [1,2,3,4,5] 
function(x) 


# In[43]:


import display1 
x=[1,2,3,4,5]
display1.function(x) 
display1.display('Kevin','teacher',28) 


# In[44]:


from display1 import function
x=[1,2,3,4,5]
function(x)


# In[45]:


from display1 import function as fun
x=[1,2,3,4,5]
fun(x)


# In[46]:


import display1 as dp1
x=[1,2,3,4,5]
dp1.function(x)


# In[ ]:




