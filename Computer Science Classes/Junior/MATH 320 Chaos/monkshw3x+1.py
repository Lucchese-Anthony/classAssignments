import time

n = 1
x = n
list = [n]
start = time.time()
while n != 501:
    x = n
    list = [n]
    while x != 2.0 and x != 1.0:
        if x % 2 == 0:
            x = x / 2
            list.append(x)

        else:
            x = ((3 * (x)) + 1) / 2
            list.append(x)
        
    with open("3x+1-Output.txt", "a") as o:
        o.write(str(list))
        o.write("\n")
    
    n = n + 1
end = time.time()
print(end-start)
