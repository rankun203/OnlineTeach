$(".switch-arrow").click(function () {
	var thisPane = $(this).parent();
	if(thisPane.hasClass("closed")) {
		thisPane.removeClass("closed");
		thisPane.addClass("spread");
	} else if (thisPane.hasClass("spread")) {
		thisPane.removeClass("spread");
		thisPane.addClass("closed");
	}
});
var teacherRemark = {
	postRemark : function () {
	}
};