package koschei.models;

import koschei.config.AppConfig;
import org.springframework.stereotype.Component;

@Component
public class Needle7 {

    @Override
    public String toString() {
        return ", смерть Кощея на игле " + AppConfig.getDeth();
    }
}
