import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.concurrent.ThreadLocalRandom;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendEmail {

	private static String sender="officehoursmanagement@gmail.com";
	private static String password="office12345hours";
	
	
	public static int generate_password()
	{
		Random rand = new Random(); 
        int rand_password = rand.nextInt(10000);
        return rand_password;
	}
	
	public static void send_student_verification(String reciever) throws Exception 
    {
		DBConnection database=new DBConnection();
		 int code=generate_password();
	    // int id=database.get_student_id_email(reciever);
		  database.add_student_password(code, reciever);
		
      Properties properties=new Properties();
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.starttls.enable","true");
      properties.put("mail.smtp.host","smtp.gmail.com");
      properties.put("mail.smtp.port", "587");
      properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
      properties.put("mail.smtp.host", "smtp.gmail.com");    
      properties.put("mail.smtp.socketFactory.port", "587");       
      properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
	  //String reciever=database.get_email(id);
	  
	 
	  
      Session session = Session.getDefaultInstance(properties,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(sender,password);  
         }    
        });
        MimeMessage message=new MimeMessage(session);
      try {
          message.setFrom(new InternetAddress(sender));
          message.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(reciever));
          message.setSubject("Login password");
          message.setText("Thank you for using our website.\n Use this password to login :"+code);
      } catch (Exception ex) {
          //Logger.getLogger(player.class.getName()).log(Level.SEVERE, null, ex);
      }
        javax.mail.Transport.send(message);
      System.out.println("We sent a code to your mail,please check your mail...");   
    }
	
	public static void send_member_verification(String reciever) throws Exception 
    {
		DBConnection database=new DBConnection();
		 int code=generate_password();
		  database.add_member_password(code, reciever);
		
      Properties properties=new Properties();
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.starttls.enable","true");
      properties.put("mail.smtp.host","smtp.gmail.com");
      properties.put("mail.smtp.port", "587");
      properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
      properties.put("mail.smtp.host", "smtp.gmail.com");    
      properties.put("mail.smtp.socketFactory.port", "587");       
      properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
	  
	  
      Session session = Session.getDefaultInstance(properties,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(sender,password);  
         }    
        });
        MimeMessage message=new MimeMessage(session);
      try {
          message.setFrom(new InternetAddress(sender));
          message.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(reciever));
          message.setSubject("Login password");
          message.setText("Thank you for using our website.\n Use this password to login :"+code);
      } catch (Exception ex) {
          //Logger.getLogger(player.class.getName()).log(Level.SEVERE, null, ex);
      }
        javax.mail.Transport.send(message);
      System.out.println("We sent a code to your mail,please check your mail...");   
    }
	
	
	
	
	public static void send_student_meeting_confirmation(int appointment_id) throws Exception 
    {
		DBConnection database=new DBConnection();
       Appointment currentAppointment=database.get_appointment(appointment_id);
       StaffMember member=database.get_staff_member(currentAppointment.getMemberID());
     
       Properties properties=new Properties();
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.starttls.enable","true");
      properties.put("mail.smtp.host","smtp.gmail.com");
      properties.put("mail.smtp.port", "587");
      properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
      properties.put("mail.smtp.host", "smtp.gmail.com");    
      properties.put("mail.smtp.socketFactory.port", "587");       
      properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
       
	  String reciever=database.get_email(currentAppointment.getStudentID());
	  
      Session session = Session.getDefaultInstance(properties,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(sender,password);  
         }    
        });
        MimeMessage message=new MimeMessage(session);
      try {
          message.setFrom(new InternetAddress(sender));
          message.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(reciever));
          message.setSubject("Meeting notification");
          message.setText("Don`t forget that you have meeting today .\n meeting details :\n"+
                  "\t Meeting Subject : "+currentAppointment.getAppointmentSubject()
        		  +"\n\t Meeting Date:"+currentAppointment.getAppointmentDate()+
        		  "\n \t Meeting Slot :"+currentAppointment.getAppointmentSlot()
        		  +"\n \t Meeting Staff member : "+member.getMemberRole()+" "+member.getMemberName());
      } catch (Exception ex) {
          //Logger.getLogger(player.class.getName()).log(Level.SEVERE, null, ex);
      }
        javax.mail.Transport.send(message);  
    }
    
	
	
	public static void send_staff_member_meeting_confirmation(int appointment_id) throws Exception 
    {
		DBConnection database=new DBConnection();
        Appointment currentAppointment=database.get_appointment(appointment_id);
        StaffMember member=database.get_staff_member(currentAppointment.getMemberID());
        Student student=database.get_student(currentAppointment.getStudentID());
      Properties properties=new Properties();
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.starttls.enable","true");
      properties.put("mail.smtp.host","smtp.gmail.com");
      properties.put("mail.smtp.port", "587");
      properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
      properties.put("mail.smtp.host", "smtp.gmail.com");    
      properties.put("mail.smtp.socketFactory.port", "587");       
      properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
       
	  String reciever=member.getMemberEmail();
	  
      Session session = Session.getDefaultInstance(properties,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(sender,password);  
         }    
        });
        MimeMessage message=new MimeMessage(session);
      try {
          message.setFrom(new InternetAddress(sender));
          message.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(reciever));
          message.setSubject("Meeting notification");
          message.setText("Don`t forget that you have meeting today .\n meeting details :\n"+
                  "\t Meeting Subject : "+currentAppointment.getAppointmentSubject()
        		  +"\n\t Meeting Date:"+currentAppointment.getAppointmentDate()+
        		  "\n \t Meeting Slot :"+currentAppointment.getAppointmentSlot()
        		  +"\n \t Meeting With student : "+student.getStudentName()+" with ID : "+student.getStudentID());
      } catch (Exception ex) {
          //Logger.getLogger(player.class.getName()).log(Level.SEVERE, null, ex);
      }
        javax.mail.Transport.send(message);  
    }
	
	
	public static void send_student_appointment_cancellation(int appointment_id) throws Exception 
    {
		DBConnection database=new DBConnection();
        Appointment currentAppointment=database.get_appointment(appointment_id);
        StaffMember member=database.get_staff_member(currentAppointment.getMemberID());
        Student student=database.get_student(currentAppointment.getStudentID());
      Properties properties=new Properties();
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.starttls.enable","true");
      properties.put("mail.smtp.host","smtp.gmail.com");
      properties.put("mail.smtp.port", "587");
      properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
      properties.put("mail.smtp.host", "smtp.gmail.com");    
      properties.put("mail.smtp.socketFactory.port", "587");       
      properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
       
	  String reciever=student.getStudentEmail();
	  
      Session session = Session.getDefaultInstance(properties,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(sender,password);  
         }    
        });
        MimeMessage message=new MimeMessage(session);
      try {
          message.setFrom(new InternetAddress(sender));
          message.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(reciever));
          message.setSubject("Meeting Cancellation");
          message.setText("Meeting with the following data has been cancelled.."+
        		  "\n\t Meeting id = "+currentAppointment.getMemberID()+
                  "\n\t Meeting Subject : "+currentAppointment.getAppointmentSubject()
        		  +"\n\t Meeting Date:"+currentAppointment.getAppointmentDate()+
        		  "\n \t Meeting Slot :"+currentAppointment.getAppointmentSlot()
        		  +"\n \t Meeting With "+member.getMemberRole()+" : "+member.getMemberName());
      } catch (Exception ex) {
          //Logger.getLogger(player.class.getName()).log(Level.SEVERE, null, ex);
      }
        javax.mail.Transport.send(message);  
    }
	

	public static void send_member_appointment_cancellation(int appointment_id) throws Exception 
    {
		DBConnection database=new DBConnection();
        Appointment currentAppointment=database.get_appointment(appointment_id);
        StaffMember member=database.get_staff_member(currentAppointment.getMemberID());
        Student student=database.get_student(currentAppointment.getStudentID());
      Properties properties=new Properties();
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.starttls.enable","true");
      properties.put("mail.smtp.host","smtp.gmail.com");
      properties.put("mail.smtp.port", "587");
      properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
      properties.put("mail.smtp.host", "smtp.gmail.com");    
      properties.put("mail.smtp.socketFactory.port", "587");       
      properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
       
	  String reciever=member.getMemberEmail();
	  
      Session session = Session.getDefaultInstance(properties,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(sender,password);  
         }    
        });
        MimeMessage message=new MimeMessage(session);
      try {
          message.setFrom(new InternetAddress(sender));
          message.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(reciever));
          message.setSubject("Meeting Cancellation");
          message.setText("Meeting with the following data has been cancelled.."+
        		  "\n\t Meeting id = "+currentAppointment.getMemberID()+
                  "\n\t Meeting Subject : "+currentAppointment.getAppointmentSubject()
        		  +"\n\t Meeting Date:"+currentAppointment.getAppointmentDate()+
        		  "\n \t Meeting Slot :"+currentAppointment.getAppointmentSlot()
        		  +"\n \t Meeting With student : "+student.getStudentName()+" with ID : "+student.getStudentID());
      } catch (Exception ex) {
          //Logger.getLogger(player.class.getName()).log(Level.SEVERE, null, ex);
      }
        javax.mail.Transport.send(message);  
    }
	
	
	
	
	
	/**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //send_verification(1);
    	//send_student_meeting_confirmation(2);
    	//send_staff_member_meeting_confirmation(2);
    	
    }
    

}
