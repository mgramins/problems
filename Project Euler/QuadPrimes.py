def isPrime(n):
	if(n < 0): n*= -1
	if n == 1: return False
	if n == 2: return True

	for i in range(2, n):
		if n%i == 0: return False
	return True
def quad(n, a, b): return n**2 + a*n + b

primes=[]
maxSize = 0
n = 0
resA = 0
resB = 0
for a in range(-999, 1000):
	for b in range(-999,1000):
		while isPrime(quad(n,a,b)):
			primes.append(quad(n,a,b))
			n += 1
		if len(primes) > maxSize:
			maxSize = len(primes)
			resA = a
			resB = b
		n = 0
		primes = []
print("n^2 + " + str(resA) + "n + " + str(resB))
print(str(maxSize))

	