/*******************************************************************************
 * Copyright (c) 2006, 2018 IBM Corporation and others.
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
package com.ibm.ws.ejbcontainer.remote.ejb3session.sl.mix.ejb;

import static javax.ejb.TransactionAttributeType.NEVER;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.TransactionAttribute;

import com.ibm.websphere.ejbcontainer.test.tools.FATTransactionHelper;

/**
 * Bean implementation class for Enterprise Bean: ExpClassExpXMLMethodBean
 **/
@Local(ExpClassExpXMLMethodLocal.class)
@Remote(ExpClassExpXMLMethodRemote.class)
@TransactionAttribute(NEVER)
public class ExpClassExpXMLMethodBean {
    /**
     * 1)Not taking the XML into account the bean and its methods will
     * explicitly have Tx Attr of NEVER as set at the class level 2)XML sets
     * this method to have the trans-attribute of RequiresNew 3)The XML should
     * take precedence
     *
     * To verify this, the caller must begin a global transaction prior to
     * calling this method.
     *
     * @param tid
     *            is the global transaction ID for the transaction that was
     *            started prior to calling this method.
     *
     * @return boolean true if a new global tran is created (tid's do not match)
     *         meaning the XML override worked. boolean false if the same tran
     *         is used (tid's match) meaning the XML override failed - this also
     *         means class level demarcation of NEVER failed as well.
     *
     * @throws java.lang.IllegalStateException
     *             is thrown if method is dispatched while not in any
     *             transaction context.
     */
    public boolean expClassExpXMLMethod(byte[] tid) {
        byte[] myTid = FATTransactionHelper.getTransactionId();
        if (myTid == null) {
            return false;
        }

        return (FATTransactionHelper.isSameTransactionId(tid) == false);
    }

    /**
     * 1)Not taking the XML into account the bean and its methods will
     * explicitly have Tx Attr of NEVER as set at the class level 2)There is no
     * XML used to override this method 3)The class annotation should take
     * precedence
     *
     * To verify this, the caller must begin a global transaction prior to
     * calling this method.
     *
     * There is no return. The method should throw a javax.ejb.EJBException when
     * called.
     *
     * @throws javax.ejb.EJBException
     */
    public void expClassNoXMLOverride() {}
}