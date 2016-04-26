<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head><title>error page</title></head>
<body>
    <h3>session 过期，请重新登录</h3>
    <s:property value="exception"/>
</body>
<script>
setTimeout("window.location.href='/BridgeServer/'",2000);
</script>
</html>