/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdt.edu.stateless;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import tdt.edu.persistence.Account;
import tdt.edu.persistence.Books;

/**
 *
 * @author Diep Nguyen
 */
@Stateless
public class ManageBookBean implements ManageBookBeanRemote {

    @PersistenceContext(unitName = "ManageBookPU")
    private EntityManager entityManager;

    public ManageBookBean() {

    }

    @Override
    public List<Books> getListBook() {
       return entityManager.createNamedQuery("Books.findAll").getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void addBook(Books book) {
       entityManager.persist(book);
    }
    
    @Override
    public Account logIn(String username, String pass){
        List<Account> list = entityManager.createNamedQuery("Account.findByUsername").setParameter("username", username).getResultList();
        if(!list.isEmpty()){
            for (Account account : list) {
                if(account.getPass().equals(pass)){
                    Account user = new Account();
                            user.setUsername(account.getUsername());
                            user.setPass(pass);
                            user.setRole(account.getRole());
                            return user;
                }
            }
        }
        return null;
    }
}
