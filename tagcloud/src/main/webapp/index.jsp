<%@ page import="org.mcavallo.opencloud.Tag" %>
<%@ page import="edu.tuhh.summarizer.tagcloud.TagCloud" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>A Tag Cloud Example</title>
</head>
<body>
  <div>
<%--    <% TagCloud tg = new TagCloud(); %>
    <% for (Tag tag : tg.getTagCloud().tags()) { %>
    <a href="<%= tag.getLink() %>" style="font-size:<%= tag.getWeightInt() %>px;"><%= tag.getName() %></a>
    <% } %>--%>
      Hello World
  </div>

</body>
</html>
