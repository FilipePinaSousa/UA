lst = [1, 2, 3, 4, 5, 6, 1, 2, 3]

count = 0
x = int(len(lst)/2)
for y in range(0, x):
    for i in range(-1, -x, -1):
        if lst[y] == lst[i]:
            count += 1

print(count)
