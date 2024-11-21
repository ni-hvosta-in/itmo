import json
import xmltodict
fr_xml = open("lab4input.xml")
dict = xmltodict.parse(fr_xml.read())
json_data = json.dumps(dict)
fw_json = open("lab4.json","w")
fw_json.write(json_data)
