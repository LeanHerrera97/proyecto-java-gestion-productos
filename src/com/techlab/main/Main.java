package com.techlab.main;

import com.techlab.excepciones.StockInsuficienteException;
import com.techlab.pedidos.LineaPedido;
import com.techlab.pedidos.Pedido;
import com.techlab.pedidos.PedidoService;
import com.techlab.productos.Producto;
import com.techlab.productos.ProductoService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ProductoService productoService = new ProductoService();
        PedidoService pedidoService = new PedidoService();

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
            System.out.println("6) Crear pedido");
            System.out.println("7) Listar pedidos");
            System.out.println("8) Salir");
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

                    Producto producto =
                            new Producto(nombre, precio, stock);

                    productoService.agregarProducto(producto);

                    System.out.println("Producto agregado correctamente.");
                    break;

                case 2:

                    productoService.listarProductos();
                    break;

                case 3:

                    System.out.print("Ingrese ID del producto: ");
                    int idBuscar =
                            Integer.parseInt(scanner.nextLine());

                    Producto encontrado =
                            productoService.buscarPorId(idBuscar);

                    if (encontrado != null) {

                        System.out.println(encontrado);

                    } else {

                        System.out.println("Producto no encontrado.");
                    }

                    break;

                case 4:

                    System.out.print("Ingrese ID del producto: ");
                    int idActualizar =
                            Integer.parseInt(scanner.nextLine());

                    Producto actualizar =
                            productoService.buscarPorId(idActualizar);

                    if (actualizar != null) {

                        System.out.print("Nuevo precio: ");
                        double nuevoPrecio =
                                Double.parseDouble(scanner.nextLine());

                        System.out.print("Nuevo stock: ");
                        int nuevoStock =
                                Integer.parseInt(scanner.nextLine());

                        actualizar.setPrecio(nuevoPrecio);
                        actualizar.setStock(nuevoStock);

                        System.out.println("Producto actualizado.");

                    } else {

                        System.out.println("Producto no encontrado.");
                    }

                    break;

                case 5:

                    System.out.print("Ingrese ID del producto a eliminar: ");
                    int idEliminar =
                            Integer.parseInt(scanner.nextLine());

                    if (productoService.eliminarProducto(idEliminar)) {

                        System.out.println("Producto eliminado correctamente.");

                    } else {

                        System.out.println("Producto no encontrado.");
                    }

                    break;

                case 6:

                    try {

                        System.out.print("Ingrese ID del producto: ");
                        int idProducto =
                                Integer.parseInt(scanner.nextLine());

                        Producto productoPedido =
                                productoService.buscarPorId(idProducto);

                        if (productoPedido == null) {

                            System.out.println("Producto no encontrado.");
                            break;
                        }

                        System.out.print("Cantidad: ");
                        int cantidad =
                                Integer.parseInt(scanner.nextLine());

                        if (cantidad > productoPedido.getStock()) {

                            throw new StockInsuficienteException(
                                    "Stock insuficiente. Disponible: "
                                            + productoPedido.getStock()
                            );
                        }

                        Pedido pedido = new Pedido();

                        LineaPedido lineaPedido =
                                new LineaPedido(
                                        productoPedido,
                                        cantidad
                                );

                        pedido.agregarLinea(lineaPedido);

                        productoPedido.setStock(
                                productoPedido.getStock() - cantidad
                        );

                        pedidoService.agregarPedido(pedido);

                        System.out.println("Pedido creado correctamente.");
                        System.out.println(
                                "Total: $" + pedido.calcularTotal()
                        );

                    } catch (StockInsuficienteException e) {

                        System.out.println(e.getMessage());

                    } catch (Exception e) {

                        System.out.println("Error al crear el pedido.");
                    }

                    break;

                case 7:

                    pedidoService.listarPedidos();
                    break;

                case 8:

                    System.out.println("Saliendo del sistema...");
                    break;

                default:

                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 8);

        scanner.close();
    }
}