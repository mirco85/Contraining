package it.contrader.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		UserService service = new UserService();
		List<UserDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	private boolean isRegisterValid(UserDTO userToRegister) {
		if(userToRegister.getUsername().length() == 0)
			return false;
		if(userToRegister.getPassword().length() == 0)
			return false;
		if(userToRegister.getFirstname().length() == 0)
			return false;
		if(userToRegister.getLastname().length() == 0)
			return false;
		if(userToRegister.getDatanascita().length() == 0)
			return false;
		if(userToRegister.getCodicefiscale().length() == 0)
			return false;
		
		return true;
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = new UserService();
		String mode = request.getParameter("mode");
		UserDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {
		
		case "REGISTERUSER":
			//updateList(request);
			getServletContext().getRequestDispatcher("/user/registeruser.jsp").forward(request, response);
			break;
			
		case "USERLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/user/readuser.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/user/updateuser.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String datanascita = request.getParameter("datanascita").toString();
			String firstname = request.getParameter("firstname").toString();
			String lastname = request.getParameter("lastname").toString();
			String username = request.getParameter("username").toString();
			String password = request.getParameter("password").toString();
			String usertype = request.getParameter("usertype").toString();
			String codicefiscale = request.getParameter("codicefiscale").toString();
			dto = new UserDTO (datanascita,firstname,lastname,username,password,usertype,codicefiscale);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;
		case "REGISTER":
			datanascita = request.getParameter("datanascita").toString();
			firstname = request.getParameter("firstname").toString();
			lastname = request.getParameter("lastname").toString();
			username = request.getParameter("username").toString();
			password = request.getParameter("password").toString();
			usertype = "USER";
			codicefiscale = request.getParameter("codicefiscale").toString();
			dto = new UserDTO (datanascita,firstname,lastname,username,password,usertype,codicefiscale);
			if(!isRegisterValid(dto)) {
				request.setAttribute("registerValid", false);
				getServletContext().getRequestDispatcher("/user/registeruser.jsp").forward(request, response);
			} else {
				ans = service.insert(dto);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
			break;
			
		case "UPDATE":
			datanascita = request.getParameter("datanascita");
			firstname = request.getParameter("firstname");
			lastname = request.getParameter("lastname");
			username = request.getParameter("username");
			password = request.getParameter("password");
			usertype = request.getParameter("usertype");
			codicefiscale = request.getParameter("codicefiscale");
			id = Integer.parseInt(request.getParameter("id"));
			dto = new UserDTO (id,datanascita,firstname,lastname,username,password,usertype,codicefiscale);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;
		}
	}
}