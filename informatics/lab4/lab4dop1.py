import json
import xmltodict
fr_xml = open("lab4input.xml")
dict = xmltodict.parse(fr_xml.read())
json_data = json.dumps(dict, ensure_ascii=False, indent=4)
fw_json = open("lab4dop1.json","w")
fw_json.write(json_data)
