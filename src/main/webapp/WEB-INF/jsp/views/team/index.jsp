<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="row">
        <div class="col s12">
            <div class="s-hflex-end">
                <form action="" method="post" class="s-vflex-end">
                    <div class="s-hflex-end">
                        <div class="input-field " style="margin-bottom: 0px;">
                            <input id="name" type="text" name="name" class="validate" style="margin: 0px;" value="<c:out value="${team != null ? team.name : ''}" />" />
                            <label for="name">Team Name</label>
                        </div>
                        <div class="s-vflex-end pl10">
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
        <div class="col s12">
            <table class="striped">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th><i class="material-icons s-hflex-end">settings</i></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${teams}" var="team" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td><c:out value="${team.name}" /></td>
                            <td>
                                <div class="s-hflex-end">
                                    <div class="s-vflex-center">
                                        <a href="/admin/teams/update/<c:out value="${team.id}" />"><i class="material-icons">edit</i></a>
                                    </div>
                                    <form action="/admin/teams/delete/<c:out value="${team.id}" />" method="post" style="margin-bottom: 0px">
                                        <input type="hidden" name="id" value="<c:out value="${team.id}" />">
                                        <button type="submit" class="btn-flat m0">
                                            <i class="material-icons">delete</i>
                                        </button>
                                    </form>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>