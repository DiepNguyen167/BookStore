/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.manage.main;

import edu.tdt.manage.impl.BookStoreImpl;

/**
 *
 * @author Diep Nguyen
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BookStoreImpl store = new BookStoreImpl();
        store.testStatelessEJB();
    }
    
}
