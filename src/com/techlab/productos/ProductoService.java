package com.techlab.productos;

import java.util.ArrayList;

public class ProductoService {

    private ArrayList<Producto> productos;

    public ProductoService() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void listarProductos() {

        if(productos.isEmpty()){
            System.out.println("No hay productos cargados.");
            return;
        }

        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    public Producto buscarPorId(int id) {

        for (Producto producto : productos) {

            if(producto.getId() == id){
                return producto;
            }
        }

        return null;
    }

    public boolean eliminarProducto(int id) {

        Producto producto = buscarPorId(id);

        if(producto != null){
            productos.remove(producto);
            return true;
        }

        return false;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
}