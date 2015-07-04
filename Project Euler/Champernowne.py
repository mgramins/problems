s = "0"
i = 1
while True:
	s += str(i)
	i += 1
	if len(s) > 1000000:
		break
print(int(s[1]) * int(s[10]) * int(s[100]) * int(s[1000]) * 
	int(s[10000]) * int(s[100000]) * int(s[1000000]))