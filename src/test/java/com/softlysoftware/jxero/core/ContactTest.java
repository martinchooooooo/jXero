package com.softlysoftware.jxero.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import com.softlysoftware.jxero.core.Contact;
import com.softlysoftware.jxero.ContactsEndpoint;
import com.softlysoftware.jxero.Xml;

import org.apache.commons.io.IOUtils;
import org.xmlmatchers.XmlMatchers;
import org.xmlmatchers.transform.XmlConverters;

@RunWith(JUnit4.class)
public class ContactTest {

    @Test
    public void testFromXml() throws IOException {
    	String xml = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("Contacts.xml"), "UTF-8");
    	ContactsEndpoint contacts = (ContactsEndpoint)Xml.fromXml(xml, ContactsEndpoint.class);
    	assertEquals(1, contacts.getList().size());
    	Contact contact = contacts.getList().get(0);
    	assertEquals(Contact.Status.ACTIVE, contact.getStatus());
    	assertEquals("a.dutchess@abclimited.com", contact.getEmailAddress());
    	assertEquals("6011", contact.getAddresses().get(0).getPostalCode());
    	assertEquals(4, contact.getPhones().size());
    	assertEquals("1111111", contact.getPhones().get(0).getPhoneNumber());
        String xmlBounced = Xml.toXml(contacts);
        assertThat(XmlConverters.the(xml), XmlMatchers.isEquivalentTo(XmlConverters.the(xmlBounced)));
    }

}