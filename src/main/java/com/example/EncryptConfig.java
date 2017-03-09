package com.example;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.jasypt.properties.PropertyValueEncryptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

/**
 * Created by liuhz on 15/12/9.
 */
/*@Configuration
@ConditionalOnClass(StringEncryptor.class)
@PropertySource(value = {"${encrypt.file:classpath:config/encrypted.properties}"})*/
public class EncryptConfig /*implements EnvironmentAware */{
   /* private final static Logger log = LoggerFactory.getLogger(EncryptConfig.class);
    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE)
    public BeanFactoryPostProcessor propertySourcesPostProcessor() {
        return new EnableEncryptablePropertySourcesPostProcessor(stringEncryptor());
    }

    private StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(getProperty(environment, "jasypt.encryptor.password", "msxf2015"));
        config.setAlgorithm(getProperty(environment, "jasypt.encryptor.algorithm", "PBEWithMD5AndDES"));
        config.setKeyObtentionIterations(getProperty(environment, "jasypt.encryptor.keyObtentionIterations", "1000"));
        config.setPoolSize(getProperty(environment, "jasypt.encryptor.poolSize", "1"));
        config.setProviderName(getProperty(environment, "jasypt.encryptor.providerName", "SunJCE"));
        config.setSaltGeneratorClassName(getProperty(environment, "jasypt.encryptor.saltGeneratorClassname", "org.jasypt.salt.RandomSaltGenerator"));
        config.setStringOutputType(getProperty(environment, "jasypt.encryptor.stringOutputType", "base64"));
        encryptor.setConfig(config);

        return encryptor;
    }

    private String getProperty(Environment environment, String key, String defaultValue) {
        if (environment.getProperty(key) == null) {
            log.info("Encryptor config not found for property {}, using default value: {}", key, defaultValue);
        }
        return environment.getProperty(key, defaultValue);
    }

    private class EnableEncryptablePropertySourcesPostProcessor implements BeanFactoryPostProcessor {
        private StringEncryptor encryptor;

        public EnableEncryptablePropertySourcesPostProcessor(StringEncryptor encryptor) {
            this.encryptor = encryptor;
        }

        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
            MutablePropertySources propSources = ((ConfigurableEnvironment) environment).getPropertySources();
            for (org.springframework.core.env.PropertySource<?> ps : propSources) {
                if (ps instanceof ResourcePropertySource) {
                    propSources.replace(ps.getName(), new PropertySourceWapper((ResourcePropertySource) ps));
                }
            }
        }

        private class PropertySourceWapper extends MapPropertySource {
            public PropertySourceWapper(ResourcePropertySource ps) {
                super(ps.getName(), ps.getSource());
            }

            @Override
            public Object getProperty(String name) {
                Object value = super.getProperty(name);
                if (value instanceof String) {
                    String stringValue = String.valueOf(value);
                    if (PropertyValueEncryptionUtils.isEncryptedValue(stringValue)) {
                        value = PropertyValueEncryptionUtils.decrypt(stringValue, encryptor);
                    }
                }
                return value;
            }
        }
    }*/
}
