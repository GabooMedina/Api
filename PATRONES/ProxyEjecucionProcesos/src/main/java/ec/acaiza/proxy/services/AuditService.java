
package ec.acaiza.proxy.services;

import java.text.SimpleDateFormat;
import java.util.Date;
public class AuditService {
    
    public void auditServiceUsed(String user, String service) {
        SimpleDateFormat formater = 
                new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        System.out.println(user + " utilizo el servicio" + 
                service + "a las " + formater.format(new Date()));
        
    }
    
}
