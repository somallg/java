<%@include file="/libs/foundation/global.jsp"%><%
%><body>
<div id="CQ">
<cq:include path="topnav" resourceType="mywebsite/components/topnav"/>
<div class="content">
<cq:include script="left.jsp" />
<cq:include script="center.jsp" />
<cq:include script="right.jsp" />
</div>
<div class="footer">
<cq:include path="toolbar" resourceType="mywebsite/components/toolbar" />
</div>
</div>
</body>