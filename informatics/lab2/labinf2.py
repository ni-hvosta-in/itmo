def obr(n):
    if n == "0":
        return "1"
    else:
        return "0"

s = str(input())

A = ["r1", "r2", "i1", "r3", "i2", "i3", "i4"]

print(*A)

print(*list(s), sep='  ')

print()

r1 = s[0]
r2 = s[1]
i1 = s[2]
r3 = s[3]
i2 = s[4]
i3 = s[5]
i4 = s[6]

s1 = (r1 + i1 + i2 + i4).count('1') % 2
s2 = (r2 + i1 + i3 + i4).count('1') % 2
s3 = (r3 + i2 + i3 + i4).count('1') % 2

print("s1 =", s1)
print("s2 =", s2)
print("s3 =", s3)

print()

ans = (str(s1) + str(s2) + str(s3))
print(ans)
ans = ans[::-1]

ans = int(ans, 2)
print("=>")
if ans == 0:
    print("Ошибок нет")
else:
    print("Ошибка в ", A[ans - 1])
    print("Правильный код", s[:ans-1] + obr(s[ans-1]) + s[ans:])
