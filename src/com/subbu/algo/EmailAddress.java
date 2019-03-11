/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
Every email consists of a local name and a domain name, separated by the @ sign.

For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.

Besides lowercase letters, these emails may contain '.'s or '+'s.

If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)

If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)

It is possible to use both of these rules at the same time.

Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?  
 */
package com.subbu.algo;

import java.util.HashMap;

/**
 *
 * @author saarumug
 */
public class EmailAddress {

    public int numUniqueEmails(String[] emails) {
        int noOfRecipients = 0;
        
        HashMap rcpts = new HashMap(); 
        
        for (int i=0; i < emails.length; i++) {
            
            String currEmail = emails[i];
            //String localName = currEmail.substring(0, currEmail.lastIndexOf("@"));
            String domainName = currEmail.substring(currEmail.lastIndexOf("@"),currEmail.length());
            System.out.println(currEmail);
            
            String rcptName = currEmail.substring(0,currEmail.indexOf("+"));
            
            String[] parts = rcptName.split("\\.",-1);
            StringBuffer emailNoDots = new StringBuffer();
            
            for (int j = 0; j < parts.length; j++) {
                emailNoDots.append(parts[j]);
            }
            
            String uniqueEmail = emailNoDots+domainName;
            
            System.out.println(">>"+uniqueEmail);
            
            if (rcpts.containsKey(uniqueEmail)) {
                noOfRecipients++;
            } else {
                rcpts.put(uniqueEmail, uniqueEmail);
            }
        }
        return rcpts.size();
    }
    
    public static void main(String[] args) {
        EmailAddress e = new EmailAddress();
        String [] emails = {"test.email+alex@leetcode.com",
                           "test.e.mail+bob.cathy@leetcode.com",
                           "testemail+david@lee.tcode.com"};
        System.out.println("# Emails:" + e.numUniqueEmails(emails));
    }
    
}
