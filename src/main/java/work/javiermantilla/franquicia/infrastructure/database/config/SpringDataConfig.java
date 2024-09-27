package work.javiermantilla.franquicia.infrastructure.database.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableJpaRepositories(
    basePackages = "work.javiermantilla.franquicia.infrastructure.database.repository")
@Slf4j
@NoArgsConstructor
@Data
@EnableJpaAuditing
@EntityScan(basePackages = "work.javiermantilla.franquicia.infrastructure.database.entity")
public class SpringDataConfig {

}
