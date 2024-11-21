import re
from re import findall

def getteg(s):
    A = re.findall(r'<[^<>]*>',s)
    tag = A[0][1:-1]
    if tag[0] == '/':
        tag = tag[1:]
    return tag

def getname(s):
    a = re.findall(r'>.*<',s)[0][1:-1]
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
        s = getteg(a)
        if len(findall(r'<.*>.*</.*>',a)) > 0: # <tag> name </tag>
            n = getname(a)
            if not(n.isdigit()):
                a = a.replace(n,'"' + n + '"')
            a = re.sub(r'</.*>', ",",a)
            a = re.sub(r'<(.*)>',r'"\1":',a)

        if len(findall(r'</.*>',a)) == 0:    # <tag>
            a = re.sub(r'<(.*)>',r'"\1": {',a)

        if len(findall(r'<[^/<>]>',a)) == 0:    # </tag>
            a = re.sub(r'</.*>','},', a)

        if a1 != len(A)-1 and a.count('"') == 4 and len(A[a1+1]) > 2 and A[a1+1].count('</') == 1 and A[a1+1].count('<') == 1:      # ,\n},
            a = a[:-2] + "\n"

        if a1 != len(A)-1 and a.count('},') == 1 and len(A[a1+1]) > 2 and A[a1+1].count('</') == 1 and A[a1+1].count('<') == 1:     # }, }
            a = a[:-2] + "\n"

        if a1 == len(A)-1:   # last }
            a = a[:-1] + "\n"
        fw_json.write(a)
fw_json.write('\n}')
