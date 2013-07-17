jXero
=====

A simple Java library for the [Xero API](http://developer.xero.com/documentation/api/api-overview/).

#### Easy to set up

Drop the jar on your classpath and you can run code like this to connect:

    String consumerKey = "JDFSDKGEN4567DFS9987DFSF993222";
    String consumerSecret = "JDFSDKGEN4567DFS9987DFSF993222";
    File privateKeyFile = new File("/path/to/your/privatekey.pem");
    XeroClient xeroClient = new XeroClient(consumerKey, consumerSecret, privateKeyFile);

Or include a simple properties file alongside the jar for one line setup:

    XeroClient xeroClient = new XeroClient(true);

#### Create a contact

    Contact contact = new Contact();
    contact.Name = "Acme Ltd";
    contact.EmailAddress = "acme@example.com";

    xeroClient.postContact(contact);

#### Grab a list of contacts

	List<Contact> contacts = xeroClient.getContacts();
	for (Contact contact : contacts) {
		System.out.println(contact.getEmailAddress());
	}

### No JAXB generated classes

The auto-generated classes that you get direct from JAXB can sometimes be a pain to work with.
We've tried to make the core business objects you need to work with as simple as possible.
You won't need to use a FactoryObject to pre-process the due date on your invoice - just build
like a normal bean and post through the client.

### Actively Maintained by Friendly Team

Here at [Softly Software Ltd](http://softlysoftware.com) we use Xero every day to handle all the 
transactions for our services. When it came time to plugin the servers to speak direct to our data
we looked around and couldn't find quite the right wrapper - so we built this one.

Bug reports, contributions and pull requests most welcome.

### Frequently Asked Questions

 * **There's an enpoint or type of object missing - can you add it?**
   Perhaps, if we get enough requests. But please checkout the code - you probably only need to copy and
   paste from what is already there and make some simple changes. If you badly need something adding we 
   might be able to help you find a developer who will do it for a fee.

 * **Can it be used for Public as well as Private Xero Applications?**
   We don't know. So far the emphasis has all been about making it easy for Private Applications.
   If you have any success using this for a Public Application, please do let us know.

 * **What if a question isn't answered here?**
   Please get in touch. Email us at *jxero (that symbol) softlysoftware (that punctuation mark) com*







