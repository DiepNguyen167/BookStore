/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdt.edu.stateless;
import java.util.List;
import javax.ejb.Remote;
import tdt.edu.persistence.Account;
import tdt.edu.persistence.Books;

/**
 *
 * @author Diep Nguyen
 */
@Remote
public interface ManageBookBeanRemote {
    public List<Books> getListBook();
    public void addBook(Books book);
    public Account logIn(String username, String pass);
}
