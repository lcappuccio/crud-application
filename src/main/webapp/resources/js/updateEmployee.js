/**
 * Created by leo on 31/05/15.
 */
$('#updateEmployeeTable tr').each(function () {
    var customerId = $(this).find(".empID").html();
    var customerIdRaw = $(this).find("td").eq(1).html();
    console.log(customerId);
    console.log(customerIdRaw);
});

$(document).ready(function(){
    $("button").on('click', handleClick);
});
function handleClick()
{
    $(this).siblings().on('click', handleClick);
    $(this).off('click');
    console.log($(this).attr("value"));
    var id = $(this).closest("tr").find("td").eq(1).text();
    console.log("Id is " + id);
}