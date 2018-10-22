/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tdt.manage.impl;


import tdt.edu.persistence.Books;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import tdt.edu.stateless.ManageBookBean;
import tdt.edu.stateless.ManageBookBeanRemote;

/**
 *
 * @author Diep Nguyen
 */
public class BookStoreImpl {

    private Properties props;
    private InitialContext ctx;

    public BookStoreImpl() {
        readJNDI();
    }

    /**
     * Read the JNDI properties file
     */
    private void readJNDI() {
        props = new Properties();

        try {
            props.load(new FileInputStream("jndi.properties"));
        } catch (IOException e) {
            System.err.println(e.toString());
        }

        try {
            ctx = new InitialContext(props);
            //ctx.close();
        } catch (NamingException ex) {
            System.err.println(ex.toString());
        }
    }

    private String getJNDI() {
        String appName = "";
        String moduleName = "ManageBook";
        String distinctName = "";
        String sessionBeanName = ManageBookBean.class.getSimpleName();
        String viewClassName = ManageBookBeanRemote.class.getName();

        return "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + sessionBeanName + "!" + viewClassName;
    }

    /**
     * Show the GUI in console window
     */
    private void showGUI() {
        System.out.println("\n===============================");
        System.out.println("Welcome to TDTU Bookstore");
        System.out.println("===============================");
        System.out.print("Options: \n1. List All Books \n2. Exit \nEnter Choice: ");
    }

    private void getAllBooks() {
        try {
            // We can define another bean to access the LibrarySessionBeanRemote
            ManageBookBeanRemote libBean2 = (ManageBookBeanRemote) ctx.lookup(getJNDI());
            List<Books> booksList = libBean2.getListBook();

            // Print all books
            System.out.println("\n===============================");
            System.out.println("Listing Books in TDTU Bookstore");
            System.out.println("===============================");
            for (int i = 0; i < booksList.size(); i++) {
                System.out.println(i + "\t" + booksList.get(i));
            }
            System.out.println("");

        } catch (NamingException ex) {
            System.err.println(ex.toString());
        }
    }

    public void testStatelessEJB() {
        try {
            // Scanner definition
            Scanner sc = new Scanner(System.in);

            // Lookup the LibrarySessionBeanRemote
            ManageBookBeanRemote libBean = (ManageBookBeanRemote) ctx.lookup(getJNDI());
            int choice = 0;
            while (choice != 3) {
                this.showGUI();
                if (choice == 1) {
                    // Print all books
                    getAllBooks();
                } else {
                    // Exit
                    break;
                }
            }
            sc.close();
        } catch (NamingException ex) {
            System.err.println(ex.toString());
        }
    }
}
