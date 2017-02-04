import matplotlib.pyplot as plt
import time

file = open("out.shell.txt", "r")
inp = file.read()
inp = inp.split('=')
for i in range(len(inp)):
	inp[i] = eval('[' + inp[i] + ']')
for item in inp:
	fig = plt.figure()
	pc = plt.pcolor(item)
	plt.title('Simple histogramm')
	plt.grid(True)

	plt.show()
	#time.sleep(1000)