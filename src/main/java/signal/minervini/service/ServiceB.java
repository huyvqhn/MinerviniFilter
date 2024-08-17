package signal.minervini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("serviceA")
public class ServiceB {
    private final ServiceC serviceC;

    @Autowired
    public ServiceB(ServiceC serviceC) {
        this.serviceC = serviceC;
    }
}
