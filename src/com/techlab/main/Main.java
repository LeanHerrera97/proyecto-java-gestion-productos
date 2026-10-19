package com.techlab.main;

import com.techlab.productos.Producto;
import com.techlab.productos.ProductoService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProductoService productoService = new ProductoService();

        int opcion;

        do {

            System.out.println("\n=================================");
            System.out.println(" SISTEMA DE GESTION - TECHLAB");
            System.out.println("=================================");
            System.out.println("1) Agregar producto");
            System.out.println("2) Listar productos");
            System.out.println("3) Buscar producto");
            System.out.println("4) Actualizar producto");
            System.out.println("5) Eliminar producto");
            System.out.println("6) Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {

                case 1:

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Precio: ");
                    double precio = Double.parseDouble(scanner.nextLine());

                    System.out.print("Stock: ");
                    int stock = Integer.parseInt(scanner.nextLine());

                    Producto producto = new Producto(nombre, precio, stock);

                    productoService.agregarProducto(producto);

                    System.out.println("Producto agregado correctamente.");
                    break;

                case 2:

                    productoService.listarProductos();
                    break;

                case 3:

                    System.out.print("Ingrese ID: ");
                    int idBuscar = Integer.parseInt(scanner.nextLine());

                    Producto encontrado = productoService.buscarPorId(idBuscar);

                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }

                    break;

                case 4:

                    System.out.print("Ingrese ID del producto: ");
                    int idActualizar = Integer.parseInt(scanner.nextLine());

                    Producto actualizar = productoService.buscarPorId(idActualizar);

                    if (actualizar != null) {

                        System.out.print("Nuevo precio: ");
                        double nuevoPrecio = Double.parseDouble(scanner.nextLine());

                        System.out.print("Nuevo stock: ");
                        int nuevoStock = Integer.parseInt(scanner.nextLine());

                        actualizar.setPrecio(nuevoPrecio);
                        actualizar.setStock(nuevoStock);

                        System.out.println("Producto actualizado.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }

                    break;

                case 5:

                    System.out.print("Ingrese ID a eliminar: ");
                    int idEliminar = Integer.parseInt(scanner.nextLine());

                    if (productoService.eliminarProducto(idEliminar)) {
                        System.out.println("Producto eliminado.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }

                    break;

                case 6:

                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 6);

        scanner.close();
    }
}