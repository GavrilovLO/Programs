from ApiRequests.BankAPI.Bank import Bank
import requests


class NBRBbank(Bank):

    def GetData(self):
        urls = ["https://api.nbrb.by/exrates/rates?periodicity=0","https://api.nbrb.by/exrates/rates?periodicity=1"]
        for url in urls:
            response = requests.get(url)
            if response.status_code == 200:
                data = response.json()
                for item in data:
                    for cur in self.required_currencies:
                        if item.get('Cur_Abbreviation') == cur:
                            self.SendingData(source_currencies_id = 2, char=item.get('Cur_Abbreviation'), rate = item.get('Cur_OfficialRate'))
            else:
                print(f"Ошибка при запросе: {response.status_code}")

