#!/usr/bin/env python
# coding: utf-8

# In[4]:


import numpy as np
x=np.array([1,1])
w=np.array([0.5,0.5])
res=np.sum(w*x)
print('AND(1,1)=',0 if res < 1 else 1)


# In[6]:


import tensorflow as tf

input_data = tf.constant([[0,0],[0,1],[1,0],[1,1]])
expected_output = tf.constant([[0],[0],[0],[1]])
model = tf.keras.Sequential([tf.keras.layers.Dense(units=1,input_shape=(2,), activation='sigmoid')])
model.compile(loss='binary_crossentropy', optimizer='adam')
model.fit(input_data, expected_output,epochs=5000, verbose=0)
predicted_output = model.predict(input_data)
print(predicted_output)


# In[7]:


weights = model.get_weights()
for i, weight in enumerate(weights):
    print(f"Weight {i}: {weight}")


# In[ ]:


m

