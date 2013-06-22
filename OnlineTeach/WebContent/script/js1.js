 // JavaScript Document
function mainNavExchange(mainNav, activePane) {
	
    var allSubNavItem = document.getElementsByClassName("subMainNavItem");
    for (var i = 0; i < allSubNavItem.length; i++) {
        allSubNavItem.item(i).style.display = "none";
    }
    document.getElementById(activePane).style.display = "block";

    var allAMainNavItem = document.getElementsByClassName("aMainNavItem");
    for (var i = 0; i < allAMainNavItem.length; i++) {
        allAMainNavItem.item(i).className = "aMainNavItem";
    }
    document.getElementById(mainNav).className = "aMainNavItem aMainNavItemActive";

}





