import random

file = open('data.txt', 'w')

data = ''

for i in range(30):
    x = int(random.random() * 1000)
    data += str(x) + ' '


file.write(data)
    
file.close()
