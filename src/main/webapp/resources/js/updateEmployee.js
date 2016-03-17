/**
 * @author leo
 * @date 31/05/15 21:57
 */
function handleClick() {
	$(this).siblings().on("click", handleClick);
	$(this).off("click");
	//console.log($(this).attr("value"));
	var empId = $(this).closest("tr").find("td:nth-child(1)").text();
	var firstName = $(this).closest("tr").find("td:nth-child(2)").text();
	var lastName = $(this).closest("tr").find("td:nth-child(3)").text();
	//console.log("Update " + empId + " to :" + firstName + ", " + lastName);
	$.post("UpdateEmployee", {"empID": empId, "firstName": firstName, "lastName": lastName},
		function () {
		}, "json");
}

$(document).ready(function () {
	$("button").on("click", handleClick);
});