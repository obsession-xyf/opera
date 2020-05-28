<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!-- start of sidebar -->
                                        <aside class="span4 page-sidebar">

                                                <section class="widget">
                                                        <div class="support-widget">
                                                                <h3 class="title">戏曲网</h3>
                                                                <p class="intro">欢迎使用戏曲网</p>
                                                        </div>
                                                </section>
												<section class="widget">
                                                        <div class="quick-links-widget">
                                                                <h3 class="title">戏曲推荐</h3>
                                                                <ul id="menu-quick-links" class="menu clearfix">
                                                                		<c:forEach items="${rightBkList }" var="rightBkLists">
                                                                			<li><a href="wdxxShow.html?id=${rightBkLists.wdxxId }&bkId=1">${rightBkLists.title }</a></li>
                                                                		</c:forEach>
                                                                </ul>
                                                        </div>
                                                </section>

                                        </aside>