package com.ndn.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ndn.core.ServiceFactory;
import com.ndn.model.Customer;
import com.ndn.service.ICustomerService;





@WebServlet(urlPatterns = "/customer/*")
public class CustomerServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICustomerService customerService = ServiceFactory.get(ICustomerService.class);
        String requestURI = req.getRequestURI();
        if ("/customer/list".equalsIgnoreCase(requestURI)) {
            req.setAttribute("customers", customerService.getCustomers());
            getServletContext().getRequestDispatcher("/pages/customerList.jsp").forward(req, resp);
            
        } else if (requestURI.contains("/customer/delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            System.out.println("delete customer id: " + id);
            customerService.deleteCustomerById(id);
            resp.sendRedirect(req.getContextPath() + "/customer/list");
            
        } else if (requestURI.contains("/customer/view")) {
            String id = req.getParameter("id");
            req.setAttribute("customer", customerService.getCustomerById(Integer.parseInt(id)));
            req.setAttribute("membership_level", customerService.getCustomerById(Integer.parseInt(id)).getMembership_level());
            req.setAttribute("ticket_free", customerService.getCustomerById(Integer.parseInt(id)).getTicket_free());
            getServletContext().getRequestDispatcher("/pages/customerDetail.jsp").forward(req, resp);     
        
        } else if (requestURI.contains("/customer/edit")) {
            String id = req.getParameter("id");
            req.setAttribute("customer", customerService.getCustomerById(Integer.parseInt(id)));
            getServletContext().getRequestDispatcher("/pages/customerEdit.jsp").forward(req, resp);  
            
        }  else if (requestURI.contains("/customer/search")) {
            String name = req.getParameter("kw_name");
            String gender = req.getParameter("kw_gender");
            String phone_number= req.getParameter("kw_phone");
            String membership_level = req.getParameter("kw_membership_level");
            req.setAttribute("customers", customerService.searchCustomer(name, gender, phone_number, membership_level));
            getServletContext().getRequestDispatcher("/pages/customerList.jsp").forward(req, resp);
        } 
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICustomerService customerService = ServiceFactory.get(ICustomerService.class);
        String requestURI = req.getRequestURI();
        System.out.println("POST RequestURI: " + req.getRequestURI());
        if ("/customer/add".equalsIgnoreCase(requestURI)) {
            String name = req.getParameter("name");
            String gender = req.getParameter("gender");
            String phone_number = req.getParameter("phone");
            String address = req.getParameter("address");
            String email = req.getParameter("email");
            if( name.isEmpty() || gender.isEmpty() || phone_number.isEmpty() ) {
                System.out.println("Customer data can not empty");
                resp.sendRedirect(req.getContextPath() + "/customer/list");
            }
            else {
                Customer customer = new Customer(name, gender, phone_number, address, email);
                customerService.addCustomer(customer);
                resp.sendRedirect(req.getContextPath() + "/customer/list");
            }       
        
        } else if (requestURI.contains("/customer/update")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String gender = req.getParameter("gender");
            String phone_number = req.getParameter("phone");
            String address = req.getParameter("address");
            String email = req.getParameter("email");  
            int point = Integer.parseInt(req.getParameter("point"));
            
            Customer customer = new Customer();
            customer.setId(id);
            customer.setName(name);
            customer.setGender(gender);
            customer.setPhone_number(phone_number);
            customer.setAddress(address);
            customer.setEmail(email);
            customer.setPoint(point);
            customerService.updateCustomer(customer);
            resp.sendRedirect(req.getContextPath() + "/customer/list");
            
        }          
    }
}
