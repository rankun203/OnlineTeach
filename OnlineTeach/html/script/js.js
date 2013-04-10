 // JavaScript Document
function mainNavExchange(mainNav, activePane) {
    var allSubNavItem = document.getElementsByClassName("subMainNavItem");
    for (var i = 0; i < allSubNavItem.length; i++) {
        allSubNavItem.item(i).style.display = "none";
    }
    document.getElementById(activePane).style.display = "block";
    
    document.getElementById("mainNavA").className = "aMainNavItem";
    document.getElementById("mainNavB").className = "aMainNavItem";
    document.getElementById("mainNavC").className = "aMainNavItem";
    document.getElementById("mainNavD").className = "aMainNavItem";
    
    document.getElementById(mainNav).className = "aMainNavItem aMainNavItemActive";
}


//id get
function idg(idname) {
    return document.getElementById(idname);
}




