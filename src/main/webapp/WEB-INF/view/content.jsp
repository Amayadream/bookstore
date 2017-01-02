<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
    <title>叮叮书城</title>
    <jsp:include page="include/header.jsp"/>
</head>
<body>
<div class="ui container">
    <div class="ui menu menu">
        <div class="header item"><i class="icon book"></i>叮叮书城</div>
        <a class="item">首页</a>
        <a class="item" href="${ctx}/xuanhuanxiaoshuo">玄幻小说</a>
        <a class="item" href="${ctx}/xiuzhenxiaoshuo">修真小说</a>
        <a class="item" href="${ctx}/dushixiaoshuo">都市小说</a>
        <a class="item" href="${ctx}/lishixiaoshuo">历史小说</a>
        <a class="item" href="${ctx}/wangyouxiaoshuo">网游小说</a>
        <a class="item" href="${ctx}/kehuanxiaoshuo">科幻小说</a>
        <a class="item" href="${ctx}/nvpinxiaoshuo">女频小说</a>
        <a class="item">排行榜单</a>
        <a class="item" href="${ctx}/wanbenxiaoshuo">完本小说</a>
    </div>

    <div class="content">
        <div class="title" style="align-content: center; text-align: center">
            <h1>${info.title}</h1>
        </div>
        <div class="toolbar" style="align-content: center; text-align: center">
            <div class="ui buttons">
                <button class="ui labeled icon button"><i class="left chevron icon"></i> <a href="${ctx}/book/${info.list}/">上一章</a> </button>
                <button class="ui button"><i class="list icon"></i> <a href="${ctx}/book/${info.list}">章节列表</a> </button>
                <button class="ui right labeled icon button"><a href="${ctx}/book/${info.list}/${info.next}">下一章</a> <i class="right chevron icon"></i> </button>
            </div>
        </div>
        <div>
            ${info.content}
        </div>
        <div class="footer" style="align-content: center; text-align: center">
            <div class="ui buttons">
                <button class="ui labeled icon button"><i class="left chevron icon"></i> <a href="${ctx}/book/${info.list}/">上一章</a> </button>
                <button class="ui button"><i class="list icon"></i> <a href="${ctx}/book/${info.list}">章节列表</a> </button>
                <button class="ui right labeled icon button"><a href="${ctx}/book/${info.list}/${info.next}">下一章</a> <i class="right chevron icon"></i> </button>
            </div>
        </div>
    </div>

</div>
</body>
</html>
