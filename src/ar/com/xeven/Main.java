package ar.com.xeven;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // creo la fila con 10 posiciones
        QueueCustom elBuffer = new QueueCustom(10);

        // creo al productor y le paso la fila
        Productor productor = new Productor(elBuffer);

        // creo 3 consumidores
        Consumidor[] consumidores = new Consumidor[3];

        // Creo un Thread con el productor y lo ejecuto
        Thread hiloProductor = new Thread(productor);
        hiloProductor.start();

        // para cada consumidor, le paso la fila y su identificador
        for(int i=0; i < consumidores.length; i++)
            consumidores[i] = new Consumidor(elBuffer, i);
    }
}
