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

