package com.personal.money;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FooterUp
 */
@WebServlet("/FooterUp")
public class FooterUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FooterUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		
		out.println("<div id=\"footer-wrapper\">");
		out.println("<div id=\"footer\" class=\"container\">");
		out.println("<div id=\"box1\">");
		out.println("<div class=\"title\">");
		out.println("<h2>Latest Post</h2>");
		out.println("</div>");
		out.println("<ul class=\"style1\">");
		out.println("<li><a href=\"#\">Semper mod quis eget mi dolore</a></li>");
		out.println("<li><a href=\"#\">Quam turpis feugiat sit dolor</a></li>");
		out.println("<li><a href=\"#\">Amet ornare in hendrerit in lectus</a></li>");
		out.println("<li><a href=\"#\">Consequat etiam lorem phasellus</a></li>");
		out.println("<li><a href=\"#\">Amet turpis, feugiat et sit amet</a></li>");
		out.println("<li><a href=\"#\">Semper mod quisturpis nisi</a></li>");
		out.println("</ul>");
		out.println("</div>");
		out.println("<div id=\"box2\">");
		out.println("<div class=\"title\">");
		out.println("<h2>Popular Links</h2>");
		out.println("</div>");
		out.println("<ul class=\"style1\">");
		out.println("<li><a href=\"#\">Semper mod quis eget mi dolore</a></li>");
		out.println("<li><a href=\"#\">Quam turpis feugiat sit dolor</a></li>");
		out.println("<li><a href=\"#\">Amet ornare in hendrerit in lectus</a></li>");
		out.println("<li><a href=\"#\">Consequat etiam lorem phasellus</a></li>");
		out.println("<li><a href=\"#\">Amet turpis, feugiat et sit amet</a></li>");
		out.println("<li><a href=\"#\">Semper mod quisturpis nisi</a></li>");
		out.println("</ul>");
		out.println("</div>");
		out.println("<div id=\"box3\">");
		out.println("<div class=\"title\">");
		out.println("<h2>Follow Us</h2>");
		out.println("</div>");
		out.println("<p>Proin eu wisi suscipit nulla suscipit interdum. Aenean lectus lorem, imperdiet magna.</p>");
		out.println("<ul class=\"contact\">");
		out.println("<li><a href=\"#\" class=\"icon icon-twitter\"><span>Twitter</span></a></li>");
		out.println("<li><a href=\"#\" class=\"icon icon-facebook\"><span>Facebook</span></a></li>");
		out.println("<li><a href=\"#\" class=\"icon icon-dribbble\"><span>Dribbble</span></a></li>");
		out.println("<li><a href=\"#\" class=\"icon icon-tumblr\"><span>Tumblr</span></a></li>");
		out.println("<li><a href=\"#\" class=\"icon icon-rss\"><span>Pinterest</span></a></li>");
		out.println("</ul>");
		out.println("<a href=\"#\" class=\"icon icon-arrow-right button\">Read More</a> </div>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		
		
	}
	

}
