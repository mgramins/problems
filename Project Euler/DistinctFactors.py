def primes(n):
    ls = []
    d = 2
    while d*d <= n:
        while (n % d) == 0:
            ls.append(d)
            n //= d
        d += 1
    if n > 1:
       ls.append(n)
    return set(ls)

i = 647
consec = []
while(len(consec) != 4):
	if(len(primes(i)) == 4):
		consec.append(i)
	else:
		consec = []
	i += 1
print(consec)