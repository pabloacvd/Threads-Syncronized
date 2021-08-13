package ar.com.xeven;

public class QueueCustom {

    private int[] datos;
    private int sigEnt, sigSal, ocupados, tamanio;

    public QueueCustom(int tamanio){
        this.datos = new int[tamanio];
        this.tamanio = tamanio;
        this.ocupados = 0;
        this.sigEnt = 1;
        this.sigSal = 1;
    }

    public synchronized int saberCuantosOcupados(){
        return this.ocupados;
    }

    public synchronized void almacenar(int numero){
        try{
            while(ocupados == tamanio) wait(); // si no hay espacio disponible, espero

            datos[sigEnt] = numero;
            sigEnt = (sigEnt+1) % tamanio;
            ocupados++;
            notify(); // notifico que ya agregué un número
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized int extraer(){
        int numero = 0;
        try{
            while(ocupados==0) wait(); // si no hay nada ocupado, espero

            numero = datos[sigSal];
            sigSal = (sigSal+1) % tamanio;
            ocupados--;

            notify(); // aviso que retiré un número
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return numero;
    }

}
