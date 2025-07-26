import requests
import xml.etree.ElementTree as ET
from datetime import datetime

class Bank:
    required_currencies = ["AMD","BYN","KZT","KGS","TJS","UZS","RUB"]
    token = None
    valutes=[{"char":"AMD","id":1},
             {"char":"BYN","id":2},
             {"char":"KZT","id":3},
             {"char":"KGS","id":4},
             {"char":"RUB","id":5},
             {"char":"TJS","id":6},
             {"char":"UZS","id":7}]
    
    exchange_rates = [{"exchange_rates_id":9, "source_currencies_id":1, "target_currencies_id":1},
                      {"exchange_rates_id":10, "source_currencies_id":1, "target_currencies_id":2},
                      {"exchange_rates_id":11, "source_currencies_id":1, "target_currencies_id":3},
                      {"exchange_rates_id":12, "source_currencies_id":1, "target_currencies_id":4},
                      {"exchange_rates_id":13, "source_currencies_id":1, "target_currencies_id":5},
                      {"exchange_rates_id":14, "source_currencies_id":1, "target_currencies_id":6},
                      {"exchange_rates_id":15, "source_currencies_id":1, "target_currencies_id":7},
                      
                      {"exchange_rates_id":16, "source_currencies_id":2, "target_currencies_id":1},
                      {"exchange_rates_id":17, "source_currencies_id":2, "target_currencies_id":2},
                      {"exchange_rates_id":18, "source_currencies_id":2, "target_currencies_id":3},
                      {"exchange_rates_id":19, "source_currencies_id":2, "target_currencies_id":4},
                      {"exchange_rates_id":20, "source_currencies_id":2, "target_currencies_id":5},
                      {"exchange_rates_id":21, "source_currencies_id":2, "target_currencies_id":6},
                      {"exchange_rates_id":22, "source_currencies_id":2, "target_currencies_id":7},
                      
                      {"exchange_rates_id":23, "source_currencies_id":3, "target_currencies_id":1},
                      {"exchange_rates_id":24, "source_currencies_id":3, "target_currencies_id":2},
                      {"exchange_rates_id":25, "source_currencies_id":3, "target_currencies_id":3},
                      {"exchange_rates_id":26, "source_currencies_id":3, "target_currencies_id":4},
                      {"exchange_rates_id":27, "source_currencies_id":3, "target_currencies_id":5},
                      {"exchange_rates_id":28, "source_currencies_id":3, "target_currencies_id":6},
                      {"exchange_rates_id":29, "source_currencies_id":3, "target_currencies_id":7},

                      {"exchange_rates_id":30, "source_currencies_id":4, "target_currencies_id":1},
                      {"exchange_rates_id":31, "source_currencies_id":4, "target_currencies_id":2},
                      {"exchange_rates_id":32, "source_currencies_id":4, "target_currencies_id":3},
                      {"exchange_rates_id":33, "source_currencies_id":4, "target_currencies_id":4},
                      {"exchange_rates_id":34, "source_currencies_id":4, "target_currencies_id":5},
                      {"exchange_rates_id":35, "source_currencies_id":4, "target_currencies_id":6},
                      {"exchange_rates_id":36, "source_currencies_id":4, "target_currencies_id":7},

                      {"exchange_rates_id":37, "source_currencies_id":5, "target_currencies_id":1},
                      {"exchange_rates_id":38, "source_currencies_id":5, "target_currencies_id":2},
                      {"exchange_rates_id":39, "source_currencies_id":5, "target_currencies_id":3},
                      {"exchange_rates_id":40, "source_currencies_id":5, "target_currencies_id":4},
                      {"exchange_rates_id":41, "source_currencies_id":5, "target_currencies_id":5},
                      {"exchange_rates_id":42, "source_currencies_id":5, "target_currencies_id":6},
                      {"exchange_rates_id":43, "source_currencies_id":5, "target_currencies_id":7}, 
                      
                      {"exchange_rates_id":44, "source_currencies_id":6, "target_currencies_id":1},
                      {"exchange_rates_id":45, "source_currencies_id":6, "target_currencies_id":2},
                      {"exchange_rates_id":46, "source_currencies_id":6, "target_currencies_id":3},
                      {"exchange_rates_id":47, "source_currencies_id":6, "target_currencies_id":4},
                      {"exchange_rates_id":48, "source_currencies_id":6, "target_currencies_id":5},
                      {"exchange_rates_id":49, "source_currencies_id":6, "target_currencies_id":6},
                      {"exchange_rates_id":50, "source_currencies_id":6, "target_currencies_id":7},
                      
                      {"exchange_rates_id":51, "source_currencies_id":7, "target_currencies_id":1},
                      {"exchange_rates_id":52, "source_currencies_id":7, "target_currencies_id":2},
                      {"exchange_rates_id":53, "source_currencies_id":7, "target_currencies_id":3},
                      {"exchange_rates_id":54, "source_currencies_id":7, "target_currencies_id":4},
                      {"exchange_rates_id":55, "source_currencies_id":7, "target_currencies_id":5},
                      {"exchange_rates_id":56, "source_currencies_id":7, "target_currencies_id":6},
                      {"exchange_rates_id":57, "source_currencies_id":7, "target_currencies_id":7}
                      ]
    

    def GetToken(self):
        url = "https://fam.cisgeo.info/oauth2/token"
        data = {
        #### здесь была инфа пользователя
        }
        response = requests.post(url, json = data)
        if response.status_code == 200:
            self.token = response.json().get('access_token')
        else:
            print(f"Ошибка при запросе: {response.status_code}")

    def SendingData(self, source_currencies_id,char, rate):
        headers = {
        'Authorization': f'Bearer {self.token}',
        'Content-Type': 'application/json'
        }
        target_currencies_id = next((item["id"] for item in self.valutes if item["char"]==char),None)
        exchange_rates_id = next((item["exchange_rates_id"] for item in self.exchange_rates if item["source_currencies_id"]==target_currencies_id and item["target_currencies_id"] == source_currencies_id),None)    
        if isinstance(rate,str):
            rate = rate.replace(',','.')
            rate = float(rate)         
        data={
            "sourceCurrenciesId":target_currencies_id,
            "targetCurrenciesId":source_currencies_id,
            "rate":rate
        }
        try:
            response = requests.put(f"https://ac.cisgeo.info/api/iworker/v1/exchange-rates/{exchange_rates_id}",json = data, headers=headers, timeout=5)
            print(exchange_rates_id)
            print("Код статуса:", response.status_code)
            print("Тело ответа:", response.content.decode())
        except requests.exceptions.Timeout:
            print("Запрос превысил время ожидания.")
        except requests.exceptions.RequestException as e:
            print("Произошла ошибка:", e)

    def GetData(self):
        print("тут запрос")

    def Actions(self):
        self.GetToken()
        self.GetData()                

