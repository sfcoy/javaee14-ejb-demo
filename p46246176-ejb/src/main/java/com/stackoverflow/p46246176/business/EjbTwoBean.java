package com.stackoverflow.p46246176.business;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class EjbTwoBean implements SessionBean {

    private static final long serialVersionUID = -4640386196767797188L;
    
    private List<String> names;

    public String findWho() {
        final int index = new Random(System.currentTimeMillis()).nextInt(names.size());
        return names.get(index);
    }

    public void ejbCreate() {
        names = new ArrayList<String>();
        names.add("Steve");
        names.add("Fred");
        names.add("Cindy");
        names.add("Rob");
        names.add("Tom");
    }

    @Override
    public void setSessionContext(SessionContext sessionContext) throws EJBException, RemoteException {
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
