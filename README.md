# 📦 Sistema de Gestión de Productos y Pedidos

Proyecto desarrollado en Java como preentrega del Trabajo Final Integrador.

## 📖 Descripción

Aplicación de consola que permite gestionar productos y pedidos mediante un menú interactivo.

El sistema implementa conceptos fundamentales de Programación Orientada a Objetos (POO), colecciones, manejo de excepciones, encapsulamiento, herencia y organización por paquetes.

---

## 🚀 Funcionalidades

### Gestión de productos

✅ Agregar productos

✅ Listar productos

✅ Buscar productos por ID

✅ Actualizar precio y stock

✅ Eliminar productos

### Gestión de pedidos

✅ Crear pedidos

✅ Asociar productos con cantidades

✅ Calcular el total del pedido

✅ Listar pedidos realizados

✅ Actualizar stock automáticamente al confirmar un pedido

### Validaciones

✅ Control de stock disponible

✅ Excepción personalizada para stock insuficiente

✅ Validación de datos ingresados

---

## 🏗️ Estructura del proyecto

```text
src
└── com
    └── techlab
        ├── excepciones
        │   └── StockInsuficienteException
        │
        ├── main
        │   └── Main
        │
        ├── pedidos
        │   ├── Pedido
        │   ├── LineaPedido
        │   └── PedidoService
        │
        ├── productos
        │   ├── Producto
        │   ├── Bebida
        │   └── ProductoService
        │
        └── utils
            └── InputHelper
```

---

## 💻 Tecnologías utilizadas

- Java
- Programación Orientada a Objetos (POO)
- ArrayList
- Excepciones personalizadas
- Git
- GitHub

---

## 📚 Conceptos aplicados

- Clases y Objetos
- Encapsulamiento
- Herencia
- Polimorfismo básico
- Colecciones (ArrayList)
- Manejo de excepciones
- Organización por paquetes
- Servicios para separación de responsabilidades

---

## ▶️ Ejemplo de uso

```text
1) Agregar producto
2) Listar productos
3) Buscar producto
4) Actualizar producto
5) Eliminar producto
6) Crear pedido
7) Listar pedidos
8) Salir
```

---

## 👨‍💻 Autor

Leandro Herrera

Repositorio:
https://github.com/LeanHerrera97/proyecto-java-gestion-productos