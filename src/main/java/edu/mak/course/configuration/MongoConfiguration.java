package edu.mak.course.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import edu.mak.course.dao.annotation.CascadeSaveMongoEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = "edu.mak.course.dao.repository")
public class MongoConfiguration extends AbstractMongoClientConfiguration {

    private final List<Converter<?, ?>> converters = new ArrayList<>();

    @Value("${spring.data.mongodb.uri}")
    private String mongoDbUrl;

    @Autowired
    private CascadeSaveMongoEventListener cascadeSaveMongoEventListener;

    @Override
    protected String getDatabaseName() {
        return "Hotel";
    }

    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString(mongoDbUrl);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Override
    public Collection<String> getMappingBasePackages() {
        return Collections.singleton("edu.mak.course.dao");
    }

    @Bean
    MongoTransactionManager transactionManager(@Qualifier("mongoDbFactory") MongoDatabaseFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}
