def gettag(s):
    i = s.find('<')
    if i != -1:
        a = ""
        for k in range(1, len(s)):
            if s[i + k] == '>':
                break
            if k == 1 and s[i+k] == '/':
                continue
            else:
                a += s[k + i]
        return a
    else:
        return ""

def getname(s):
    i = s.find('>')
    a = ""
    for k in range(1, len(s)):
        if s[i + k] == '<':
            break
        else:
            a += s[k + i]
    return a.strip()

fr_xml = open('lab4input.xml')
fr2_xml = open('lab4input2.xml',"w")
fw_json = open('lab4.json', "w")
A = fr_xml.readlines()

for i in A:
    if i != '\n':
        fr2_xml.write(i)

fr2_xml = open('lab4input2.xml')
A = fr2_xml.readlines()

for a1 in range(len(A)):
    a = A[a1]
    if a.count("<?xml version") != 0:
        a = "{\n"
        fw_json.write(a)
    else:
        s = gettag(a)
        if a.count("</" + s + ">") + a.count("<" + s + ">") == 2:   # <tag> name <tag>
            n = getname(a)
            if not(n.isdigit()):
                a = a.replace(n,'"' + n + '"')
            a = a.replace("</" + s + ">", ",")
            a = a.replace("<" + s + ">", '"' + s + '":')

        if a.count("</" + s + ">") == 0:    # <tag>
            a = a.replace("<", '"')
            a = a.replace(">", '": {')

        if a.count("<" + s + ">") == 0:    # </tag>
            a = a.replace("</" + s + ">", '},')

        if a1 != len(A)-1 and a.count('"') == 4 and len(A[a1+1]) > 2 and A[a1+1].count('</') == 1 and A[a1+1].count('<') == 1:
            print(a, A[a1+1] )
            a = a[:-2] + "\n"

        if a1 != len(A)-1 and a.count('},') == 1 and len(A[a1+1]) > 2 and A[a1+1].count('</') == 1 and A[a1+1].count('<') == 1:
            a = a[:-2] + "\n"

        if a1 == len(A)-1:
            a = a[:-1] + "\n"
        fw_json.write(a)
fw_json.write('\n}')
