<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="wp" uri="/aps-core"%>
<%@ taglib prefix="jptoucantoco" uri="/jptoucantoco-core"%>

<jptoucantoco:connector var="connector" />
<article>
<c:choose>
	<c:when test="${not empty connector}">
	<ul>
		<li>
			<wp:i18n key="jptoucantoco_CONNECTOR_NAME" />: <c:out value="${connector.name}" /><br />
		</li>
	</ul>
	</c:when>
	<c:otherwise>
	<div class="alert alert-error">
		<p><wp:i18n key="jptoucantoco_CONNECTOR_NOT_FOUND" /></p>
	</div>
	</c:otherwise>
</c:choose>
</article>