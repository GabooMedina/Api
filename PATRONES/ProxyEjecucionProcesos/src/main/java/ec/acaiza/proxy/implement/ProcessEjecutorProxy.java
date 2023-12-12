package ec.acaiza.proxy.implement;

import ec.acaiza.proxy.services.AuditService;
import ec.acaiza.proxy.services.SecuirityService;

/**
 *
 * @author USUARIO
 */
public class ProcessEjecutorProxy implements IProcessProxy {

    @Override
    public void ejecuteProcess(int idProcess, String user, String password) throws Exception {
        SecuirityService secuirityService = new SecuirityService();
        if (!secuirityService.authorization(user, password)) {

            throw new Exception("El usuario " + user + " no tiene privilegios para ejecutar el proceso");

        }
        DefaultProcessEjecutor ejecutorProcess = new DefaultProcessEjecutor();
        ejecutorProcess.ejecuteProcess(idProcess, user, password);

        AuditService audit = new AuditService();
        audit.auditServiceUsed(user, DefaultProcessEjecutor.class.getName());

    }

}
