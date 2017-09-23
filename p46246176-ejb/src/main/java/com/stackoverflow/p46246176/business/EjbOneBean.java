package com.stackoverflow.p46246176.business;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EjbOneBean implements SessionBean {

    private static final long serialVersionUID = 6009836047707159179L;
    
    private EjbTwoLocalHome ejbTwoLocalHome;

    public String sayHello() {
        try {
            EjbTwoLocal ejbTwoLocal = ejbTwoLocalHome.create();
            return "G'Day " + ejbTwoLocal.findWho();
        } catch (CreateException e) {
            throw new EJBException("Failed to create EjbTwoLocal", e);
        }
    }

    public void ejbCreate() {

    }

    @Override
    public void setSessionContext(SessionContext sessionContext) throws EJBException, RemoteException {
        try {
            Context initialContext = new InitialContext();
            ejbTwoLocalHome = (EjbTwoLocalHome) initialContext.lookup("java:comp/env/ejb/ejbTwo");
        } catch (NamingException e) {
            throw new EJBException("Failed to lookup EjbTwoLocalHome", e);
        }
    }

    @Override
    public void ejbRemove() throws EJBException, RemoteException {
    }

    @Override
    public void ejbActivate() throws EJBException, RemoteException {
    }

    @Override
    public void ejbPassivate() throws EJBException, RemoteException {
    }
    
}
