@Configuration
@EnableJpaRepositories(
    basePackages = "com.example.employeemultidb.audit.repository",
    entityManagerFactoryRef = "secondaryEntityManagerFactory",
    transactionManagerRef = "secondaryTransactionManager"
)
public class SecondaryDataSourceConfig {

    @Bean
    @ConfigurationProperties("secondary.datasource")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(
        EntityManagerFactoryBuilder builder
    ) {
        return builder
            .dataSource(secondaryDataSource())
            .packages("com.example.employeemultidb.audit.model")
            .persistenceUnit("secondary")
            .build();
    }

    @Bean
    public PlatformTransactionManager secondaryTransactionManager(
        @Qualifier("secondaryEntityManagerFactory") EntityManagerFactory emf
    ) {
        return new JpaTransactionManager(emf);
    }
}
