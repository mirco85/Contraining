package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.CategoryDTO;

import it.contrader.service.CategoryService;


public class CategoryServlet extends HttpServlet {
	
	
	private   static final long serialVersionUID = 1L;
	
	
	
	public CategoryServlet() {
	}
	

	public void updateList(HttpServletRequest request) {
		CategoryService service = new CategoryService();
		List<CategoryDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService service = new CategoryService();
		String mode = request.getParameter("mode");
		CategoryDTO dto;
		int id;
		boolean ans;
		
		
		switch (mode.toUpperCase()) {

		case "CATEGORYLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/category/category.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/category/readcategory.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/category/updatecategory.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String argument = request.getParameter("argument").toString();
			
			dto = new CategoryDTO (argument);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/category/category.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			argument= request.getParameter("argument");
			
			id = Integer.parseInt(request.getParameter("id"));
			dto = new CategoryDTO (id,argument);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/category/category.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/user/category.jsp").forward(request, response);
			break;
		}
	}
	
}
