from locust import HttpUser, task, between
import random
import string

def random_string(length=6):
    return ''.join(random.choices(string.ascii_letters, k=length))

class ProductUser(HttpUser):
    wait_time = between(1, 3)
    base_path = "/product-service/api/products"

    @task(2)
    def list_products(self):
        self.client.get(f"{self.base_path}")

    @task(3)
    def create_and_fetch_and_delete_product(self):
        product_data = {
            {
            "productTitle": "nuevo producto",
            "imageUrl": "http://imagen.com/producto.jpg",
            "sku": "SKU123",
            "priceUnit": 123.45,
            "quantity": 10,
            "categoryDto": {
                "categoryId": 1
            }
            }
        }

        # Crear producto
        response = self.client.post(f"{self.base_path}", json=product_data)
        if response.status_code == 201:
            product_id = response.json().get("productId")
            if product_id:
                # Consultar producto creado (debería de ser 100% la tasa de exito)
                self.client.get(f"{self.base_path}/{product_id}")
                # Eliminar producto
                self.client.delete(f"{self.base_path}/{product_id}")

    @task(1)
    def get_nonexistent_product(self):
        # prueba de obtener un producto que no existe (fallo asegurado para ver tasa)
        self.client.get(f"{self.base_path}/999999", name=f"{self.base_path}/nonexistent")
