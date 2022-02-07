package com.manoj.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.manoj.ecommerce.entity.Country;
import com.manoj.ecommerce.entity.Order;
import com.manoj.ecommerce.entity.Product;
import com.manoj.ecommerce.entity.ProductCategory;
import com.manoj.ecommerce.entity.State;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	@Autowired
	private EntityManager entityManager;
	
	    @Value("${allowed.origins}")
	    private String[] theAllowedOrigins;

	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

		HttpMethod[] theUnsupportedActions = { HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH };

        // disable HTTP methods for ProductCategory: PUT, POST, DELETE and PATCH
        disableHttpMethods(Product.class, config, theUnsupportedActions);
        disableHttpMethods(ProductCategory.class, config, theUnsupportedActions);
        disableHttpMethods(Country.class, config, theUnsupportedActions);
        disableHttpMethods(State.class, config, theUnsupportedActions);
        disableHttpMethods(Order.class, config, theUnsupportedActions);

		// expose entity ids
		// - get a list of all entity classes from the entity manager
		exposeIds(config);
		
		 // configure cors mapping
		//can make CORS as global to confgiure here
         cors.addMapping(config.getBasePath() + "/**").allowedOrigins(theAllowedOrigins);

	}

	private void exposeIds(RepositoryRestConfiguration config) {
		config.exposeIdsFor(
				entityManager.getMetamodel().getEntities().stream().map(Type::getJavaType).toArray(Class[]::new));
	}

	private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config,
			HttpMethod[] theUnsupportedActions) {
		config.getExposureConfiguration().forDomainType(theClass)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
	}

}
