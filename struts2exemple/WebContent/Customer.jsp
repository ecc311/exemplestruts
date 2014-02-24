<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Customer Form - Struts2 Demo</title>
</head>
 
<body>
<h2>Formulari Client</h2>
 
<s:form action="customer" method="post" validate="true">
    <s:textfield name="name" key="name" size="20" />
    <s:textfield name="age" key="age" size="20" />
    <s:textfield name="email" key="email" size="20" />
    <s:textfield name="telephone" key="telephone" size="20" />
    <s:submit method="addCustomer" value="add" key="label.add.customer" align="center" />
</s:form>
</body>
</html>