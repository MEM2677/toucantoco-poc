<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="wp" uri="/aps-core"%>
<%@ taglib prefix="jptoucantoco" uri="/jptoucantoco-core"%>

<jptoucantoco:connector var="tokenInfoVar" />
<article>
<c:choose>
	<c:when test="${not empty tokenInfoVar}">
		<wp:currentWidget param="config" configParam="debug" var="debugVar"/>
		<c:if test="${debugVar}">
			<ul>
				<li>
					<wp:i18n key="jptoucantoco_CONNECTOR_NAME" />:
					</br>
					<b><c:out value="${tokenInfoVar.user}" /></b>
					<br />
					<wp:i18n key="jptoucantoco_CONNECTOR_TOKEN" />:
					</br>
					<b><c:out value="${tokenInfoVar.token}" /></b>
					<br />
					<wp:i18n key="jptoucantoco_CONNECTOR_URL" />:
					</br>
					<b><c:out value="${tokenInfoVar.url}" /></b><br />
				</li>
			</ul>		
		</c:if>
		<iframe
			src="${tokenInfoVar.url}?token=${tokenInfoVar.token}&username=${tokenInfoVar.user}" width="1000" height="500">
		</iframe>
	</c:when>
	<c:otherwise>
		<div class="alert alert-error">
			<p><wp:i18n key="jptoucantoco_CONNECTOR_NOT_FOUND" /></p>
		</div>
	</c:otherwise>
</c:choose>
</article>