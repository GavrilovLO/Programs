from ApiRequests.BankAPI.Bank import Bank
import requests
import xml.etree.ElementTree as ET

class KZbank(Bank):
    def GetData(self):
        url='https://nationalbank.kz/rss/rates_all.xml'
        response = requests.get(url)
        response.raise_for_status()
        if response.status_code == 200:
            root = ET.fromstring(response.content)
            for valute in root.findall('.//item'):
                for cur in self.required_currencies:
                    if valute.find('title').text == cur:
                        char_code = valute.find('title').text
                        rate = valute.find('description').text
                        print(f"Валюта: {char_code}, Курс:{rate}")
                        self.SendingData(source_currencies_id = 3, char = char_code, rate = rate)