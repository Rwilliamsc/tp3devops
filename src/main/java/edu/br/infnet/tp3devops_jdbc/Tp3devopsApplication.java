package edu.br.infnet.tp3devops_jdbc;

import io.r2dbc.h2.H2ConnectionConfiguration;
import io.r2dbc.h2.H2ConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import io.r2dbc.h2.H2ConnectionFactoryProvider;

import javax.sql.DataSource;

@SpringBootApplication
@EnableJdbcRepositories(basePackages = "edu.br.infnet.tp3devops_jdbc.fornecedor.repository")
public class Tp3devopsApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp3devopsApplication.class, args);
    }

    @Bean
    public ConnectionFactory r2dbcConnectionFactory() {
        return ConnectionFactoryBuilder.withOptions(ConnectionFactoryOptions.builder()
                        .option(ConnectionFactoryOptions.DRIVER, H2ConnectionFactoryProvider.H2_DRIVER)
                        .option(ConnectionFactoryOptions.PROTOCOL, "mem")
                        .option(ConnectionFactoryOptions.USER, "sa")
                        .option(ConnectionFactoryOptions.PASSWORD, "")
                        .option(ConnectionFactoryOptions.DATABASE, "tp3_dr4")
                        .build().mutate())
                .build();
    }

    @Bean
    public DataSource jdbcDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:tp3_dr4;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }
}
