/*******************************************************************************
 * Copyright (c) 2012,2020 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package ejbtestnobnd_j.ejb;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;

/**
 * Session Bean implementation class EJBBndAbiguousBean1
 */
@Stateless
@Local(EJBBndAmbiguousLocal.class)
public class EJBBndAmbiguousBean2 implements EJBBndAmbiguousLocal {
    public EJBBndAmbiguousBean2() {
        // EMPTY
    }

    @Override
    public String getName() {
        return "bean2";
    }
}
