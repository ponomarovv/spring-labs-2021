<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="row">
        <form action="" method="post" class="s-vflex-start">
            <div class="s-hflex">
                <input type="hidden" name="id" value="<c:out value="${sport.id}" />" />
                <div class="input-field" style="margin-bottom: 0px;">
                    <input id="name" type="text" name="name" class="validate" style="margin: 0px;" value="<c:out value="${sport.name}" />">
                    <label for="name">Sport Name</label>
                </div>
                <div class="s-vflex-end px10">
                    <button type="submit" class="waves-effect waves-light btn">Confirm</button>
                </div>
            </div>
            <ul>
                <c:forEach items="${errors}" var="error">
                    <li class="red-text"><c:out value="${error}" /></li>
                </c:forEach>
            </ul>
        </form>
    </div>
</div>