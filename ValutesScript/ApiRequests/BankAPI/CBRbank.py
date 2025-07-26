from ApiRequests.BankAPI.Bank import Bank
import requests
import xml.etree.ElementTree as ET

class CBRbank(Bank):

    def GetData(self):
        url = 'http://www.cbr.ru/scripts/XML_daily.asp?date_req=14/07/2025'
        response = requests.get(url)
        if response.status_code == 200:
            root = ET.fromstring(response.content)
            for valute in root.findall('Valute'):
                for cur in self.required_currencies:
                    if valute.find('CharCode').text == cur:
                        char_code = valute.find('CharCode').text
                        nominal = valute.find('Nominal').text
                        value = valute.find('Value').text
                        VunitRate = valute.find('VunitRate').text
                        print(f"Валюта: {char_code}, Номинал: {nominal}, Курс: {value},VunitRate: {VunitRate}")
                        self.SendingData(source_currencies_id = 5,char = char_code, rate = VunitRate)
        else:
            print(f"Ошибка при запросе: {response.status_code}")