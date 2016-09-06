/**
 * 
 */
package com.raidentrance.assembler;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.jaxrs.JaxRsLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import jersey.repackaged.com.google.common.base.Preconditions;

/**
 * @author raidentrance
 *
 */
public abstract class JaxRsResourceAssemblerSupport<T, D extends ResourceSupport>
		extends ResourceAssemblerSupport<T, D> {
	private final Class<?> controllerClass;

	public JaxRsResourceAssemblerSupport(Class<?> controllerClass, Class<D> resourceType) {

		super(controllerClass, resourceType);
		this.controllerClass = controllerClass;
	}

	@Override
	protected D createResourceWithId(Object id, T entity, Object... parameters) {
		Preconditions.checkNotNull(entity);
		Preconditions.checkNotNull(id);
		D instance = instantiateResource(entity);
		instance.add(JaxRsLinkBuilder.linkTo(controllerClass).slash(id).withSelfRel());
		return instance;
	}
}
