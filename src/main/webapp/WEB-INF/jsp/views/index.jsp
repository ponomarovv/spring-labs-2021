<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="row">
        <div class="col s12">
            <div class="s-hflex">
                <div class="s-hflex-start">
                    <form action="" method="get" class="s-hflex-end" style="margin-bottom: 10px">
                        <div class="input-field" style="margin-bottom: 0px;">
                            <input id="team-name" type="text" name="team-name" class="validate" style="margin: 0px;" value="${teamName}">
                            <label for="team-name">Team Name</label>
                        </div>
                        <div class="s-vflex-end px10">
                            <button type="submit" class="waves-effect waves-light btn">Confirm</button>
                        </div>
                    </form>
                </div>
                <div class="equal-flex"></div>
                <div class="s-vflex-end mb10">
                    <a href="${'/admin/games'}" class="waves-effect waves-light btn"><i class="material-icons right">add</i> Create</a>
                </div>
            </div>
        </div>
        <div class="col s12">
            <table class="striped">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>First Team</th>
                        <th>Second Team</th>
                        <th>Sport</th>
                        <th>Date</th>
                        <th>Score</th>
                        <th><i class="material-icons s-hflex-end">settings</i></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${games}" var="game" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${game.firstTeam.name}</td>
                            <td>${game.secondTeam.name}</td>
                            <td class="weight-normal">${game.sport.name}</td>
                            <td>${game.date}</td>
                            <td>${game.firstTeamScore} : ${game.secondTeamScore}</td>
                            <td>
                                <div class="s-hflex-end">
                                    <div class="s-vflex-center">
                                        <a href="/admin/games/update/${game.id}"><i class="material-icons">edit</i>
                                        </a>
                                    </div>
                                    <form action="/admin/games/delete/${game.id}" method="post" style="margin-bottom: 0px">
                                        <input type="hidden" name="id" value="${game.id}">
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