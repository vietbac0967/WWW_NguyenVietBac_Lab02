package com.example.demojpa.resources;

import com.example.demojpa.models.Employee;
import com.example.demojpa.services.EmployeeService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/employees")
public class EmployeeResources {
    private final EmployeeService employeeService;

    public EmployeeResources() {
        employeeService = new EmployeeService();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getEmp(@PathParam("id") long eid) {
        Optional<Employee> empOpt = employeeService.getEmployeeById(eid);
        if (empOpt.isPresent()) {
            return Response.ok(empOpt.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    public Response getAll() {
        //paging if possible
        List<Employee> lst = employeeService.getAll();
        return Response.ok(lst).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Employee employee) {
        //ResponseEntity
        employeeService.insertEmp(employee);
        return Response.ok(employee).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        if (employeeService.deleteEmp(id))
            return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }


}