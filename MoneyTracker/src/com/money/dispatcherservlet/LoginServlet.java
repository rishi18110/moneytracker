package com.money.dispatcherservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
		out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\"/>");
		out.println("<title>Money Tacker </title>");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"); 
		out.println("<meta name=\"description\" content=\"Login and Registration Form with HTML5 and CSS3\" />");
		out.println("<meta name=\"keywords\" content=\"html5, css3, form, switch, animation, :target, pseudo-class\" />");
		out.println("<meta name=\"author\" content=\"Codrops\" />");
		out.println("<link rel=\"shortcut icon\" href=\"../favicon.ico\">"); 
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/demo.css\" />");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/animate-cu	stom.css\" />");
		out.println("</head>");
		
out.println("<body>");

out.println("<div class=\"container\">");
out.println("<header>");
out.println("<h1>Money Tracker</h1>");
     out.println("</header>");
	out.println("<section>");				
 out.println("<div id=\"container_demo\">");
         
        	 out.println(" <a class=\"hiddenanchor\" id=\"toregister\"></a>");
         out.println(" <a class=\"hiddenanchor\" id=\"tologin\"></a>");
         out.println("<div id=\"wrapper\">");
         out.println("<div id=\"login\" class=\"animate form\">");
             out.println(" <form  action=\"/MoneyTracker/LoginForm\" method=\"post\">"); 
                 out.println("<h1>Log in</h1>"); 
                     out.println("<p>"); 
                     out.println("<label for=\"email\" class=\"email\" data-icon=\"u\" > Your email or username </label>");
                         out.println("<input id=\"username\" name=\"email\" required=\"required\" type=\"email\" placeholder=\"myusername or mymail@mail.com\"/>");
                         out.println("</p>");
                     out.println("<p>"); 
                     out.println("<label for=\"password\" class=\"youpasswd\" data-icon=\"p\"> Your password </label>");
                         out.println("<input id=\"password\" name=\"password\" required=\"required\" type=\"password\" placeholder=\"eg. X8df!90EO\" />"); 
                         out.println("</p>");
                     out.println("<p class=\"keeplogin\">"); 
                     out.println("<input type=\"checkbox\" name=\"loginkeeping\" id=\"loginkeeping\" value=\"loginkeeping\" />"); 
							out.println("<label for=\"loginkeeping\">Keep me logged in</label>");
							out.println("</p>");
						out.println(" <p class=\"login button\">"); 
                     out.println("<input type=\"submit\" value=\"Login\" />"); 
                         out.println("</p>");
						out.println(" <p class=\"change_link\">");
                     out.println("Not a member yet ?");
									out.println("<a href=\"#toregister\" class=\"to_register\">Join us</a>");
							out.println("</p>");
						out.println("</form>");
                 out.println("</div>");

             out.println("<div id=\"register\" class=\"animate form\">");
             out.println("<form  action=\"/MoneyTracker/RegistrationServlet\" method=\"post\" autocomplete=\"on\">");
                 out.println("<h1> Sign up </h1> ");
                     
                 
               
                 
                 
                 out.println("<p>"); 
                 out.println("<label for=\"name\" class=\"youname \" data-icon=\"e\" > Your name </label>");
                     out.println("<input id=\"name\" name=\"name\" required=\"required\" type=\"text\" placeholder=\"enter your name \"/>"); 
                     out.println("</p>");
                            
                      
                 
                     out.println("<p>"); 
                     out.println("<label for=\"emailsignup\" class=\"youmail\" data-icon=\"e\" > Your email</label>");
                         out.println("<input id=\"emailsignup\" name=\"email\" required=\"required\" type=\"email\" placeholder=\"mysupermail@mail.com\"/>"); 
                         out.println("</p>");
                         
                         
                         out.println("<p> ");
                         out.println("<label for=\"username\" class=\"uname\" data-icon=\"u\">Your username</label>");
                         out.println(" <input id=\"usernamesignup\" name=\"username\" required=\"required\" type=\"text\"placeholder=\"mysuperusername690\" />");
                         out.println(" </p>");
                         out.println("<p>"); 
                         out.println("<label for=\"Address\" class=\"youadd\" data-icon=\"e\" >Address</label>");
                             out.println("<input id=\"Address\" name=\"address\" required=\"required\" type=\"text\" placeholder=\"enter your address\"/>"); 
                             out.println("</p>");
                             
                             out.println("<p>"); 
                             out.println("<label for=\"Mobile\" class=\"youmobile\" data-icon=\"e\" > Mobile </label>");
                                 out.println("<input id=\"mobile\" name=\"mobile\" required=\"required\" type=\"number\" placeholder=\"+91-8668876876\"/>"); 
                                 out.println("</p>");
                         
                     out.println("<p>"); 
                     out.println("<label for=\"passwordsignup\" class=\"youpasswd\" data-icon=\"p\">Your password </label>");
                         out.println("<input id=\"passwordsignup\" name=\"password\" required=\"required\" type=\"password\" placeholder=\"eg. X8df!90EO\"/>");
                         out.println("</p>");
                         
                     out.println(" <p> ");
                     out.println("<label for=\"passwordsignup_confirm\" class=\"youpasswd\" data-icon=\"p\">Please confirm your password </label>");
                         out.println("<input id=\"passwordsignup_confirm\" name=\"passwordsignup_confirm\" required=\"required\" type=\"password\" placeholder=\"eg. X8df!90EO\"/>");
                         out.println(" </p>");
                     out.println("<p class=\"signin button\">"); 
                     out.println("<input type=\"submit\" value=\"Sign up\"/>"); 
							out.println("</p>");
						out.println("<p class=\"change_link\"> "); 
                     out.println("Already a member ?");
									out.println("<a href=\"#tologin\" class=\"to_register\"> Go and log in </a>");
							out.println("</p>");
out.println("</form>");
 out.println(" </div>");
out.println("</div>");
 out.println("</div> "); 
 out.println("</section>");
 
 out.println("</div>");

out.println("<div class=\"copyright\">");
out.println("<footer>");
out.println("<p>&copy; Untitled. All rights reserved. | Photos by <a href=\"#\">Razor</a> | Design by <a href=\"#\" rel=\"nofollow\">Razor</a>.</p>");
out.println("</footer>");
out.println("</div>");

out.println("</body>");
                  
out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
