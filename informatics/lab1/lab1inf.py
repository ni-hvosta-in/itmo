import math
def ten_to_mten(n,r):
    A = []
    while abs(n)>0:
        if n%(r) < 0:
            A.append(n%(r)+abs(r))
        else:
            A.append(n%(r))
        n = math.ceil(n/(r))
    return A[::-1]
print(ten_to_mten(100,-7))
