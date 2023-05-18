#!/usr/bin/env python
# coding: utf-8

# In[4]:


import numpy as np
from sklearn.datasets import make_regression
from sklearn.linear_model import LinearRegression
import matplotlib.pyplot as plt
X, Y, w = make_regression(
 n_samples=5000, n_features=1, bias=300, noise=10, coef=True, random_state=10
)
print(w)
x = np.linspace(start=np.min(X), stop=np.max(X), num=100)
x = x.reshape(len(x), 1)
model = LinearRegression().fit(X, Y)
y=model.predict(x)
print('절편:',model.intercept_,'기울기', model.coef_)
print('선형회귀식 : y=', model.coef_,'* x +',model.intercept_)
plt.scatter(X, Y, label="date")
plt.plot(x, y, 'rs-', label="linear regression model")
plt.xlabel("x")
plt.ylabel("y")
plt.title("linear regression")
plt.legend()
plt.show()


# In[13]:


import numpy as np
from sklearn.datasets import make_blobs
from sklearn.preprocessing import StandardScaler
from sklearn.neighbors import KNeighborsClassifier
X, Y = make_blobs(n_samples=1500 ,n_features=2, centers=3, random_state=170) 
print(X)
print(Y)
X = StandardScaler().fit_transform(X) 
print(X)
classifier = KNeighborsClassifier(n_neighbors=3) 
X_test=np.array([[-2,-2],[0,2],[2,2]])
print(X_test)
classifier.fit(X, Y)
Y_pred = classifier.predict(X_test) 
print('category=',Y_pred) 
plt.figure(figsize=(8, 5))
plt.title('KNN')
plt.scatter(X[Y == 0, 0], X[Y == 0, 1], s=5, label="0 class") 
plt.scatter(X[Y == 1, 0], X[Y == 1, 1], s=5, label="1 class")
plt.scatter(X[Y == 2, 0], X[Y == 2, 1], s=5, label="2 class")
plt.scatter(X_test[:,0],X_test[:,1], s=15,c=Y_pred) 
plt.xlim(-2.5, 2.5)
plt.ylim(-2.5, 2.5)
plt.legend()
plt.show()


# In[14]:


from sklearn.linear_model import Perceptron
x=[[1,1],[1,0],[0,1],[0,0]] 
y=[1,1,1,0] 
p=Perceptron() 
p.fit(x,y) 
print("OR 데이터 인식결과: ",p.predict(x)) 


# In[17]:


from sklearn.linear_model import Perceptron
x=[[1,1],[1,0],[0,1],[0,0]] 
y=[1,0,0,0] 
p=Perceptron() 
p.fit(x,y) 
print("AND 데이터 인식결과: ",p.predict(x)) 


# In[18]:


from sklearn.linear_model import Perceptron
x=[[1,1],[1,0],[0,1],[0,0]] 
y=[0,1,1,0] 
p=Perceptron() 
p.fit(x,y) 
print("XOR 데이터 인식결과: ",p.predict(x)) 
#단층퍼셉트론 xor 구현 불가


# In[20]:


#다층퍼셉트론 xor 구현도 완벽하지 않음
import tensorflow as tf
import numpy as np

# XOR 입력과 출력 정의
x = np.array([[0, 0], [0, 1], [1, 0], [1, 1]])
y = np.array([[0], [1], [1], [0]])

# 모델 구성
model = tf.keras.Sequential([
    tf.keras.layers.Dense(2, activation='sigmoid', input_shape=(2,)),
    tf.keras.layers.Dense(1, activation='sigmoid')
])

# 모델 컴파일
model.compile(optimizer='adam', loss='binary_crossentropy', metrics=['accuracy'])

# 모델 학습
model.fit(x, y, epochs=1000)

# 예측
predictions = model.predict(x)
print(predictions)


# In[26]:


import numpy as np
from sklearn import datasets
from sklearn.preprocessing import StandardScaler
from sklearn.linear_model import Perceptron
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score
iris = datasets.load_iris() 
X = iris.data 
Y = iris.target 
print(X[:10])
print(Y[:10])
print(X[140:])
print(Y[140:])
X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size=0.3)
X_train = StandardScaler().fit_transform(X_train) 
X_test = StandardScaler().fit_transform(X_test) 
model = Perceptron(max_iter=350, eta0=0.1) 
model.fit(X_train, Y_train) 
y_pred = model.predict(X_test) 
print('인식율:', (accuracy_score(Y_test, y_pred)*100),'%')


# In[30]:


Iris_Data.head()


# In[29]:


from sklearn.datasets import load_iris
import pandas as pd
import numpy as np
 
Iris = load_iris()
 
Iris_Data = pd.DataFrame(data= np.c_[Iris['data'], Iris['target']], columns= Iris['feature_names'] + ['target'])
Iris_Data['target'] = Iris_Data['target'].map({0: "setosa", 1: "versicolor", 2: "virginica"})
 
X_Data = Iris_Data.iloc[:,:-1]
Y_Data = Iris_Data.iloc[:,[-1]]


# In[ ]:




