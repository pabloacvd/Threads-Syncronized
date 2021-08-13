package ar.com.xeven;

public class Consumidor implements Runnable{

    private String id;
    private QueueCustom buffer;
    private Thread hiloPropio = null;

    public Consumidor(QueueCustom buffer, int id) {
        this.id = String.valueOf(id);
        this.buffer = buffer;
        this.hiloPropio = new Thread(this);
        this.hiloPropio.start();
    }

    @Override
    public void run() {
        int dato = 0;
        while(dato < 10){
            dato = buffer.extraer();
            System.out.println("(Consumidor "+id+") extraer: "+dato);
        }
        System.out.println("FIN consumidor "+id+" con "+dato);
        System.out.println(id+") Ocupados: "+buffer.saberCuantosOcupados());
    }
}
