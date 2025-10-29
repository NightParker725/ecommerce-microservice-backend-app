from locust import HttpUser, task, between
import json
from datetime import datetime
import random

class OrderServiceUser(HttpUser):
    wait_time = between(1, 2)

#obtenemos lista de orders en su totalidad
    @task(1)
    def get_all_orders(self):
        self.client.get("/order-service/api/orders")

#creamos una orden asi basica con datos random
    @task(1)
    def create_order(self):
        order_data = {
            "orderDate": datetime.now().strftime("%Y-%m-%d %H:%M:%S"),
            "orderDesc": f"Load test order {random.randint(1, 1000)}",
            "orderFee": round(random.uniform(10.0, 200.0), 2)
        }
        self.client.post(
            "/order-service/api/orders",
            headers={"Content-Type": "application/json"},
            data=json.dumps(order_data)
        )
