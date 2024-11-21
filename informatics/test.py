from exfunc import *

# тесты для задания 1
example1 = ["It is my smile ;<{=, but i'm ;<{=",
            ";<{=; <{= It is my smile ;<}=, but i'm ;<{=;<{=",
            "Dima is a good boy;<{=\n;<{=\n;<{=",
            "Your smile is ;<{ = with space",
            "Your smile is wrong (;f<{=)"]

rightans1 = [2,3,3,0,0]


# тесты для задания 2
example2 = ["Довольно распространённая ошибка   ошибка",
            "– это лишний повтор\nповтор слова",
            "повтор повтор\nслова  слова.",
            "smile Smile  park Park" ,
            "Не нужно портить хор хоровод."]

rightans2 = ["Довольно распространённая ошибка",
             "– это лишний повтор\nслова",
             "повтор\nслова.",
             "smile Smile park Park",
             "Не нужно портить хор хоровод."]


# тесты для задания 2
example3 = ["коРмакоРма коРма Крона КОРОНА  КоРма",
            "Крона\nКОРОНА\nкоРма\nкоРма\nкоРмакоРма",
            "RtКоРмаtR RtКоРм   аtR   RtКоРмарtR",
            "RtКоРмаtR\nRtКоРм\nаtR\nRtКоРмарtR",
            "кКАртер пола\nкорат а не карат\n\nкратер вулканра"]

rightans3 = ["коРма, КоРма",
             "коРма, коРма",
             "RtКоРмаtR",
             "RtКоРмаtR",
             "пусто"]



while True:
    print("Какое задание хотите выполнить?")
    n = int(input("№ "))
    ni = int(input("номер теста от 1 до 5 "))

    if n == 1:
        print("Задание " + str(n) + " Test №" + str(ni) + ":\n" + str(example1[ni-1]) + '\n')
        print("Правильный ответ " + str(rightans1[ni-1]) + '\n')
        print("Ответ от регулярок " + str(ex1(example1[ni-1])))

    if n == 2:
        print("Задание " + str(n) + " Test №" + str(ni) + ":\n" + str(example2[ni-1]) + '\n')
        print("Правильный ответ\n" + str(rightans2[ni-1]) + '\n')
        print("Ответ от регулярок\n" + str(ex2(example2[ni-1])))

    if n == 3:
        print("Задание " + str(n) + " Test №" + str(ni) + ":\n" + str(example3[ni-1]) + '\n')
        print("Правильный ответ\n" + str(rightans3[ni-1]) + '\n')
        print("Ответ от регулярок\n" + str(ex3(example3[ni-1])))
    print('\n')
  
