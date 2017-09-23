Java EE 1.4 Portable Local EJB Lookup Demo
===

This example provides a simple demonstration of the use of `<ejb-local-ref>` elements in deployment descriptors to 
provide portable JNDI lookups of local EJB home interfaces without the use of vendor dependent deployment descriptors
such as as jboss.xml and jboss-web.xml by exploiting `<ejb-link>` entries.

This example has been tested on:
 
 * JBoss AS 4.2.3
 * JBoss AS 6.0
 * WildFly 10.1.

There seems to be a caveat however. As far as JBoss AS is concerned, your ejb-jar.xml must be upgraded to at least 
the 3.0 schema in order for it to work correctly in the newer server implementations.

This code as committed runs on AS 6.0 and WF 10.1 withot changes; The ejb-jar.xml must be downgraded to the 2.1 schema
for AS 4.2.3.

I could not find any combination of DDs that would work on JBoss AS 5.1.0.

It was written in response to the Stack Overflow question
 [Java EJB2 JNDI Look Up Fail when migrating from Jboss 4 to Jboss 6](https://stackoverflow.com/questions/46246176/java-ejb2-jndi-look-up-fail-when-migrating-from-jboss-4-to-jboss-6?noredirect=1#comment79695323_46246176).

Unfortunately it does not work on 5.1.0. It does not seem to implement `<ejb-link>` correctly for looking up home 
interfaces. 