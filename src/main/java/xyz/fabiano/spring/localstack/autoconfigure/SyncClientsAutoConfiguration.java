package xyz.fabiano.spring.localstack.autoconfigure;


import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.fabiano.spring.localstack.legacy.LocalstackDocker;
import xyz.fabiano.spring.localstack.support.AmazonClientsHolder;
import xyz.fabiano.spring.localstack.support.AmazonDockerClientsHolder;

@Configuration
@ConditionalOnExpression("${spring.localstack.enabled:false} and !${spring.localstack.async-clients.enabled:false}")
public class SyncClientsAutoConfiguration {
    @Bean
    public AmazonClientsHolder amazonClientsHolder(LocalstackDocker localstackDocker) {
        return new AmazonDockerClientsHolder(localstackDocker);
    }
}
