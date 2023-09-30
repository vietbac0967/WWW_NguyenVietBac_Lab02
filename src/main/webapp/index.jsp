<%@ page import="java.util.List" %>
<%@ page import="backend.models.Product" %>
<%@ page import="backend.services.ProductPriceService" %>
<%@ page import="backend.models.ProductImage" %>
<%@ page import="backend.models.ProductPrice" %>
<%@ page import="backend.services.ProductService" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <%@include file="cdn.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<h1 class="text-center">List products</h1>
<div class="container">
    <table class="table container table-bordered table-responsive">
        <thead class="table-dark text-center">
        <tr>
            <th>Product name</th>
            <th>Manufacturer Name</th>
            <th>Unit</th>
            <th>Price</th>
            <th>Add to cart</th>
        </tr>
        </thead>
        <tbody class="text-center">
        <%
            ProductService productService = new ProductService();
            List<Product> products = productService.getProducts();
            for(Product product : products) {
        %>
        <tr>
            <td><%= product.getName() %></td>
            <td><%= product.getManufacturer() %></td>
            <td><%= product.getUnit() %></td>
            <td>
                <select class="form-control">
                <%
                    ProductPriceService productPriceService = new ProductPriceService();
                    List<ProductPrice> productPrices =  productPriceService.getAll(product.getId());
                    for(ProductPrice productPrice : productPrices){
              %>
                <option><%= productPrice.getPrice()%></option>
              <%
                    }
                %>
                </select>
            </td>
            <td class="d-flex justify-content-center">
                <button class="btn btn-primary align-items-center">
                    <i class="fa-solid fa-cart-shopping"></i>
                </button>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
