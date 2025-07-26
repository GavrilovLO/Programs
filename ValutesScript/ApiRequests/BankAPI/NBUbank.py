from ApiRequests.BankAPI.Bank import Bank
import requests
import xml.etree.ElementTree as ET


class NBUbank(Bank):
    def GetData(self):
        response = requests.get("https://cbu.uz/ru/arkhiv-kursov-valyut/xml/")
        root = ET.fromstring(response.content)
        for valute in root.findall('CcyNtry'):
            for cur in self.required_currencies:
                if valute.find('Ccy').text == cur:
                    char_code = valute.find('Ccy').text
                    rate = valute.find('Rate').text
                    print(f"Валюта: {char_code},Курс:{rate}")
                    self.SendingData(source_currencies_id = 7, char = char_code, rate = rate)
                
        