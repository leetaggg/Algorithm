N = int(input())
    
strings = [input() for i in range(N)]
for i in strings:
    if 'S' in i:
        print(i)