from ApiRequests.BankAPI.Bank import Bank
import requests
import xml.etree.ElementTree as ET

class NBTbank(Bank):

    def GetData(self):
        url='https://nbt.tj/ru/kurs/export_xml.php?date=2025-07-14&export=xmlout'
        response = requests.get(url)
        response.raise_for_status()
        root = ET.fromstring(response.text)
        for valute in root.findall('Valute'):
                for cur in self.required_currencies:
                    if valute.find('CharCode').text == cur:
                        char_code = valute.find('CharCode').text
                        nominal = valute.find('Nominal').text
                        value = valute.find('Value').text
                        print(f"Валюта: {char_code}, Номинал: {nominal}, Курс: {value}")
                        self.SendingData(source_currencies_id = 6, char = char_code, rate = value)
        