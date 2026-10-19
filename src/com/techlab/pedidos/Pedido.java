package com.techlab.pedidos;

import java.util.ArrayList;

public class Pedido {

    private static int contador = 1;

    private int id;
    private ArrayList<LineaPedido> lineas;

    public Pedido() {
        this.id = contador++;
        this.lineas = new ArrayList<>();
    }

    public void agregarLinea(LineaPedido linea) {
        lineas.add(linea);
    }

    public int getId() {
        return id;
    }

    public ArrayList<LineaPedido> getLineas() {
        return lineas;
    }

    public double calcularTotal() {

        double total = 0;

        for (LineaPedido linea : lineas) {
            total += linea.getSubtotal();
        }

        return total;
    }
}