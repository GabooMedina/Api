
package ec.acaiza.proxy.implement;


public class SeriviceFactory {
    public static IProcessProxy createProcessEjecutor(){
        return new ProcessEjecutorProxy();
    }
    
}
