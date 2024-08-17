package signal.minervini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceC {
    final ServiceD serviceD;

    @Autowired
    public ServiceC(ServiceD serviceD) {
        this.serviceD = serviceD;
    }
}
