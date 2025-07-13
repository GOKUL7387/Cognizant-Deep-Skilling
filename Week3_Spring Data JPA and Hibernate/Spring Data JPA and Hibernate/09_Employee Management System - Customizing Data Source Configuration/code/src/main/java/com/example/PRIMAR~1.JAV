@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = "com.example.employeemultidb.repository",
    entityManagerFactoryRef = "primaryEntityManagerFactory",
    transactionManagerRef = "primaryTransactionManager"
)
public class PrimaryDataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
        EntityManagerFactoryBuilder builder
    ) {
        return builder
            .dataSource(primaryDataSource())
            .packages("com.example.employeemultidb.model")
            .persistenceUnit("primary")
            .build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager primaryTransactionManager(
        @Qualifier("primaryEntityManagerFactory") EntityManagerFactory emf
    ) {
        return new JpaTransactionManager(emf);
    }
}
