#!/usr/bin/env python
# coding: utf-8

# In[7]:


import tensorflow as tf
def add_function(x, y): 
    x = tf.add(x,y)
    return x
x1 = tf.constant([[1.0, 2.0],[3.0, 4.0]])
y1 = tf.constant([[1.0, 2.0],[3.0, 4.0]])
result = add_function(x1, y1).numpy()
print(result)


# In[11]:


import tensorflow as tf
import numpy as np
tensor_0 = tf.constant(7)
print(tensor_0)
print(tensor_0.numpy())


# In[14]:


import tensorflow as tf
import numpy as np
tensor_1 = tf.constant([1.0, 2.0, 3.0, 4.0, 5.0])
print(tensor_1)
print(tensor_1.numpy())


# In[15]:


import tensorflow as tf
import numpy as np
tensor_2 = tf.constant([[10, 20],[30, 40]], dtype=tf.float16)
print(tensor_2)
print(tensor_2.numpy())


# In[16]:


import tensorflow as tf
import numpy as np
tensor_3 = tf.constant([ 
 [[0, 1, 2, 3],
 [4, 5, 6, 7]],
 [[8, 9, 10, 11],
 [12, 13, 14, 15]],
 [[16, 17, 18, 19],
 [20, 21, 22, 23]],])
print(tensor_3)
print(tensor_3.numpy())


# In[17]:


import tensorflow as tf
import numpy as np
tensor_2 = tf.constant([[10, 20],[30, 40]], dtype=tf.float16) 
Array_2 = np.array(tensor_2)
print(Array_2)


# In[22]:


import tensorflow as tf
import numpy as np
a = tf.constant([[1, 2],
 [3, 4]])
b = tf.constant([[1, 2],
 [3, 4]])
print(tf.add(a, b), "\n")
print(tf.add(a, b).numpy())
print('-------------------')
print(tf.multiply(a, b), "\n") 
print(tf.multiply(a, b).numpy()) 
print('------------------')
print(tf.matmul(a, b), "\n")
print(tf.matmul(a, b).numpy())


# In[23]:


import tensorflow as tf
import numpy as np
x = tf.constant([1, 2, 3, 4])
y = tf.constant(2)
print(tf.add(x, y))
print(tf.subtract(x, y))
print(tf.multiply(x, y))
print(tf.divide(x, y))


# In[24]:


import tensorflow as tf
import numpy as np
tensor_int = tf.constant([[1, 2], [3, 4]]) 
tensor_bool = tf.Variable([True, False]) 
tensor_complex = tf.Variable([1 + 2j, 3 + 4j]) 
variable_int = tf.Variable(tensor_int)
variable_bool = tf.Variable(tensor_bool)
variable_complex = tf.Variable(tensor_complex)
print(variable_int)
print(variable_bool)
print(variable_complex)


# In[25]:


import tensorflow as tf
import numpy as np
a = tf.Variable([1.0, 2.0])
b = tf.Variable(a) 
a.assign([3, 4]) 
print(a.numpy())
print(b.numpy())
print(a.assign_add([2,3]).numpy()) 
print(a.assign_sub([7,9]).numpy()) 


# In[31]:


import tensorflow as tf
import timeit
import matplotlib.pyplot as plt
from datetime import datetime
# The actual line
TRUE_W = 4.0
TRUE_B = 1.0
NUM_EXAMPLES = 1000
# A vector of random x values
x = tf.random.normal(shape=[NUM_EXAMPLES]) 
# Generate some noise
noise = tf.random.normal(shape=[NUM_EXAMPLES]) 
# Calculate y
y = x * TRUE_W + TRUE_B + noise 
w = tf.Variable(5.0) 
b = tf.Variable(0.0) 
learning_rate=0.1
Ws, bs = [], []
print("Starting: W=%1.2f b=%1.2f, loss=%2.5f" %
 (w, b, tf.reduce_mean(tf.square(y - (w * x + b)))))
for epoch in range(10): 
 # Update the model with the single giant batch
 with tf.GradientTape() as t:
 # Trainable variables are automatically tracked by GradientTape
     current_loss = tf.reduce_mean(tf.square(y - (w * x + b))) 
 # Use GradientTape to calculate the gradients with respect to W and b
     dw, db = t.gradient(current_loss, [w, b]) 
 # Subtract the gradient scaled by the learning rate
 w.assign_sub(learning_rate * dw) 
 b.assign_sub(learning_rate * db) 
 
 # Track this before I update
 Ws.append(w.numpy())
 bs.append(b.numpy())
           
current_loss = tf.reduce_mean(tf.square(y - (w * x + b)))
print("Epoch %2d: W=%1.2f b=%1.2f, loss=%2.5f" %
 (epoch, Ws[-1], bs[-1], current_loss))
# Visualize how the trained model performs
plt.scatter(x, y, c="b")
plt.scatter(x, w * x + b, c="r")
plt.show()
print("Current loss: %1.6f" % tf.reduce_mean(tf.square(y - (w * x + b))).numpy())


# In[ ]:




