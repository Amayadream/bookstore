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
    <style>
        html, body, ul, ol, li, p, h1, h2, h3, h4, h5, h6, table, td, th, img, div, dl, dt, dd, input, select, form, fieldset {
            margin: auto;
            padding: 0;
        }
        #list dt {
            background: none repeat scroll 0 0 #C3DFEA;
            display: inline;
            float: left;
            font-size: 14px;
            line-height: 28px;
            overflow: hidden;
            text-align: center;
            vertical-align: middle;
            width: 98%;
            margin: auto auto 5px;
            padding: 5px 10px;
        }
        #list dd {
            border-bottom: 1px dashed #CCC;
            display: inline;
            float: left;
            height: 25px;
            line-height: 200%;
            margin-bottom: 5px;
            overflow: hidden;
            text-align: left;
            text-indent: 10px;
            vertical-align: middle;
            width: 32%;
        }
    </style>
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

    <div class="ui items">
        <div class="item">
            <div class="image">
                <img src="${info.bookImage}">
            </div>
            <div class="content">
                <a class="header">${info.bookName}</a>
                <div class="meta">
                    <span>${info.author}</span>
                </div>
                <div class="description">
                    <p>最后更新：${info.latestTime}</p>
                    <p>最新章节：<a href="${ctx}/book/${info.latestUrl}" target="_blank">${info.latestChapter}</a></p>
                    <hr>
                    ${info.description}
                </div>
            </div>
        </div>
    </div>
    <div id="list">
        ${info.list}
    </div>
</div>
</body>
</html>
