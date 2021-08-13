package ar.com.xeven;

public class Productor implements Runnable{

    private QueueCustom buffer;

    public Productor(QueueCustom buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int valor = 0;
        while(valor < 100){
            System.out.println("Productor suma valor "+valor);
            buffer.almacenar(valor);
            valor++;
        }
        System.out.println("FIN productor");
    }
}
