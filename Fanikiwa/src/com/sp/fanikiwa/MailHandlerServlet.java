package com.sp.fanikiwa;

import java.io.IOException; 
import java.util.Properties; 

import javax.mail.MessagingException;
import javax.mail.Session; 
import javax.mail.internet.MimeMessage; 
import javax.servlet.http.*; 

import com.sp.fanikiwa.entity.Informdb;

public class MailHandlerServlet extends HttpServlet { 
    @Override
    public void doPost(HttpServletRequest req, 
                       HttpServletResponse resp) 
            throws IOException { 
        Properties props = new Properties(); 
        Session session = Session.getDefaultInstance(props, null); 
        try {
			MimeMessage message = new MimeMessage(session, req.getInputStream());
			        //save the mail
			Informdb mail = new Informdb();
			mail.setAddressFrom(message.getSender().toString());
			mail.setSubject(message.getSubject());
			mail.setBody(message.toString());
			mail.setMessageDate(message.getReceivedDate());
			mail.setStatus("New");
			
//			InformDbEndpoint idep = new InformDbEndpoint();
//			idep.insertInformDb(mail);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}