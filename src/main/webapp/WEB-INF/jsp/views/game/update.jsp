<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="row">
        <div class="s-vflex">
            <c:choose>
                <c:when test="${game == null}">
                    <c:set var="gameUrl" value="/admin/games" />
                </c:when>
                <c:otherwise>
                    <c:set var="gameUrl" value="" />
                </c:otherwise>
            </c:choose>
            <form action="${gameUrl}" method="post" class="">
                <input type="hidden" name="id" value="<c:out value="${game == null ? 0 : game.id}" />" />
                <div class="input-field col s4">
                    <select value="<c:out value="${game == null ? '' : game.firstTeamId}" />" name="firstTeamId">
                        <c:forEach items="${teams}" var="team">
                            <option value="<c:out value="${team.id}" />"><c:out value="${team.name}" /></option>
                        </c:forEach>
                    </select>
                    <label>First Team</label>
                </div>
                <div class="input-field col s4">
                    <select value="<c:out value="${game == null ? '' : game.secondTeamId}" />" name="secondTeamId">
                        <c:forEach items="${teams}" var="team">
                            <option value="<c:out value="${team.id}" />"><c:out value="${team.name}" /></option>
                        </c:forEach>
                    </select>
                    <label>Second team</label>
                </div>
                <div class="input-field col s4">
                    <select value="<c:out value="${game == null ? '' : game.sportId}" />" name="sportId">
                        <c:forEach items="${sports}" var="sport">
                            <option value="<c:out value="${sport.id}" />"><c:out value="${sport.name}" /></option>
                        </c:forEach>
                    </select>
                    <label>Sport</label>
                </div>
                <div class="input-field col s4">
                    <input type="text" class="datepicker" name="date" value="<c:out value="${game == null ? '' : game.date}" />" />
                    <label>Date</label>
                </div>
                <div class="col s8">
                    <div class="s-hflex">
                        <div class="equal-flex">
                            <div class="input-field">
                                <input id="first-team-score" type="number" min="0" name="firstTeamScore" class="right-align validate" value="<c:out value="${game == null ? 0 : game.firstTeamScore}" />">
                                <label for="first-team-score">First team score</label>
                            </div>
                        </div>
                        <div class="my20 px20 fs30 s-vflex-end">:</div>
                        <div class="equal-flex">
                            <div class="input-field">
                                <input id="second-team-score" type="number" min="0" name="secondTeamScore" class="validate" value="<c:out value="${game == null ? 0 : game.secondTeamScore}" />">
                                <label for="second-team-score">Second team score</label>
                            </div>
                        </div>
                    </div>
                </div>
                <ul class="col s12">
                    <c:forEach items="${errors}" var="error" varStatus="status">
                        <li class="red-text">
                            <c:out value="${error}" />
                        </li>
                    </c:forEach>
                </ul>
                <div class="col s12 right-align">
                    <button type="submit" class="waves-effect waves-light btn">Confirm</button>
                </div>
            </form>
        </div>
    </div>
</div>