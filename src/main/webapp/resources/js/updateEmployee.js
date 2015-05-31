/**
 * Created by leo on 31/05/15.
 */
$('#updateEmployeeTable tr').each(function () {
    var customerId = $(this).find(".empID").html();
    var customerIdRaw = $(this).find("td").eq(1).html();
    console.log(customerId);
    console.log(customerIdRaw);
});

$(function() {
    $('#empID').click(function () {
        console.log("Clicked " + $(this).attr("value"));
    });
})