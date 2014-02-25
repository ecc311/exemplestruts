<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
    <title>Welcome</title>
    <sx:head />
</head>
<body>
    <h2>Carregar Client</h2>
     
    <s:form action="customer.load" method="post" validate="true">
    Customer:
    <sx:autocompleter size="1" list="countries" name="namec" ></sx:autocompleter>
    
	<s:submit value="Carregar" align="center" />
	</s:form>
</body>
</html>