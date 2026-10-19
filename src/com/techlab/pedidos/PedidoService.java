package com.techlab.pedidos;

import java.util.ArrayList;

public class PedidoService {

    private ArrayList<Pedido> pedidos;

    public PedidoService() {
        pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void listarPedidos() {

        if(pedidos.isEmpty()){
            System.out.println("No hay pedidos registrados.");
            return;
        }

        for (Pedido pedido : pedidos) {

            System.out.println("\nPedido Nº " + pedido.getId());

            for (LineaPedido linea : pedido.getLineas()) {

                System.out.println(
                        linea.getProducto().getNombre()
                        + " x "
                        + linea.getCantidad()
                );
            }

            System.out.println("Total: $" + pedido.calcularTotal());
        }
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}