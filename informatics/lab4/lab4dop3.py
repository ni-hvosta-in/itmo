import json
import re
from tkinter.constants import FIRST


def prepare(s):
    s = s.replace("\n", "")
    s = s.replace("\t", "")
    while "> " in s or "< " in s:
        s = s.replace("> ", ">").replace(" <", "<")
    return s

def parse(s):

    if s[0] not in [">", "<"]:
            return s
    i = 0
    out = []

    while i < len(s):
        if s[i] == "<" and s[i+1] != "/":
            for n1 in range(i,len(s)):
                if s[n1] == ">":
                    tag = s[i+1:n1]
                    break
            for n2 in range(i+len(tag)+2, len(s)):
                if s[n2:n2+3+len(tag)] == "</" + tag + ">":
                    text = s[i+len(tag)+2:n2]
                    out.append({tag: parse(text)})
                    i = n2+2+len(tag)
                    break
        i += 1
    return out

fw = open("fw.json",'w')
ftest = open("test.xml")
A = ftest.read()
A = prepare(A)
A = parse(A)
print(A)
json_data = json.dumps(A, ensure_ascii=False, indent=4)
fw.write(json_data)
