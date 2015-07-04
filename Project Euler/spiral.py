from math import sqrt

def right(x,y):
    return x+1, y

def down(x,y):
    return x,y-1

def left(x,y):
    return x-1,y

def up(x,y):
    return x,y+1

moves = [right, up, left, down]

def gen_points(end):
    from itertools import cycle
    _moves = cycle(moves)
    n = 1
    pos = 500,500
    times_to_move = 1

    yield n,pos

    while True:
        for _ in range(2):
            move = next(_moves)
            for _ in range(times_to_move):
                if n >= end:
                    return
                pos = move(*pos)
                n+=1
                yield n,pos

        times_to_move+=1

def toSqMat(li):
	m = [[0 for i in range(0, int(sqrt(len(li))))] for j in range(0,int(sqrt(len(li))))]
	for elem in li:
		m[elem[1][1]][elem[1][0]] = elem[0]
	return m

m = toSqMat(list(gen_points(1002001)))

l = len(m[0])
diag1 = ([m[i][i] for i in range(l)])
diag2 = ([m[l-1-i][i] for i in range(l-1,-1,-1)])
diag2.remove(1)

print(sum(diag1) + sum(diag2))