from itertools import permutations
perms = [''.join(p) for p in permutations('0123456789')]
print(perms[999999])