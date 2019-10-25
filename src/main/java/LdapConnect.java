import javax.naming.*;
import javax.naming.directory.*;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;

public class LdapConnect {
    public static void main(String[] args) {
        //LDAP server url
        String url = "ldap://localhost:5001/o=volkswagen";
        Hashtable env = new Hashtable();
        //specifies the fully qualified class name of the factory class that will create an initial context
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        //specifies URL of the service provider
        env.put(Context.PROVIDER_URL, url);
        //using simple authentication
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        //specifies username of the principal for the authentication
        env.put(Context.SECURITY_PRINCIPAL, "uid=admin,ou=system");
        //specifies password of the principal for the authentication
        env.put(Context.SECURITY_CREDENTIALS, "test");

        try {
            DirContext ctx = new InitialDirContext(env);
            System.out.println("connected");
            System.out.println(ctx.getEnvironment());
            //Search point for any Organization Unit
            String base = "ou=users";
            SearchControls sc = new SearchControls();
            //Specify the ids of the attributes to return
            String[] attributeFilter = {"mail", "userPassword"};
            sc.setReturningAttributes(attributeFilter);
            sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
            //Define Search Pattern
            String filter = "(cn=p*)";
            //Search for objects that have those matching attributes
            NamingEnumeration results = ctx.search(base, filter, sc);
            while (results.hasMore()) {
                SearchResult sr = (SearchResult) results.next();
                Attributes attrs = sr.getAttributes();

                Attribute attr = attrs.get("mail");
                System.out.println(attr.get());
                attr = attrs.get("userPassword");
                System.out.println(attr.get());

                //  changePassword(ctx);
            }
            ctx.close();

        } catch (AuthenticationNotSupportedException ex) {
            System.out.println("The authentication is not supported by the server");
        } catch (AuthenticationException ex) {
            System.out.println("incorrect password or username");
        } catch (NamingException ex) {
            System.out.println("error when trying to create the context");
}
        }

    }

