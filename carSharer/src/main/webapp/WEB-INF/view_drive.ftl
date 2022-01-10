<html>
<head>
	<title>Drive Details</title>
</head>
<body>

		<div style="border:4px dashed green;padding:15px;width:350px;margin:10px;box-sizing: content-box;">
			<div style="text-align:center; padding:15px">
				<a  href = "/view_drive">
					<img id = my_img src= "" alt="Error while loading the icon" width="50px" >
					<script>
						var link = document.getElementById('view_drive'); 
						const queryString = window.location.search;
						const urlParams = new URLSearchParams(queryString);
						const icon = urlParams.get('icon');
						my_img.src = icon
					</script>	
				</a>
				
			</div>
			
			<div style="color:grey"><b>Driver E-Mail : </b>   	${mail}</div>
			<div style="color:grey"><b>Date And Time :</b>    	${trip.getDateTime()}</div>
			<div style="color:grey"><b>Start : </b>  			${trip.getStartAddress()}</div>
			<div style="color:grey"><b>Destination : </b>  			${trip.getEndAddress()}</div>
			<div style="color:grey"><b>Free Seats</b>  	${free_seats}</div>
			<div style="color:grey"><b>Cost   : </b> 			${trip.getCost()}</div>
			<div style="color:grey"><b>Status   : </b>  		${trip.getStatus()}</div>
			<div style="color:grey"><b>Description  : </b>  	${trip.getDescription()}</div>
		</div>
		<h1>Actions</h1>
		<div>Number of Reservations: <input style="width:60px" type="number" name="Reservations" min="1" max="2"></div>
		<div>
			<button style="color:brown" type = "button"><b>Delete Trip</b></button>
			<button style="color:green"type = "button"><b>Book Trip</b></button>
		</div>
		

</body>
</html>
