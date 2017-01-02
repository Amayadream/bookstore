<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>叮叮书城</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
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
        <%--<div class="right menu">--%>
            <%--<div class="item">--%>
                <%--<div class="ui action left icon input">--%>
                    <%--<i class="search icon"></i>--%>
                    <%--<input type="text" placeholder="Search">--%>
                    <%--<button class="ui button">Submit</button>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    </div>

    <div class="ui grid">
        <div class="three column row">
            <c:forEach items="${hot}" var="item" begin="0" end="2">
                <div class="column">
                    <div class="ui items">
                        <div class="item">
                            <div class="image">
                                <a href="${ctx}/book${item.bookUrl}" target="_blank"><img src="${item.bookImage}"  alt="${item.bookName}" style="width: 175px; height: 188px"></a>
                            </div>
                            <div class="content">
                                <a class="header" href="${ctx}/book${item.bookUrl}" target="_blank">${item.bookName}</a>
                                <div class="meta">
                                    <span>${item.author}</span>
                                </div>
                                <div class="description">
                                    <p>${item.description}</p>
                                </div>
                                <div class="extra">Additional Details </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="three column row">
            <c:forEach items="${hot}" var="item" begin="3" end="5">
                <div class="column">
                    <div class="ui items">
                        <div class="item">
                            <div class="image">
                                <a href="${ctx}/book${item.bookUrl}" target="_blank"><img src="${item.bookImage}"  alt="${item.bookName}" style="width: 175px; height: 188px"></a>
                            </div>
                            <div class="content">
                                <a class="header" href="${ctx}/book${item.bookUrl}" target="_blank">${item.bookName}</a>
                                <div class="meta">
                                    <span>${item.author}</span>
                                </div>
                                <div class="description">
                                    <p>${item.description}</p>
                                </div>
                                <div class="extra">Additional Details </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="ten wide column">
            <table class="ui single line table">
                <c:forEach items="${latest}" var="item">
                    <tr>
                        <td>${item.s1}</td>
                        <td><a href="${ctx}/book${item.bookUrl}" target="_blank">${item.s2}</a></td>
                        <td><a href="${ctx}/book${item.latestUrl}" target="_blank">${item.s3}</a></td>
                        <td>${item.s4}</td>
                        <td>${item.s5}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="six wide column">
            <table class="ui single line table">
                <c:forEach items="${good}" var="item">
                    <tr>
                        <td>${item.s1}</td>
                        <td><a href="${ctx}/book${item.bookUrl}" target="_blank">${item.s2}</a></td>
                        <td>${item.s5}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
