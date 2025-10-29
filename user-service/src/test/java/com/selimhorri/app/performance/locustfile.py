import json
import random
import string
from locust import HttpUser, task, between

class UserServiceLocustTest(HttpUser):
    wait_time = between(1, 3)

#obtenemos lista de users en su totalidad
    @task(1)
    def get_users(self):
        self.client.get("/user-service/api/users")
