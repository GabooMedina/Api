package ec.acaiza.proxy.implement;

/**
 *
 * @author USUARIO
 */
public class DefaultProcessEjecutor implements IProcessProxy {

    @Override
    public void ejecuteProcess(int idProcess, String user, String password) throws Exception {
        System.out.println("proceso" + idProcess + " en ejecucion.....");
        
        for (int i = 1; i < 10; i++) {
            Thread.sleep(1000);
            for (int j = 0; j < i; j++) {
                System.out.print(" .");
                
            }
            System.out.print(i*10 + "%");
            System.out.println();
        }
           System.out.println("Proceso " + idProcess + " terminado.");
        }
    }


