function refreshPage() {
	var ticketLast = $("#ticket_last");
	$.get("ticket/getNumOfTicket.do", {id:"0"}, function (data, status){
		ticketLast.text(data);
	});
}