from locust import HttpUser, task, between

class UserServiceLocustTest(HttpUser):
    wait_time = between(1, 3)

#obtenemos lista de users en su totalidad
    @task(1)
    def get_users(self):
        self.client.get("/user-service/api/users")

#creamos el user con info de plantilla de ejemplo
    @task(1)
    def create_user(self):
        self.client.post("/user-service/api/users", json={
            "firstName": "Load",
            "lastName": "Test",
            "email": "load@test.com",
            "phone": "123456789",
            "imageUrl": "load.jpg"
        })
