/*
 *
 *  JBoss, Home of Professional Open Source.
 *  Copyright 2013, Red Hat, Inc., and individual contributors
 *  as indicated by the @author tags. See the copyright.txt file in the
 *  distribution for a full listing of individual contributors.
 *
 *  This is free software; you can redistribute it and/or modify it
 *  under the terms of the GNU Lesser General Public License as
 *  published by the Free Software Foundation; either version 2.1 of
 *  the License, or (at your option) any later version.
 *
 *  This software is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this software; if not, write to the Free
 *  Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 *  02110-1301 USA, or see the FSF site: http://www.fsf.org.
 * /
 */

package org.jboss.as.undertow.errorhandler;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import io.undertow.server.HttpHandler;
import org.jboss.as.controller.AttributeDefinition;
import org.jboss.as.controller.OperationContext;
import org.jboss.as.controller.OperationFailedException;
import org.jboss.as.controller.SimpleAttributeDefinitionBuilder;
import org.jboss.as.undertow.AbstractHandlerDefinition;
import org.jboss.as.undertow.Constants;
import org.jboss.dmr.ModelNode;
import org.jboss.dmr.ModelType;

/**
 * @author <a href="mailto:tomaz.cerar@redhat.com">Tomaz Cerar</a> (c) 2013 Red Hat Inc.
 */
class ErrorPageDefinition extends AbstractHandlerDefinition {

    private static final AttributeDefinition CODE = new SimpleAttributeDefinitionBuilder("code", ModelType.INT)
            .setAllowExpression(true)
            .setAllowNull(true)
            .build();
    private static final AttributeDefinition PATH = new SimpleAttributeDefinitionBuilder("path", ModelType.STRING)
            .setAllowExpression(true)
            .setAllowNull(true)
            .build();
    private static final Collection<AttributeDefinition> ATTRIBUTES = Collections.unmodifiableCollection(Arrays.asList(CODE, PATH));
    static final ErrorPageDefinition INSTANCE = new ErrorPageDefinition();

    private ErrorPageDefinition() {
        super(Constants.ERROR_PAGE);
    }

    @Override
    public Collection<AttributeDefinition> getAttributes() {
        return ATTRIBUTES;
    }

    public HttpHandler createHandler(HttpHandler next, OperationContext context, ModelNode model) throws OperationFailedException {
        return null;
    }
}
