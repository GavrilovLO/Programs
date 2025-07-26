from ApiRequests.BankAPI.Bank import Bank
import requests
import xml.etree.ElementTree as ET

class NBKRbank(Bank):
    def GetData(self):
        urls=['https://www.nbkr.kg/XML/weekly.xml','https://www.nbkr.kg/XML/daily.xml']
        for url in urls:
            response = requests.get(url)
            response.raise_for_status()
            root = ET.fromstring(response.text)
            for valute in root.findall('Currency'):
                    for cur in self.required_currencies:
                        if valute.attrib['ISOCode'] == cur:
                            char_code = valute.attrib['ISOCode']
                            nominal = valute.find('Nominal').text
                            value = valute.find('Value').text
                            print(f"Валюта: {char_code}, Номинал: {nominal}, Курс: {value}")
                            self.SendingData(source_currencies_id = 4, char = char_code, rate = value)