from ApiRequests.BankAPI.Bank import Bank
import requests
import xml.etree.ElementTree as ET

class CBAbank(Bank):
    def GetData(self):
        url='http://www.cba.am/'
        response = requests.get(url)
        response.raise_for_status()
        print(response.content)
        