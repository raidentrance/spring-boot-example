/**
 * 
 */
package com.raidentrance.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author raidentrance
 *
 */
@EnableTransactionManagement
@EnableJpaRepositories("com.raidentrance.repositories")
public class SpringDataConfig {

}