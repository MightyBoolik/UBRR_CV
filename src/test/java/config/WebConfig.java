package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

@LoadPolicy(LoadType.MERGE)
@Sources({
        "system:properties",
        "classpath:config/remote_config.properties"
})
public interface WebConfig extends Config {

    @Key("url")
    String url();

    @Key("web.remote.driver.user")
    String webRemoteDriverUser();

    @Key("web.remote.driver.password")
    String webRemoteDriverPassword();
}