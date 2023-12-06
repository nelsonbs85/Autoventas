package com.autoventas.autos.infrastructure.config;

import com.autoventas.autos.application.services.AutoServicio;
import com.autoventas.autos.application.usecases.*;
import com.autoventas.autos.domain.ports.in.GetAdditionalAutoInfo;
import com.autoventas.autos.domain.ports.out.AutoRepositoryPort;
import com.autoventas.autos.domain.ports.out.ExternalServicePort;
import com.autoventas.autos.infrastructure.adapters.ExternalServiceAdapter;
import com.autoventas.autos.infrastructure.repositories.JpaAutoRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ApplicationConfig {
    @Bean
    public AutoServicio autoServicio(AutoRepositoryPort autoRepositoryPort, GetAdditionalAutoInfo getAdditionalAutoInfo){
        return new AutoServicio(
                new CreateAutoImpl(autoRepositoryPort),
                new RetrieveAutoImpl(autoRepositoryPort),
                new UpdateAutoImpl(autoRepositoryPort),
                new DeleteAutoImpl(autoRepositoryPort),
                getAdditionalAutoInfo
        );
    }

    @Bean
    public AutoRepositoryPort autoRepositoryPort(JpaAutoRepositoryAdapter jpaAutoRepositoryAdapter){
        return jpaAutoRepositoryAdapter;
    }
    @Bean
    public GetAdditionalAutoInfo getAdditionalAutoInfo(ExternalServicePort externalServicePort){
        return new GetAdditionalAutoInfoImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort(){
        return new ExternalServiceAdapter();
    }
}
