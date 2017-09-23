package com.stackoverflow.p46246176.business;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

public interface EjbOneLocalHome extends EJBLocalHome {

    EjbOneLocal create() throws CreateException;
    
}
