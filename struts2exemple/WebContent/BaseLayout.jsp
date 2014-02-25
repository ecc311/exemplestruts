
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>

<style type="text/css">
h2 { color: black;font-family:Verdana; }
p  { color: black;font-family: Verdana; }
a  {color: black; font-family: Verdana;}
}
</style>

<body>
<table bgcolor="FFFFFF" border="1" cellpadding="2" cellspacing="2" align="center" class="tabla">
    <tr >
        <td  height="30" colspan="2" align="center"><tiles:insertAttribute name="header" />
        </td>
    </tr>
    <tr>
        <td  height="250" align="center"><tiles:insertAttribute name="menu" /></td>
        <td  width="350" align="center"><tiles:insertAttribute name="body" /></td>
    </tr>
    <tr>
        <td  height="30" colspan="2" align="right"><tiles:insertAttribute name="footer"  />
        </td>
    </tr>
</table>
</body>
</html>