document.addEventListener("DOMContentLoaded", event => {
    const pathname = document.location.pathname;
    const title = getTitleByPathname(pathname);
    document.title = title;
});

const getTitleByPathname = pathname => {
    if (pathname === "/admin/games" || pathname.startsWith("/admin/games/update/")) {
        return "Game";
    } else if (pathname.startsWith("/admin/sports") || pathname.startsWith("/admin/sports/delete")) {
        return "Sports";
    } else if (pathname.startsWith("/admin/sports/update/")) {
        return "Update sport";
    } else if (pathname.startsWith("/admin/teams") || pathname.startsWith("/admin/teams/delete")) {
        return "Teams";
    } else if (pathname.startsWith("/admin/teams/update/")) {
        return "Update team";
    }
    return "Games Schedule";
}