import decimal
import math

def f(x):   # наша функция
    return decimal.Decimal(2 * x**2 - x**4 - 1) - decimal.Decimal(math.log(x))


#головная часть программы
a = 0.25    # левая граница отрезка
b = 1.5     # правая граиница отрезка
accuracy = 2*10**-18
midpoint = 0
flag = 0
while (b-a) > accuracy:
    b = round(decimal.Decimal(b),17)
    a = round(decimal.Decimal(a), 17)
    midpoint = round((b + a)/2, 17)
    if f(a)*f(midpoint) < 0:
        b = midpoint
    elif f(a)*f(midpoint) > 0:
        a = midpoint
    elif f(a)*f(midpoint) == 0:
        print("Корень уравнения = ", midpoint)
        f = 1
        break
    print("a = ", a, "b = ", b)
if f == 0:
    print("Корень уравнения = ", midpoint)
