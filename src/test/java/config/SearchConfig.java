package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

@LoadPolicy(LoadType.MERGE)
@Sources({
        "system:properties",
        "classpath:remote_config.properties"
})
public interface SearchConfig extends Config {
    @Key("text")
    String text();
}