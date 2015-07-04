from math import sqrt
def divisors(n):
	divs = []
	for i in range(2, 1+int(sqrt(n))):
		if n%i == 0:
			divs.append(i)
			divs.append(int(n/i))
	return divs

abundant = lambda n: sum(divisors(n)) > n

nums = [i for i in range(1,21823) if abundant(i)]
sums = list(set([i+j for i in nums for j in nums if i+j <= 28123]))
ans = 0
print('arrived')
for i in range(1,28123):
	if i not in sums:
		ans += i

print(ans)
